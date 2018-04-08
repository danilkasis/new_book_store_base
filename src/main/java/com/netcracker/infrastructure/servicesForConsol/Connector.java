//package com.netcracker.infrastructure.servicesForConsol;
//
//import com.netcracker.infrastructure.repositories.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Connector {
//
//    @Autowired
//    AuthorRepository authorRepository;
//    BookRepository bookRepository;
//    PublishingHouseRepository pubHouseRepository;
//    StoreRepository storeRepository;
//    HelpRepository helpRepository;
//
//    public Connector(BookRepository bookRepository, AuthorRepository authorRepository,
//                     PublishingHouseRepository pubHouseRepository, StoreRepository storeRepository,
//                     HelpRepository helpRepository) {
//        this.bookRepository = bookRepository;
//        this.authorRepository = authorRepository;
//        this.pubHouseRepository = pubHouseRepository;
//        this.storeRepository = storeRepository;
//        this.helpRepository = helpRepository;
//    }
//
//    public BookRepository getBookRepository() {
//        return bookRepository;
//    }
//
//    public AuthorRepository getAuthorRepository() {
//        return authorRepository;
//    }
//
//    public PublishingHouseRepository getPubHouseRepository() {
//        return pubHouseRepository;
//    }
//
//    public StoreRepository getStoreRepository() {
//        return storeRepository;
//    }
//
//    public HelpRepository getHelpRepository() {
//        return helpRepository;
//    }
//}
