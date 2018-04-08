package com.netcracker.entities;

import java.util.List;
import java.util.UUID;

public class PublishingHouse {

    private final String publishingHouseId;

    private String houseName;
    private List<Book> bookList;

    public PublishingHouse() {
        this.publishingHouseId = UUID.randomUUID().toString();
    }

    public PublishingHouse(String pubHouseId,String houseName){

        if(pubHouseId == null) {
            this.publishingHouseId = UUID.randomUUID().toString();
        }
        else{
            this.publishingHouseId = pubHouseId;
        }

        this.houseName = houseName;


    }


    public String getPublishingHouseId() {
        return publishingHouseId;
    }


    public String getHouseName() {
        return houseName;
    }

    public List<Book> getPublishedBooks() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    @Override
    public String toString(){
        return "Publishing House{" + "\n"+
                "House Name: " + houseName+ "\n" + "}";
    }
}
