package ru.javabegin.training.web.models;

import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;  
import ru.javabegin.training.web.beans.Pager;
import ru.javabegin.training.web.db.DataHelper;
import ru.javabegin.training.web.entity.Book;


public class BookListDataModel extends LazyDataModel<Book> {  
    
    private List<Book> bookList;
    private DataHelper dataHelper = DataHelper.getInstance();
    private Pager pager = Pager.getInstance();

    public BookListDataModel() {
        
    }
    
    

      
    @Override  
    public Book getRowData(String rowKey) {      
        
        for(Book book : bookList) {  
            if(book.getId().intValue() == Long.valueOf(rowKey).intValue())  
                return book;  
        }  
  
        return null;  
    }  
  
    @Override  
    public Object getRowKey(Book book) {  
        return book.getId();  
    }  
   
  
//    @Override  
//    public List<Book> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {   
//        
//        pager.setFrom(first);
//        pager.setTo(pageSize);
//     
//        dataHelper.populateList();
//
//        this.setRowCount(pager.getTotalBooksCount());  
//       
//        
//        return pager.getList();
//        
//    }

    @Override
    public List<Book> load(int first, int pageSize, List<SortMeta> multiSortMeta, Map<String, Object> filters) {
        //return super.load(first, pageSize, multiSortMeta, filters); //To change body of generated methods, choose Tools | Templates.
        
        pager.setFrom(first);
        pager.setTo(pageSize);
     
        dataHelper.populateList();

        this.setRowCount(pager.getTotalBooksCount());  
       
        
        return pager.getList();
        
    }

    @Override
    public List<Book> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        //return super.load(first, pageSize, sortField, sortOrder, filters); //To change body of generated methods, choose Tools | Templates.
        
        pager.setFrom(first);
        pager.setTo(pageSize);
     
        dataHelper.populateList();

        this.setRowCount(pager.getTotalBooksCount());  
       
        
        return pager.getList();
        
    }
    

        
}  
