package com.netcracker.infrastructure.mappers;


import com.netcracker.entities.Store;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class StoreMapper implements RowMapper<Store> {

    public Store mapRow(ResultSet rs, int rowNum) throws SQLException {

        String storeId = rs.getString("STORE_ID");
        String storeName = rs.getString("STORE_NAME");
        String streetName = rs.getString("STREET_NAME");
        String numberOfHouse = rs.getString("NUMBEROF_HOUSE");

        Store store = new Store(storeId,storeName,streetName,numberOfHouse);

        return store;
    }
}