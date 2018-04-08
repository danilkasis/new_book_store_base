package com.netcracker.infrastructure.mappers;


import com.netcracker.entities.Book;
import org.springframework.jdbc.core.RowMapper;
import com.netcracker.entities.Author;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class AuthorBookMapper implements RowMapper<Author> {

    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {

        String authorId = rs.getString("AUTHOR_ID");
        String firstName = rs.getString("FIRST_NAME");
        String fatherName = rs.getString("FATHER_NAME");
        String lastName = rs.getString("LAST_NAME");
        String bookId = rs.getString("BOOK_ID");

        String bookName = rs.getString("BOOK_NAME");
        String publishingDate = rs.getString("PUBLISHING_DATE");
        String bookLanguage = rs.getString("BOOK_LANGUAGE");
        String publishingHouseId = rs.getString("PUBLISHINGHOUSE_ID");

        Author author = new Author(authorId, null, firstName,fatherName, lastName);
        Book book = new Book(bookId,bookName,publishingDate,bookLanguage,null,null);
        book.setPublishingHouseId(publishingHouseId);

        author.setBookId(bookId);
        author.setBook(book);

        return author;
    }


}