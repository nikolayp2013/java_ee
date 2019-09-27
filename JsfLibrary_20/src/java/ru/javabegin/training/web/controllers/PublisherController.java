package ru.javabegin.training.web.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import ru.javabegin.training.web.beans.Pager;
import ru.javabegin.training.web.comparators.ListComparator;
import ru.javabegin.training.web.db.DataHelper;
import ru.javabegin.training.web.entity.ext.GenreExt;
import ru.javabegin.training.web.entity.ext.PublisherExt;

@ManagedBean
@SessionScoped
public class PublisherController implements Serializable, Converter {

    private List<SelectItem> selectItems = new ArrayList<SelectItem>();
    private Map<Long, PublisherExt> map;
    private List<PublisherExt> list;
    private Pager pager;
    private DataHelper dataHelper;
    @ManagedProperty(value = "#{bookListController}")
    private BookListController bookListController;

    @PostConstruct
    public void init() {
        pager = bookListController.getPager();
        dataHelper = bookListController.getDataHelper();

        map = new HashMap<Long, PublisherExt>();
        list = dataHelper.getAllPublishers();

        Collections.sort(list, ListComparator.getInstance());

        for (PublisherExt publisher : list) {
            map.put(publisher.getId(), publisher);
            selectItems.add(new SelectItem(publisher, publisher.getName()));
        }

    }

    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

    public List<PublisherExt> getPublisherList() {
        return list;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return map.get(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((PublisherExt) value).getId().toString();
    }

    public BookListController getBookListController() {
        return bookListController;
    }

    public void setBookListController(BookListController bookListController) {
        this.bookListController = bookListController;
    }
}
