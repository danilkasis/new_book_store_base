package com.netcracker.infrastructure.mappers;


import com.netcracker.entities.PublishingHouse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class HouseMapper implements RowMapper<PublishingHouse> {

    public PublishingHouse mapRow(ResultSet rs, int rowNum) throws SQLException {

        String houseId = rs.getString("PUBLISHINGHOUSE_ID");
        String houseName = rs.getString("HOUSE_NAME");

        PublishingHouse house = new PublishingHouse(houseId, houseName);
        return house;
    }
}