package com.netcracker.infrastructure.mappers;

import com.netcracker.entities.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class BookMapper implements RowMapper<Book> {

    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

        String bookId = rs.getString("BOOK_ID");
        String bookName = rs.getString("BOOK_NAME");
        String publishingDate = rs.getString("PUBLISHING_DATE");
        String bookLanguage = rs.getString("BOOK_LANGUAGE");
        String publishingHouseId = rs.getString("PUBLISHINGHOUSE_ID");

        Book book = new Book(bookId,bookName,publishingDate,bookLanguage,null,null);
        book.setPublishingHouseId(publishingHouseId);
        return book;
    }
}