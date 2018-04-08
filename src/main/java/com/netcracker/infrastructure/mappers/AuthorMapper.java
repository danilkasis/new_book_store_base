package com.netcracker.infrastructure.mappers;

import org.springframework.jdbc.core.RowMapper;
import com.netcracker.entities.Author;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class AuthorMapper implements RowMapper<Author> {

    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {

        String authorId = rs.getString("AUTHOR_ID");
        String firstName = rs.getString("FIRST_NAME");
        String fatherName = rs.getString("FATHER_NAME");
        String lastName = rs.getString("LAST_NAME");
        String bookId = rs.getString("BOOK_ID");

        Author author = new Author(authorId, null, firstName,fatherName, lastName);
        author.setBookId(bookId);

        return author;
    }
}