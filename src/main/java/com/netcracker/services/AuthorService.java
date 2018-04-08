package com.netcracker.services;

import com.netcracker.infrastructure.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netcracker.entities.Author;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AuthorService {

    @Autowired
    public AuthorRepository authorRepository;

//    public AuthorService(AuthorRepository authorRepository){
//        this.authorRepository = authorRepository;
//    }

    public void insert(Author author) {
        authorRepository.insert(author);
    }

    public List<Author> loadAll() {
        return authorRepository.loadAll();
    }

    public List<Author> loadByLastName(String lastName) {
        return authorRepository.loadByLastName(lastName);
    }

    public List<Author> loadByFirstName(String firstName) {
        return authorRepository.loadByFirstName(firstName);
    }

    public Author loadById(String id) {
        return authorRepository.loadById(id);
    }

    public void deleteByLastName(String lastName){
        authorRepository.deleteByLastName(lastName);
    }

    public void deleteById(String id){
        authorRepository.loadById(id);
    }

    public void deleteAll(){
        authorRepository.deleteAll();
    }

    public Author loadByIdWithBook(String id){
        return authorRepository.loadByIdWithBook(id);
    }

    public Author loadByLastNameWithBook(String lastName){
        return authorRepository.loadByLastNameWithBook(lastName);
    }

    public List<Author> loadAllWithBook(){
        return authorRepository.loadAllWithBook();
    }



}
