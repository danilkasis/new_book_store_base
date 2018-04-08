package com.netcracker.infrastructure.repositories;

import com.netcracker.entities.Book;
import com.netcracker.entities.PublishingHouse;
import com.netcracker.infrastructure.mappers.BookMapper;
import com.netcracker.infrastructure.mappers.HouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PublishingHouseRepository {

    @Autowired
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public PublishingHouseRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void insert(PublishingHouse house) {
        String sql = "INSERT INTO PUBLISHINGHOUSE (PUBLISHINGHOUSE_ID, HOUSE_NAME) VALUES" +
                " (:publishinghouse_id, :house_name)";

        Map namedParameters = new HashMap();
        namedParameters.put("publishinghouse_id", house.getPublishingHouseId());
        namedParameters.put("house_name", house.getHouseName());

        namedParameterJdbcTemplate.update(sql, namedParameters);
    }




    public List<PublishingHouse> loadAll() {

        String sql = "SELECT * FROM PUBLISHINGHOUSE";
        Map namedParameters = new HashMap();

        List<PublishingHouse> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new HouseMapper());

        return result;
    }

    public PublishingHouse loadByHouseName(String houseName) {

        String sql = "SELECT * FROM PUBLISHINGHOUSE WHERE HOUSE_NAME=:housename";
        Map namedParameters = new HashMap();
        namedParameters.put("housename", houseName);

        PublishingHouse result = namedParameterJdbcTemplate.queryForObject(
                sql,
                namedParameters,
                new HouseMapper());
        return result;
    }

    public PublishingHouse loadById(String id) {

        String sql = "SELECT * FROM PUBLISHINGHOUSE WHERE PUBLISHINGHOUSE_ID=:id";
        Map namedParameters = new HashMap();
        namedParameters.put("id", id);

        PublishingHouse result = namedParameterJdbcTemplate.queryForObject(
                sql,
                namedParameters,
                new HouseMapper());

        return result;
    }




    public void deleteByHouseName(String houseName){
        String sql = "DELETE FROM PUBLISHINGHOUSE WHERE HOUSE_NAME = :housename";

        Map namedParameters = new HashMap();
        namedParameters.put("housename", houseName);

        namedParameterJdbcTemplate.update(sql,namedParameters);
    }

    public void deleteById(String id){
        String sql = "DELETE FROM PUBLISHINGHOUSE WHERE PUBLISHINGHOUSE_ID = :id";

        Map namedParameters = new HashMap();
        namedParameters.put("id", id);

        namedParameterJdbcTemplate.update(sql,namedParameters);
    }

    public void deleteAll(){

        String sql = "DELETE FROM PUBLISHINGHOUSE";

        Map namedParameters = new HashMap();

        namedParameterJdbcTemplate.update(sql,namedParameters);
    }



    public PublishingHouse loadByIdWithBook(String id){

        PublishingHouse newHouse = this.loadById(id);

        String sql = "SELECT * FROM BOOK WHERE PUBLISHINGHOUSE_ID=:id";
        Map namedParameters = new HashMap();
        namedParameters.put("id", id);

        List<Book> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new BookMapper());

        newHouse.setBookList(result);

        return newHouse;

    }

    public PublishingHouse loadByHouseNameWithBook(String houseName){

        PublishingHouse newHouse = this.loadByHouseName(houseName);

        String sql = "SELECT * FROM book WHERE PUBLISHINGHOUSE_ID=:idbook";
        Map namedParameters = new HashMap();
        namedParameters.put("idbook", newHouse.getPublishingHouseId());

        List<Book> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new BookMapper());

        newHouse.setBookList(result);
        return newHouse;
    }

    public List<PublishingHouse> loadAllWithBook(){

        List<PublishingHouse> newList = this.loadAll();

        for (PublishingHouse someHouse : newList) {
            String sql = "SELECT * FROM BOOK WHERE PUBLISHINGHOUSE_ID=:id";
            Map namedParameters = new HashMap();
            namedParameters.put("id", someHouse.getPublishingHouseId());

            List<Book> result = namedParameterJdbcTemplate.query(
                    sql,
                    namedParameters,
                    new BookMapper());

        someHouse.setBookList(result);
        }

        return newList;
    }



}
