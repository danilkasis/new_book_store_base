package com.netcracker.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netcracker.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.netcracker.entities.Author;

import java.io.IOException;
import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    public AuthorService authorService;

    @GetMapping("/")
    public String index() {
        return "SERVER IS READY";
    }

    @RequestMapping(value = "/authors/GET", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Author> loadAllAuthors(){
        List<Author> newList = authorService.loadAll();
        return newList;
    }

    @RequestMapping(value = "/authors/GET/lastName/{lastName}", method = RequestMethod.GET)
    public List<Author> loadByLastName(@PathVariable("lastName") String lastName){
        List<Author> newList = authorService.loadByLastName(lastName);
        return newList;
    }


    @RequestMapping(value = "/authors/GET/firstName/{firstName}", method = RequestMethod.GET)
    public List<Author> loadByFirstName(@PathVariable("firstName") String firstName){
        List<Author> newList = authorService.loadByFirstName(firstName);
        return newList;
    }


    @RequestMapping(value = "/authors/{id}GET", method = RequestMethod.GET)
    public Author loadById(@PathVariable("id") String id){
        Author newAuth = authorService.loadById(id);
        return newAuth;
    }


    @RequestMapping(value = "/authors/POST", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addAuthor(@RequestBody String string){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Author author = mapper.readValue(string, Author.class);
            authorService.insert(author);
            return "Author added";
        }catch(IOException e){
            System.out.printf("IOExeption");
            return "Trable with parse JSON format";
        }
    }


    @RequestMapping(value = "/authors/{id}DELETE", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") String id) {
        authorService.deleteById(id);
        return "WAS DELETE";
    }


    @RequestMapping(value = "/authors/DELETE/lastName/{lastName}", method = RequestMethod.DELETE)
    public String deleteByLastName(@PathVariable("lastName") String lastName) {
        authorService.deleteByLastName(lastName);
        return "WAS DELETE";
    }


    @RequestMapping(value = "/authors/DELETE", method = RequestMethod.DELETE)
    public String deleteAll() {
        authorService.deleteAll();
        return "ALL AUTHORS WAS DELETE";
    }


    @RequestMapping(value = "/authorbook/GET/lastName/{lastName}", method = RequestMethod.GET)
    public List<Author> loadByLastNameWithBook(@PathVariable("lastName") String lastName){
        List<Author> newList = authorService.loadByLastNameWithBook(lastName);
        return newList;
    }


    @RequestMapping(value = "/authorbook/GET", method = RequestMethod.GET)
    public List<Author> loadAllWithBook(){
        List<Author> newList = authorService.loadAllWithBook();
        return newList;
    }


    @RequestMapping(value = "/authorbook/{id}GET", method = RequestMethod.GET)
    public Author loadByIdWithBook(@PathVariable("id") String id){
        Author newAuth = authorService.loadByIdWithBook(id);
        return newAuth;
    }

}
