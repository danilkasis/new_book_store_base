package com.netcracker.infrastructure.repositories;

import com.netcracker.entities.Book;
import com.netcracker.entities.Store;
import com.netcracker.infrastructure.mappers.BookMapper;
import com.netcracker.infrastructure.mappers.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {

    @Autowired
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public BookRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void insert(Book book) {
        String sql = "INSERT INTO BOOK (BOOK_ID, BOOK_NAME, PUBLISHING_DATE,BOOK_LANGUAGE,PUBLISHINGHOUSE_ID) VALUES" +
                " (:book_id, :book_name, :publishing_date, :book_language,:publishinghouse_id)";

        Map namedParameters = new HashMap();
        namedParameters.put("book_id", book.getBookId());
        namedParameters.put("book_name", book.getBookName());
        namedParameters.put("publishing_date", book.getPublishingDate());
        namedParameters.put("book_language", book.getBooksLanguage());
        namedParameters.put("publishinghouse_id", book.getPublishingHouseId());

        namedParameterJdbcTemplate.update(sql, namedParameters);
    }



    public List<Book> loadAll() {

        String sql = "SELECT * FROM BOOK";
        Map namedParameters = new HashMap();

        List<Book> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new BookMapper()
        );

        return result;
    }

    public List<Book> loadByHouseId(String houseId) {

        String sql = "SELECT * FROM BOOK WHERE PUBLISHINGHOUSE_ID=:id";
        Map namedParameters = new HashMap();
        namedParameters.put("id", houseId);

        List<Book> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new BookMapper());
        return result;
    }

    public List<Book> loadByName(String bookName) {

        String sql = "SELECT * FROM BOOK WHERE BOOK_NAME=:bookname";
        Map namedParameters = new HashMap();
        namedParameters.put("bookname", bookName);

        List<Book> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new BookMapper());
        return result;
    }

    public Book loadById(String id) {

        String sql = "SELECT * FROM BOOK WHERE BOOK_ID=:id";
        Map namedParameters = new HashMap();
        namedParameters.put("id", id);

        Book result = namedParameterJdbcTemplate.queryForObject(
                sql,
                namedParameters,
                new BookMapper());
        return result;
    }

    public List<Book> loadByDate(String thisDate) {

        String sql = "SELECT * FROM BOOK WHERE PUBLISHING_DATE=:thisdate";
        Map namedParameters = new HashMap();
        namedParameters.put("thisdate", thisDate);

        List<Book> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new BookMapper());
        return result;
    }

    public List<Book> loadByLanguagge(String bookLanguage) {

        String sql = "SELECT * FROM BOOK WHERE BOOK_LANGUAGE=:booklanguage";
        Map namedParameters = new HashMap();
        namedParameters.put("booklanguage", bookLanguage);

        List<Book> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new BookMapper());
        return result;
    }

    public Book loadByTableId(String id) {

        String sql = "SELECT * FROM BOOK WHERE TABLE_ID=:id";
        Map namedParameters = new HashMap();
        namedParameters.put("id", id);

        Book result = namedParameterJdbcTemplate.queryForObject(
                sql,
                namedParameters,
                new BookMapper());
        return result;
    }



    public void deleteByName(String bookName){
        String sql = "DELETE FROM BOOK WHERE BOOK_NAME = :bookname";

        Map namedParameters = new HashMap();
        namedParameters.put("bookname", bookName);

        namedParameterJdbcTemplate.update(sql,namedParameters);
    }

    public void deleteById(String id){
        String sql = "DELETE FROM BOOK WHERE BOOK_ID = :id";

        Map namedParameters = new HashMap();
        namedParameters.put("id", id);

        namedParameterJdbcTemplate.update(sql,namedParameters);
    }

    public void deleteByLanguage(String language){
        String sql = "DELETE FROM BOOK WHERE BOOK_LANGUAGE = :thislanguage";

        Map namedParameters = new HashMap();
        namedParameters.put("thislanguage", language);

        namedParameterJdbcTemplate.update(sql,namedParameters);
    }

    public void deleteByDate(String thisDate){
        String sql = "DELETE FROM BOOK WHERE PUBLISHING_DATE = :thisdate";

        Map namedParameters = new HashMap();
        namedParameters.put("thisdate", thisDate);

        namedParameterJdbcTemplate.update(sql,namedParameters);
    }

    public void deleteAll(){

        String sql = "DELETE FROM BOOK";

        Map namedParameters = new HashMap();

        namedParameterJdbcTemplate.update(sql,namedParameters);
    }

    public void deleteByTableId(String id) {
        String sql = "DELETE FROM BOOK WHERE TABLE_ID = :id";

        Map namedParameters = new HashMap();
        namedParameters.put("id", id);

        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    public void deleteByHouseId(String id) {
        String sql = "DELETE FROM BOOK WHERE PUBLISHINGHOUSE_ID = :id";

        Map namedParameters = new HashMap();
        namedParameters.put("id", id);

        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    public Book loadByIdWithStore(String id){
        Book newBook = this.loadById(id);
        String sql = "SELECT * FROM book b join helptable h on b.BOOK_ID = h.BOOK_ID " +
                "JOIN store s on h.STORE_ID = s.STORE_ID WHERE b.BOOK_ID=:idbook";
        Map namedParameters = new HashMap();
        namedParameters.put("idbook", id);

        List<Store> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new StoreMapper());
        newBook.setStoreList(result);
        return newBook;
    }
}
