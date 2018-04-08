package com.netcracker.entities;

import java.util.UUID;

public class HelpBookStore {

    private final String tableId;
    private String bookId;
    private String storeId;

    private Book bk;
    private Store str;


    public HelpBookStore() {
        this.tableId = UUID.randomUUID().toString();
    }

    public HelpBookStore(String tableId, Book book, Store store) {
        if (tableId == null) {
            this.tableId = UUID.randomUUID().toString();
        } else {
            this.tableId = tableId;
        }

        if (book == null) {
            this.bookId = null;
        } else {
            this.bookId = book.getBookId();
        }

        if (store == null) {
            this.storeId = null;
        } else {
            this.storeId = store.getStoreId();
        }

        this.bk = book;
        this.str = store;

    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public void setBk(Book bk) {
        this.bk = bk;
    }

    public void setStr(Store str) {
        this.str = str;
    }

    public String getTableId() {
        return tableId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getStoreId() {
        return storeId;
    }

    public Book getBk() {
        return bk;
    }

    public Store getStr() {
        return str;
    }
}
