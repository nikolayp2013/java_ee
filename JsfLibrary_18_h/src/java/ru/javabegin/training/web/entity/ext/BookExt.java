package ru.javabegin.training.web.entity.ext;

import java.io.Serializable;

public class BookExt extends ru.javabegin.training.web.entity.Book implements Serializable{

    private boolean imageEdited;
    private boolean contentEdited;

    public void setImageEdited(boolean imageEdited) {
        this.imageEdited = imageEdited;
    }

    public boolean isImageEdited() {
        return imageEdited;
    }

    public void setContentEdited(boolean contentEdited) {
        this.contentEdited = contentEdited;
    }

    public boolean isContentEdited() {
        return contentEdited;
    }
    
    
    
}
