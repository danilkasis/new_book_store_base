package com.netcracker.controllers;

import com.netcracker.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.netcracker.entities.Author;
import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    public AuthorService authorService;

    @GetMapping("/")
    public String index() {
        return "READY";
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Author> loadAllAuthors(){
        List<Author> newList = authorService.loadAll();
        return newList;
    }

    @RequestMapping(value = "/authors/lastName/{lastName}", method = RequestMethod.GET)
    public List<Author> loadByLastName(@PathVariable("lastName") String lastName){
        List<Author> newList = authorService.loadByLastName(lastName);
        return newList;
    }

    @RequestMapping(value = "/authors/firstName/{firstName}", method = RequestMethod.GET)
    public List<Author> loadByFirstName(@PathVariable("firstName") String firstName){
        List<Author> newList = authorService.loadByFirstName(firstName);
        return newList;
    }

    @RequestMapping(value = "/authors/id/{id}", method = RequestMethod.GET)
    public Author loadById(@PathVariable("id") String id){
        Author newAuth = authorService.loadById(id);
        return newAuth;
    }

    @RequestMapping(value = "/authors/add", method = RequestMethod.POST)
    public Author addAuthor(@RequestBody Author author){
        authorService.insert(author);
        return author;
    }

    @RequestMapping(value = "/authors/delete/id/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") String id) {
        authorService.deleteById(id);
        return "WAS DELETED";
    }

    @RequestMapping(value = "/authors/delete/lastName/{lastName}", method = RequestMethod.DELETE)
    public String deleteByLastName(@PathVariable("lastName") String lastName) {
        authorService.deleteByLastName(lastName);
        return "WAS DELETED";
    }

    @RequestMapping(value = "/authors/delete/all/deleteAll", method = RequestMethod.DELETE)
    public String deleteAll() {
        authorService.deleteAll();
        return "ALL AUTHORS WAS DELETE";
    }

    @RequestMapping(value = "/authorbook/lastName/{lastName}", method = RequestMethod.GET)
    public Author loadByLastNameWithBook(@PathVariable("lastName") String lastName){
        Author newAuth = authorService.loadByLastNameWithBook(lastName);
        return newAuth;
    }

    @RequestMapping(value = "/authorbook/all", method = RequestMethod.GET)
    public List<Author> loadAllWithBook(){
        List<Author> newList = authorService.loadAllWithBook();
        return newList;
    }

    @RequestMapping(value = "/authorbook/id/{id}", method = RequestMethod.GET)
    public Author loadByIdWithBook(@PathVariable("id") String id){
        Author newAuth = authorService.loadByIdWithBook(id);
        return newAuth;
    }

}
