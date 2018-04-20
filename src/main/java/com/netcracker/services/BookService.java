package com.netcracker.services;

import com.netcracker.entities.Book;
import com.netcracker.infrastructure.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void insert(Book book) {
        bookRepository.insert(book);
    }


    public List<Book> loadAll() {
        return bookRepository.loadAll();
    }

    public List<Book> loadByHouseId(String houseId) {
        return bookRepository.loadByHouseId(houseId);
    }

    public List<Book> loadByName(String bookName) {
        return bookRepository.loadByName(bookName);
    }

    public Book loadById(String id) {
        return bookRepository.loadById(id);
    }

    public List<Book> loadByDate(String thisDate) {
        return bookRepository.loadByDate(thisDate);
    }

    public List<Book> loadByLanguagge(String bookLanguage) {
        return bookRepository.loadByLanguagge(bookLanguage);
    }

    public void deleteByName(String bookName) {
        bookRepository.deleteByName(bookName);
    }

    public void deleteById(String id) {
        bookRepository.deleteById(id);
    }

    public void deleteByLanguage(String language) {
        bookRepository.deleteByLanguage(language);
    }

    public void deleteByDate(String thisDate) {
        bookRepository.deleteByDate(thisDate);
    }

    public void deleteAll() {
        bookRepository.deleteAll();
    }

    public Book loadByIdWithStore(String id) {
        return bookRepository.loadByIdWithStore(id);
    }
}


