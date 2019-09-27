package ru.javabegin.training.web.controllers;

import java.io.Serializable;
import java.util.Map;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.PrimeFaces;
import org.primefaces.component.datagrid.DataGrid;
import org.primefaces.model.LazyDataModel;
import ru.javabegin.training.web.beans.Pager;
import ru.javabegin.training.web.db.DataHelper;
import ru.javabegin.training.web.entity.ext.BookExt;
import ru.javabegin.training.web.enums.SearchType;
import ru.javabegin.training.web.models.BookListDataModel;

@ManagedBean(eager = true)
@SessionScoped
public class BookListController implements Serializable {

    private DataGrid dataTable;
    private BookExt selectedBook;
    private BookExt newBook;
    private transient DataHelper dataHelper;
    private LazyDataModel<BookExt> bookListModel;
    private Long selectedAuthorId;// текущий автор книги из списка при редактировании книги
    // критерии поиска
    private char selectedLetter; // выбранная буква алфавита, по умолчанию не выбрана ни одна буква
    private SearchType selectedSearchType = SearchType.TITLE;// хранит выбранный тип поиска, по-умолчанию - по названию
    private long selectedGenreId; // выбранный жанр
    private String currentSearchString; // хранит поисковую строку
    private Pager pager;
    //-------
    private boolean editModeView;// отображение режима редактирования
    private boolean addModeView;// отображение режима добавление
    
//    private SessionUtil sessionUtil;

    public BookListController() {
//        sessionUtil = (SessionUtil)SessionUtil.getController("SessionUtil");
        pager = new Pager();
        dataHelper = new DataHelper(pager);
        bookListModel = new BookListDataModel(dataHelper, pager);
    }

    public DataHelper getDataHelper() {
        return dataHelper;
    }
    
    public Pager getPager(){
        return pager;
    }

    private void submitValues(Character selectedLetter, long selectedGenreId) {
        this.selectedLetter = selectedLetter;
        this.selectedGenreId = selectedGenreId;
        dataTable.setFirst(0);
    }

    //<editor-fold defaultstate="collapsed" desc="запросы в базу">
    private void fillBooksAll() {
        dataHelper.getAllBooks();
    }

    public void fillBooksByGenre() {

        imitateLoading();

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        selectedGenreId = Long.valueOf(params.get("genre_id"));
        submitValues(' ', selectedGenreId);
        dataHelper.getBooksByGenre(selectedGenreId);

    }
    
     public void fillBooksByRate() {

        imitateLoading();
        dataHelper.getBooksByRate();

    }

    public void fillBooksByLetter() {

        imitateLoading();

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        selectedLetter = params.get("letter").charAt(0);
        submitValues(selectedLetter, -1);
        dataHelper.getBooksByLetter(selectedLetter);

    }

    public void fillBooksBySearch() {

        imitateLoading();

        submitValues(' ', -1);

        if (currentSearchString.trim().length() == 0) {
            fillBooksAll();

        }

        if (selectedSearchType == SearchType.AUTHOR) {
            dataHelper.getBooksByAuthor(currentSearchString);
        } else if (selectedSearchType == SearchType.TITLE) {
            dataHelper.getBooksByName(currentSearchString);
        }

    }

    public void updateBook() {

        dataHelper.updateBook(selectedBook);
        cancelEditMode();
        dataHelper.populateList();

//        RequestContext.getCurrentInstance().execute("dlgEditBook.hide()");
        PrimeFaces.current().executeScript("PF('dlgEditBook').hide();");

        ResourceBundle bundle = ResourceBundle.getBundle("ru.javabegin.training.web.nls.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(bundle.getString("updated")));

        dataTable.setFirst(calcSelectedPage());

    }


    public void deleteBook() {
        dataHelper.deleteBook(selectedBook);
        dataHelper.populateList();

//        RequestContext.getCurrentInstance().execute("dlgDeleteBook.hide()");
        ResourceBundle bundle = ResourceBundle.getBundle("ru.javabegin.training.web.nls.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(bundle.getString("deleted")));

        dataTable.setFirst(calcSelectedPage());

    }

    public void rate() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int bookIndex = Integer.parseInt(params.get("bookIndex"));

        FacesContext facesContext = FacesContext.getCurrentInstance();
        String username = facesContext.getExternalContext().getUserPrincipal().getName();

        BookExt book = pager.getList().get(bookIndex);

        dataHelper.rateBook(book, username);

    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="режим редактирования">
    public void cancelEditMode() {
        editModeView = false;
    }

    public void switchEditMode() {
        editModeView = true;
        //RequestContext.getCurrentInstance().execute("dlgEditBook.show()");
        PrimeFaces.current().executeScript("PF('dlgEditBook').show();");

    }

    public void cancelAddMode() {
        addModeView = false;
    }

    

    //</editor-fold>
    public Character[] getRussianLetters() {
        Character[] letters = new Character[]{'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я',};
        return letters;
    }

    public void searchStringChanged(ValueChangeEvent e) {
        currentSearchString = e.getNewValue().toString();
    }

    public void searchTypeChanged(ValueChangeEvent e) {
        selectedSearchType = (SearchType) e.getNewValue();
    }

    private int calcSelectedPage() {
        int page = dataTable.getPage();// текущий номер страницы (индексация с нуля)

        int leftBound = pager.getTo() * (page - 1);
        int rightBound = pager.getTo() * page;

        boolean goPrevPage = pager.getTotalBooksCount() > leftBound & pager.getTotalBooksCount() <= rightBound;


        if (goPrevPage) {
            page--;
        }

        return (page > 0) ? page * pager.getTo() : 0;
    }

    //<editor-fold defaultstate="collapsed" desc="гетеры сетеры">
    public boolean isEditMode() {
        return editModeView;
    }

    public boolean isAddMode() {
        return addModeView;
    }

    public String getSearchString() {
        return currentSearchString;
    }

    public void setSearchString(String searchString) {
        this.currentSearchString = searchString;
    }

    public SearchType getSearchType() {
        return selectedSearchType;
    }

    public void setSearchType(SearchType searchType) {
        this.selectedSearchType = searchType;
    }

    public long getSelectedGenreId() {
        return selectedGenreId;
    }

    public void setSelectedGenreId(int selectedGenreId) {
        this.selectedGenreId = selectedGenreId;
    }

    public char getSelectedLetter() {
        return selectedLetter;
    }

    public void setSelectedLetter(char selectedLetter) {
        this.selectedLetter = selectedLetter;
    }

    public Long getSelectedAuthorId() {
        return selectedAuthorId;
    }

    public void setSelectedAuthorId(Long selectedAuthorId) {
        this.selectedAuthorId = selectedAuthorId;
    }

  
    public LazyDataModel<BookExt> getBookListModel() {
        return bookListModel;
    }

    public void setSelectedBook(BookExt selectedBook) {
        this.selectedBook = selectedBook;
    }

    public BookExt getSelectedBook() {
        return selectedBook;
    }

    public DataGrid getDataGrid() {
        return dataTable;
    }

    public void setDataGrid(DataGrid dataTable) {
        this.dataTable = dataTable;
    }

    public BookExt getNewBook() {
        if (newBook == null) {
            newBook = new BookExt();
        }
        return newBook;
    }

    public void setNewBook(BookExt newBook) {
        this.newBook = newBook;
    }

    //</editor-fold>
    private void imitateLoading() {
//        try {
//            Thread.sleep(1000);// имитация загрузки процесса
//        } catch (InterruptedException ex) {
//            Logger.getLogger(BookListController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
