//package com.netcracker;
//
//import com.netcracker.entities.Book;
//import com.netcracker.entities.Author;
//import com.netcracker.infrastructure.repositories.*;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args){
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//
//        StoreRepository repositoryStore = context.getBean(StoreRepository.class);
//        StoreRepository storeRepository = new StoreRepository();
//        System.out.printf(storeRepository.loadById("1"));
//
//    }
//}
