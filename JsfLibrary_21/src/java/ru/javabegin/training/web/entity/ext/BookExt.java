package ru.javabegin.training.web.entity.ext;

import ru.javabegin.training.web.entity.Book;

public class BookExt extends Book {

    public BookExt() {
        setVoteCount(0L);
        setRating(0);
    }
    
    

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
    
    public Book getBook(){
        Book book = new Book();
        book.setAuthor(getAuthor());
        book.setContent(getContent());
        book.setDescr(getDescr());
        book.setGenre(getGenre());
        book.setImage(getImage());
        book.setIsbn(getIsbn());
        book.setName(getName());
        book.setPageCount(getPageCount());
        book.setPublishYear(getPublishYear());
        book.setPublisher(getPublisher());
        book.setRating(getRating());
        book.setVoteCount(getVoteCount());
        book.setVotes(getVotes());
        return book;
    }
    
}
