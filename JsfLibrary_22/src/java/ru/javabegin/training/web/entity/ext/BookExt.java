package ru.javabegin.training.web.entity.ext;

import ru.javabegin.training.web.entity.Book;

public class BookExt extends Book {

    public BookExt() {
        setVoteCount(0L);
        setRating(0);
    }
    
    private byte[] uploadedImage;
    private byte[] uploadedContent;

    public byte[] getUploadedContent() {
        return uploadedContent;
    }

    public void setUploadedContent(byte[] uploadedContent) {
        this.uploadedContent = uploadedContent;
    }

    public byte[] getUploadedImage() {
        return uploadedImage;
    }

    public void setUploadedImage(byte[] uploadedImage) {
        this.uploadedImage = uploadedImage;
    }
    
    
    
    public Book getBook(){
        Book book = new Book();
        book.setAuthor(getAuthor());
        book.setContent(getUploadedContent());// записываем загруженный контент
        book.setDescr(getDescr());
        book.setGenre(getGenre());
        book.setImage(getUploadedImage());// записываем загруженное изображение
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
