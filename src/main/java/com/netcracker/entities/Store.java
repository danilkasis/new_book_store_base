package com.netcracker.entities;

import java.util.List;
import java.util.UUID;

public class Store {

    private final String storeId;


    private String streetName;
    private String numberOfHouse;
    private String storeName;


    private List<Book> bookList;



    public Store(String storeId, String storeName, String streetName, String numberOfHouse){

        if(storeId == null){
            this.storeId = UUID.randomUUID().toString();
        }
        else{
            this.storeId = storeId;
        }

        this.storeName = storeName;
        this.numberOfHouse = numberOfHouse;
        this.streetName = streetName;


    }


    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Store() {
        this.storeId = UUID.randomUUID().toString();
    }

    public String getStoreId() {
        return storeId;
    }


    public String getStreetName() {
        return streetName;
    }

    public String getNumberOfHouse() {
        return numberOfHouse;
    }

    public String getStoreName() {
        return storeName;
    }

    public List<Book> getBookList() {
        return bookList;
    }


    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setNumberOfHouse(String numberOfHouse) {
        this.numberOfHouse = numberOfHouse;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public String toString(){
        return "Store{" + " \n" + "Store Name: " + storeName + "\n" +
                "Adress: "+ streetName + " " + numberOfHouse + "\n" + "}";
    }
}
