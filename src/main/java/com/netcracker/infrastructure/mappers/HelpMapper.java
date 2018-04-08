package com.netcracker.infrastructure.mappers;


import com.netcracker.entities.HelpBookStore;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class HelpMapper implements RowMapper<HelpBookStore> {

    public HelpBookStore mapRow(ResultSet rs, int rowNum) throws SQLException {

        String tableId = rs.getString("TABLE_ID");
        String bookId = rs.getString("BOOK_ID");
        String storeId = rs.getString("STORE_ID");

        HelpBookStore help = new HelpBookStore(tableId, null,null);
        help.setBookId(bookId);
        help.setStoreId(storeId);
        return help;
    }
}