package ru.javabegin.training.web.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class IndexController {
    
    private int bookIndex = -1;

    public int getBookIndex() {
        return bookIndex;
    }
    
    public int getIncrementBookIndex() {
        return ++bookIndex;
    }   

}
