//package com.netcracker;
//
//import com.netcracker.entities.Book;
//import com.netcracker.entities.Author;
//import com.netcracker.infrastructure.repositories.*;
//import com.netcracker.infrastructure.servicesForConsol.Controller;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args){
//        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//
//        /*AuthorRepository repositoryAuthor = context.getBean(AuthorRepository.class);
//        BookRepository repositoryBook = context.getBean(BookRepository.class);
//        PublishingHouseRepository repositoryPubHouse = context.getBean(PublishingHouseRepository.class);
//        StoreRepository repositoryStore = context.getBean(StoreRepository.class);
//        HelpRepository repositoryHelp = context.getBean(HelpRepository.class);
//*/
//
////        AuthorRepositoryWithoutSPRING repositoryJDBC = context.getBean(AuthorRepositoryWithoutSPRING.class);
////        BookRepository repositoryBook = context.getBean(BookRepository.class);
////
////        Book book1 = new Book(null,"C++ for Students","1994","Russian",null,null);
////        Book book2 = new Book(null,"Java Man","2000","Russian",null,null);
////        Book book3 = new Book(null,"Azanov's life","2016","Russian",null,null);
////
////        Author author1 = new Author(null,book1,"Anatolii","Ivanovich","Minin");
////        Author author2 = new Author(null,book2,"Kirill","Leonidovich","Tassov");
////        Author author3 = new Author(null,book3,"Ivan","Netckrackerovich","Azanov");
////
////        book1.setAuthor(author1);
////        book2.setAuthor(author2);
////        book3.setAuthor(author3);
////
////        repositoryBook.insert(book1);
////        repositoryBook.insert(book2);
////        repositoryBook.insert(book3);
////
////        repositoryJDBC.insert(author1);
////        repositoryJDBC.insert(author2);
////        repositoryJDBC.insert(author3);
////        System.out.println(author1.getBookId());
////
////
////        List<Author> myList = new ArrayList() ;
////        Author test = new Author();
////
////
////        myList = repositoryJDBC.loadAll();
////        System.out.println("===============LOAD ALL==============="+"\n");
////        for(Author au: myList){
////            System.out.println(au.getLastName()+ " " + au.getFirstName());
////        }
////        System.out.println("======================================"+"\n");
////
////
////        System.out.println("==============FIRST_NAME=============="+"\n");
////        myList = repositoryJDBC.loadByFirstName("Kirill");
////        for(Author au: myList){
////            System.out.println(au.getLastName()+ " " + au.getFirstName());
////        }
////        System.out.println("======================================"+"\n");
////
////
////        System.out.println("==============LAST__NAME=============="+"\n");
////        myList = repositoryJDBC.loadByLastName("Minin");
////        for(Author au: myList){
////            System.out.println(au.getLastName()+ " " + au.getFirstName());
////        }
////        System.out.println("======================================"+"\n");
////
////
////        System.out.println("======================================"+"\n");
////        repositoryJDBC.deleteByLastName("Minin");
////        System.out.println("======================================"+"\n");
////
////
////        myList = repositoryJDBC.loadAll();
////        System.out.println("===============LOAD ALL==============="+"\n");
////        for(Author au: myList){
////            System.out.println(au.getLastName()+ " " + au.getFirstName());
////        }
////        System.out.println("======================================"+"\n");
////
////        myList = repositoryJDBC.loadAllWithBook();
////        System.out.println("===========LOAD_ALL_WITH_BOOK========="+"\n");
////        for(Author au: myList){
////            System.out.println(au.getLastName()+ " " + au.getFirstName() + " " + au.getBook().getBookName());
////        }
////        System.out.println("======================================"+"\n");
//
//        //repositoryJDBC.deleteAll();
//    }
//}
