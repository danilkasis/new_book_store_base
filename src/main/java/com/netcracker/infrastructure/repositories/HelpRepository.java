package com.netcracker.infrastructure.repositories;

import com.netcracker.entities.HelpBookStore;
import com.netcracker.infrastructure.mappers.HelpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class HelpRepository {

    @Autowired
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public HelpRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    public void insert(HelpBookStore house) {
        String sql = "INSERT INTO HELPTABLE (TABLE_ID, BOOK_ID,STORE_ID) VALUES" +
                " (:table_id, :book_id, :store_id)";

        Map namedParameters = new HashMap();
        namedParameters.put("table_id", house.getTableId());
        namedParameters.put("book_id", house.getBookId());
        namedParameters.put("store_id", house.getStoreId());

        namedParameterJdbcTemplate.update(sql, namedParameters);
    }


    
    public List<HelpBookStore> loadAll() {

        String sql = "SELECT * FROM HELPTABLE";
        Map namedParameters = new HashMap();

        List<HelpBookStore> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new HelpMapper());

        return result;
    }



    public HelpBookStore loadByTableId(String id) {

        String sql = "SELECT * FROM HELPTABLE WHERE TABLE_ID=:id";
        Map namedParameters = new HashMap();
        namedParameters.put("id", id);

        HelpBookStore result = namedParameterJdbcTemplate.queryForObject(
                sql,
                namedParameters,
                new HelpMapper());

        return result;
    }

    public List<HelpBookStore> loadByBookId(String id) {

        String sql = "SELECT * FROM HELPTABLE WHERE BOOK_ID=:id";
        Map namedParameters = new HashMap();
        namedParameters.put("id", id);

        List<HelpBookStore> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new HelpMapper());

        return result;
    }


    public List<HelpBookStore> loadByStoreId(String id) {

        String sql = "SELECT * FROM HELPTABLE WHERE STORE_ID=:id";
        Map namedParameters = new HashMap();
        namedParameters.put("id", id);

        List<HelpBookStore> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new HelpMapper());

        return result;
    }
    

}