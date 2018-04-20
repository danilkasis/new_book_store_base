package com.netcracker.entities;

import java.util.List;
import java.util.UUID;

public class Book {

    private final String bookId;
    private String publishingHouseId;

    private Author author;
    private PublishingHouse publishingHouse;
    private String bookName;
    private String publishingDate;
    private String booksLanguage;
    private List<Store> storeList;


    public Book() {
        this.bookId = UUID.randomUUID().toString();
    }

    public Book(String bookId, String bookName, String publishingDate, String language,Author author,
                PublishingHouse publishingHouse) {

        if(bookId == null) {
            this.bookId = UUID.randomUUID().toString();
        }
        else{
            this.bookId = bookId;
        }

        if(publishingHouse == null) {
           this.publishingHouseId = null;
        }
        else{
            this.publishingHouseId = publishingHouse.getPublishingHouseId();
        }

        this.bookName = bookName;
        this.publishingDate = publishingDate;
        this.booksLanguage = language;

        this.author = author;
        this.publishingHouse = publishingHouse;


    }

    public String getPublishingHouseId() {
        return publishingHouseId;
    }

    public void setPublishingHouseId(String publishingHouseId) {
        publishingHouseId = publishingHouseId;
    }

    public String getBookId() {
        return bookId;
    }

    public Author getAuthor() {
        return author;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public String getBookName() {
        return bookName;
    }

    public String getPublishingDate() {
        return publishingDate;
    }

    public String getBooksLanguage() {
        return booksLanguage;
    }

    public List<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setPublishingDate(String publishingDate) {
        this.publishingDate = publishingDate;
    }

    public void setBooksLanguage(String booksLanguage) {
        this.booksLanguage = booksLanguage;
    }

    @Override
    public String toString(){
        if(this == null){
            System.out.println("Error,Book is null");
            return null;
        }
        else{
            return  "Name:"+bookName+"\n"+"Language:"+booksLanguage+
                    "\n"+"Publishing house:" + publishingHouse;
        }

    }
}
