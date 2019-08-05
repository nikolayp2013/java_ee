package ru.javabegin.training.web.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import ru.javabegin.training.web.comparators.ListComparator;
import ru.javabegin.training.web.db.DataHelper;
import ru.javabegin.training.web.entity.Author;

@ManagedBean(eager = false)
@ApplicationScoped
public class AuthorController implements Serializable, Converter {

    private List<SelectItem> selectItems = new ArrayList<SelectItem>();;
    private Map<Long,Author> map;
    private List<Author> list;


    public AuthorController() {
        map = new HashMap<Long, Author>();
        list = DataHelper.getInstance().getAllAuthors();       
        Collections.sort(list, ListComparator.getInstance());
        
        for (Author author : list) {
            map.put(author.getId(), author);
            selectItems.add(new SelectItem(author, author.getFio()));
        }
    }
    
    public List<Author> getAuthorList(){
        return list;
    }

    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return map.get(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Author)value).getId().toString();
    }

    

}
