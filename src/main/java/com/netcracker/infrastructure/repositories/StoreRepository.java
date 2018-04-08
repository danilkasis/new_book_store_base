package com.netcracker.infrastructure.repositories;

import com.netcracker.entities.Store;
import com.netcracker.infrastructure.mappers.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StoreRepository {

    @Autowired
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public StoreRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void insert(Store store) {
        String sql = "INSERT INTO STORE (STORE_ID, STORE_NAME,STREET_NAME, NUMBEROF_HOUSE) VALUES" +
                " (:store_id, :store_name,:street_name,:numberof_house)";

        Map namedParameters = new HashMap();
        namedParameters.put("store_id", store.getStoreId());
        namedParameters.put("store_name", store.getStoreName());
        namedParameters.put("street_name", store.getStreetName());
        namedParameters.put("numberof_house", store.getNumberOfHouse());

        namedParameterJdbcTemplate.update(sql, namedParameters);
    }



    public List<Store> loadAll() {

        String sql = "SELECT * FROM STORE";
        Map namedParameters = new HashMap();

        List<Store> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new StoreMapper());

        return result;
    }

    public Store loadByStoreName(String storeName) {

        String sql = "SELECT * FROM STORE WHERE STORE_NAME=:storename";
        Map namedParameters = new HashMap();
        namedParameters.put("storename", storeName);

        Store result = namedParameterJdbcTemplate.queryForObject(
                sql,
                namedParameters,
                new StoreMapper());
        return result;
    }

    public Store loadById(String id) {

        String sql = "SELECT * FROM STORE WHERE STORE_ID=:id";
        Map namedParameters = new HashMap();
        namedParameters.put("id", id);

        Store result = namedParameterJdbcTemplate.queryForObject(
                sql,
                namedParameters,
                new StoreMapper());

        return result;
    }

    public List<Store> loadByStreetName(String streetName){

        String sql = "SELECT * FROM STORE WHERE STREET_NAME=:streetname";
        Map namedParameters = new HashMap();
        namedParameters.put("streetname", streetName);

        List<Store> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new StoreMapper());

        return result;
    }



    public void deleteByStoreName(String storeName){
        String sql = "DELETE FROM STORE WHERE STORE_NAME = :storename";

        Map namedParameters = new HashMap();
        namedParameters.put("storename", storeName);

        namedParameterJdbcTemplate.update(sql,namedParameters);
    }

    public void deleteById(String id){
        String sql = "DELETE FROM STORE WHERE STORE_ID = :id";

        Map namedParameters = new HashMap();
        namedParameters.put("id", id);

        namedParameterJdbcTemplate.update(sql,namedParameters);
    }

    public void deleteAll(){

        String sql = "DELETE FROM STORE";

        Map namedParameters = new HashMap();

        namedParameterJdbcTemplate.update(sql,namedParameters);
    }

    public void deleteByStreetName(String streetName){
        String sql = "DELETE FROM STORE WHERE STREET_NAME = :streetname";

        Map namedParameters = new HashMap();
        namedParameters.put("streetname", streetName);

        namedParameterJdbcTemplate.update(sql,namedParameters);
    }















}
