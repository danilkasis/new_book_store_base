package com.netcracker.entities;

import java.util.UUID;

public class Author {

    private final String authorId;
    private String bookId;

    private String firstName;
    private String lastName;
    private String fatherName;

    private Book book;

    public Author() {
        this.authorId = UUID.randomUUID().toString();
    }

    public Author(String authorId, Book book, String firstName, String fatherName, String lastName){

        if(authorId == null) {
            this.authorId = UUID.randomUUID().toString();
        }
        else{
            this.authorId = authorId;
        }

        if(book == null){
            this.bookId = null;
        }
        else{
            this.bookId = book.getBookId();
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.book = book;

    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    @Override
    public String toString(){
        if(this == null){
            System.out.println("Error, Author is null");
            return null;
        }
        else{
            return "Author: " + firstName + " " + fatherName + " " + lastName;
        }

    }

}
