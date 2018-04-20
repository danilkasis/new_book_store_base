package com.netcracker.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netcracker.entities.Author;
import com.netcracker.entities.Book;
import com.netcracker.services.AuthorService;
import com.netcracker.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class BookController {


    @Autowired
    public BookService bookService;

    @RequestMapping(value = "/books/POST", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addBook(@RequestBody String string){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Book book = mapper.readValue(string, Book.class);
            bookService.insert(book);
            return "Book added";
        }catch(IOException e){
            System.out.printf("IOExeption");
            return "Trable with parse JSON format";
        }
    }

    @RequestMapping(value = "/books/GET", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> loadAllBooks(){
        List<Book> newList = bookService.loadAll();
        return newList;
    }

    @RequestMapping(value = "/books/GET/houseId/{houseId}", method = RequestMethod.GET)
    public List<Book> loadByHouseId(@PathVariable("houseId") String houseId){
        List<Book> newList = bookService.loadByHouseId(houseId);
        return newList;
    }

    @RequestMapping(value = "/books/GET/name/{name}", method = RequestMethod.GET)
    public List<Book> loadByName(@PathVariable("name") String name){
        List<Book> newList = bookService.loadByName(name);
        return newList;
    }

    @RequestMapping(value = "/books/GET/date/{date}", method = RequestMethod.GET)
    public List<Book> loadByDate(@PathVariable("date") String date){
        List<Book> newList = bookService.loadByDate(date);
        return newList;
    }

    @RequestMapping(value = "/books/GET/language/{language}", method = RequestMethod.GET)
    public List<Book> loadBLanguage(@PathVariable("language") String language){
        List<Book> newList = bookService.loadByLanguagge(language);
        return newList;
    }

    @RequestMapping(value = "/books/{id}GET", method = RequestMethod.GET)
    public Book loadById(@PathVariable("id") String id){
        Book newBook = bookService.loadById(id);
        return newBook;
    }

    @RequestMapping(value = "/books/DELETE/name/{name}", method = RequestMethod.DELETE)
    public String deleteByName(@PathVariable("name") String name) {
        bookService.deleteByName(name);
        return "WAS DELETE";
    }

    @RequestMapping(value = "/books/DELETE/language/{language}", method = RequestMethod.DELETE)
    public String deleteByLanguage(@PathVariable("language") String language) {
        bookService.deleteByLanguage(language);
        return "WAS DELETE";
    }

    @RequestMapping(value = "/books/DELETE/date/{date}", method = RequestMethod.DELETE)
    public String deleteByDate(@PathVariable("date") String date) {
        bookService.deleteByDate(date);
        return "WAS DELETE";
    }

    @RequestMapping(value = "/books/DELETE", method = RequestMethod.DELETE)
    public String deleteAll() {
        bookService.deleteAll();
        return "ALL AUTHORS WAS DELETE";
    }

    @RequestMapping(value = "/books/{id}DELETE", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") String id) {
        bookService.deleteById(id);
        return "WAS DELETE";
    }

    @RequestMapping(value = "/bookstore/GET/{id}GET", method = RequestMethod.GET)
    public Book loadByIdWithStore(@PathVariable("id") String id){
        Book book = bookService.loadByIdWithStore(id);
        return book;
    }

}
