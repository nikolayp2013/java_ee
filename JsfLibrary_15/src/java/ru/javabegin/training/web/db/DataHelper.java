package ru.javabegin.training.web.db;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import ru.javabegin.training.web.beans.Pager;
import ru.javabegin.training.web.entity.Author;
import ru.javabegin.training.web.entity.Book;
import ru.javabegin.training.web.entity.Genre;
import ru.javabegin.training.web.entity.HibernateUtil;
import ru.javabegin.training.web.entity.Publisher;

public class DataHelper {

    private SessionFactory sessionFactory = null;
    private static DataHelper dataHelper;
    private DetachedCriteria currentCriteria;
    private Pager currentPager;
    private ProjectionList bookProjection;

    private DataHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();

        bookProjection = Projections.projectionList();
        bookProjection.add(Projections.property("id"), "id");
        bookProjection.add(Projections.property("name"), "name");
        bookProjection.add(Projections.property("image"), "image");
        bookProjection.add(Projections.property("genre"), "genre");
        bookProjection.add(Projections.property("pageCount"), "pageCount");
        bookProjection.add(Projections.property("isbn"), "isbn");
        bookProjection.add(Projections.property("publisher"), "publisher");
        bookProjection.add(Projections.property("author"), "author");
        bookProjection.add(Projections.property("publishYear"), "publishYear");
        bookProjection.add(Projections.property("descr"), "descr");

    }

    public static DataHelper getInstance() {
        if (dataHelper == null) {
            dataHelper = new DataHelper();
        }
        return dataHelper;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<Genre> getAllGenres() {
        return getSession().createCriteria(Genre.class).list();
    }

    public List<Publisher> getAllPublishers() {
        return getSession().createCriteria(Publisher.class).list();
    }

    public List<Author> getAllAuthors() {
        return getSession().createCriteria(Author.class).list();
    }

    public Author getAuthor(long id) {
        return (Author) getSession().get(Author.class, id);
    }

    public void getAllBooks(Pager pager) {
        currentPager = pager;

        Criteria criteria = getSession().createCriteria(Book.class);
        Integer total = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
        currentPager.setTotalBooksCount(total);

        addAliases();
        runCurrentCriteria();



    }

    public void getBooksByGenre(Long genreId, Pager pager) {
        currentPager = pager;

        Criterion criterion = Restrictions.eq("genre.id", genreId);

        Criteria criteria = getSession().createCriteria(Book.class, "b").createAlias("b.genre", "genre");
        Integer total = (Integer) criteria.add(criterion).setProjection(Projections.rowCount()).uniqueResult();
        currentPager.setTotalBooksCount(total);

        addAliases();
        currentCriteria.add(criterion);

        runCurrentCriteria();
    }

    public void getBooksByLetter(Character letter, Pager pager) {
        currentPager = pager;

        Criterion criterion = Restrictions.ilike("b.name", letter.toString(), MatchMode.START);

        Criteria criteria = getSession().createCriteria(Book.class, "b");
        Integer total = (Integer) criteria.add(criterion).setProjection(Projections.rowCount()).uniqueResult();
        currentPager.setTotalBooksCount(total);

        addAliases();
        currentCriteria.add(criterion);

        runCurrentCriteria();
    }

    public void getBooksByAuthor(String authorName, Pager pager) {
        currentPager = pager;

        Criterion criterion = Restrictions.ilike("author.fio", authorName, MatchMode.ANYWHERE);

        Criteria criteria = getSession().createCriteria(Book.class, "b").createAlias("b.author", "author");
        Integer total = (Integer) criteria.add(criterion).setProjection(Projections.rowCount()).uniqueResult();
        currentPager.setTotalBooksCount(total);

        addAliases();
        currentCriteria.add(criterion);

        runCurrentCriteria();
    }

    public void getBooksByName(String bookName, Pager pager) {
        currentPager = pager;

        Criterion criterion = Restrictions.ilike("b.name", bookName, MatchMode.ANYWHERE);
        Criteria criteria = getSession().createCriteria(Book.class, "b");
        Integer total = (Integer) criteria.add(criterion).setProjection(Projections.rowCount()).uniqueResult();
        currentPager.setTotalBooksCount(total);


        addAliases();
        currentCriteria.add(criterion);

        runCurrentCriteria();
    }

    public byte[] getContent(Long id) {
        Criteria criteria = getSession().createCriteria(Book.class);
        criteria.setProjection(Property.forName("content"));
        criteria.add(Restrictions.eq("id", id));
        return (byte[]) criteria.uniqueResult();
    }

    public void runCurrentCriteria() {
        Criteria criteria = currentCriteria.addOrder(Order.asc("b.name")).getExecutableCriteria(getSession());

        criteria.setProjection(bookProjection).setResultTransformer(Transformers.aliasToBean(Book.class));

        List<Book> list = criteria.setFirstResult(currentPager.getFrom()).setMaxResults(currentPager.getTo()).list();
        currentPager.setList(list);
    }

    private void addAliases() {
        currentCriteria = DetachedCriteria.forClass(Book.class, "b");

        currentCriteria.createAlias("b.author", "author");
        currentCriteria.createAlias("b.genre", "genre");
        currentCriteria.createAlias("b.publisher", "publisher");


    }
    
    public void update(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        for (Object object : currentPager.getList()) {
            Book book = (Book)object;
            if (book.isEdit()){
                session.update(book);
            }
            
        }
        transaction.commit();
        session.flush();
        session.close();
        
    }
}