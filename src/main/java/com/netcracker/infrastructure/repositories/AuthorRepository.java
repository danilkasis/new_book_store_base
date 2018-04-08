package com.netcracker.infrastructure.repositories;

import com.netcracker.infrastructure.mappers.AuthorBookMapper;
import com.netcracker.infrastructure.mappers.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.netcracker.entities.Author;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class AuthorRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public AuthorRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void insert(Author author) {
        String sql = "INSERT INTO AUTHOR (AUTHOR_ID, FIRST_NAME, FATHER_NAME,LAST_NAME,BOOK_ID) VALUES" +
                " (:author_id, :first_name, :father_name, :last_name, :book_id)";

        Map namedParameters = new HashMap();
        namedParameters.put("author_id", author.getAuthorId());
        namedParameters.put("first_name", author.getFirstName());
        namedParameters.put("father_name", author.getFatherName());
        namedParameters.put("last_name", author.getLastName());
        namedParameters.put("book_id", author.getBookId());

        namedParameterJdbcTemplate.update(sql, namedParameters);
    }




    public List<Author> loadAll() {

        String sql = "SELECT * FROM AUTHOR";
        Map namedParameters = new HashMap();

        List<Author> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new AuthorMapper()
        );

        return result;
    }

    public List<Author> loadByLastName(String lastName) {

        String sql = "SELECT * FROM AUTHOR WHERE LAST_NAME=:lastname";
        Map namedParameters = new HashMap();
        namedParameters.put("lastname", lastName);

        List<Author> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new AuthorMapper());
        return result;
    }

    public List<Author> loadByFirstName(String firstName) {

        String sql = "SELECT * FROM AUTHOR WHERE FIRST_NAME=:firstname";
        Map namedParameters = new HashMap();
        namedParameters.put("firstname", firstName);

        List<Author> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new AuthorMapper());
        return result;
    }

    public Author loadById(String id) {

        String sql = "SELECT * FROM AUTHOR WHERE AUTHOR_ID=:id";
        Map namedParameters = new HashMap();
        namedParameters.put("id", id);

        Author result = namedParameterJdbcTemplate.queryForObject(
                sql,
                namedParameters,
                new AuthorMapper());

        return result;
    }



    public void deleteByLastName(String lastName){
        String sql = "DELETE FROM AUTHOR WHERE LAST_NAME = :lastname";

        Map namedParameters = new HashMap();
        namedParameters.put("lastname", lastName);

        namedParameterJdbcTemplate.update(sql,namedParameters);
    }

    public void deleteById(String id){
        String sql = "DELETE FROM AUTHOR WHERE LAST_NAME = :id";

        Map namedParameters = new HashMap();
        namedParameters.put("id", id);

        namedParameterJdbcTemplate.update(sql,namedParameters);
    }

    public void deleteAll(){

        String sql = "DELETE FROM AUTHOR";

        Map namedParameters = new HashMap();

        namedParameterJdbcTemplate.update(sql,namedParameters);
    }


    public Author loadByIdWithBook(String id){
        String sql = "SELECT * FROM author aut JOIN book bo ON aut.BOOK_ID = bo.BOOK_ID WHERE AUTHOR_ID=:id";
        Map namedParameters = new HashMap();
        namedParameters.put("id", id);

        Author result = namedParameterJdbcTemplate.queryForObject(
                sql,
                namedParameters,
                new AuthorBookMapper());

        return result;
    }

    public Author loadByLastNameWithBook(String lastName){
        String sql = "SELECT * FROM author aut JOIN book bo ON aut.BOOK_ID = bo.BOOK_ID WHERE LAST_NAME=:lastname";
        Map namedParameters = new HashMap();
        namedParameters.put("lastname", lastName);

        Author result = namedParameterJdbcTemplate.queryForObject(
                sql,
                namedParameters,
                new AuthorBookMapper());

        return result;
    }

    public List<Author> loadAllWithBook(){
        String sql = "SELECT * FROM author aut JOIN book bo ON aut.BOOK_ID = bo.BOOK_ID";
        Map namedParameters = new HashMap();

        List<Author> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new AuthorBookMapper());
        return result;
    }

}
