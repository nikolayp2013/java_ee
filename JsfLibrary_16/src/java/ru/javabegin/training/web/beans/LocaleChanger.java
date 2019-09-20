package ru.javabegin.training.web.beans;

import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(eager=true)
@SessionScoped
public class LocaleChanger implements Serializable {    

    private Locale currentLocale;

    @PostConstruct
    public void LocaleChanger() {
        currentLocale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
    }

    public void changeLocale(String localeCode) {
        currentLocale = new Locale(localeCode);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(currentLocale);
    }

    public Locale getCurrentLocale() {
        return currentLocale;
       
    }


}

