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
import ru.javabegin.training.web.entity.Genre;

@ManagedBean(eager = false)
@ApplicationScoped
public class GenreController implements Serializable, Converter {

    private List<SelectItem> selectItems = new ArrayList<SelectItem>();
    private Map<Long, Genre> map;
    private List<Genre> list;

    public GenreController() {

        map = new HashMap<Long, Genre>();
        list = DataHelper.getInstance().getAllGenres();
        Collections.sort(list, ListComparator.getInstance());

        for (Genre genre : list) {
            map.put(genre.getId(), genre);
            selectItems.add(new SelectItem(genre, genre.getName()));
        }

    }

    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

    public List<Genre> getGenreList() {
        return list;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return map.get(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Genre)value).getId().toString();
    }
    
    
}
