//package com.netcracker.infrastructure.repositories;
//import com.netcracker.entities.Author;
//import com.netcracker.entities.Book;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class AuthorRepositoryWithoutSPRING {
//
//    private final DataSource dataSource;
//
//    public AuthorRepositoryWithoutSPRING(DataSource dataSource){
//        this.dataSource = dataSource;
//    }
//
//    public void insert(Author author){
//        String sql = "INSERT INTO AUTHOR (AUTHOR_ID, FIRST_NAME, FATHER_NAME,LAST_NAME,BOOK_ID) VALUES (?, ?, ?, ?, ?)";
//
//        try(Connection connection = dataSource.getConnection()){
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1,author.getAuthorId());
//            preparedStatement.setString(2,author.getFirstName());
//            preparedStatement.setString(3,author.getFatherName());
//            preparedStatement.setString(4,author.getLastName());
//            preparedStatement.setString(5,author.getBookId());
//
//            preparedStatement.executeUpdate();
//        }
//        catch(SQLException e){
//            System.out.println(e);
//            throw new IllegalStateException();
//        }
//    }
//
//    public List<Author> loadAll(){
//        String sql = "SELECT * FROM AUTHOR";
//
//        try(Connection connection = dataSource.getConnection()){
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            List<Author> myList = new ArrayList<>();
//            while(rs.next()){
//                String authorId = rs.getString("AUTHOR_ID");
//                String firstName = rs.getString("FIRST_NAME");
//                String fatherName = rs.getString("FATHER_NAME");
//                String lastName = rs.getString("LAST_NAME");
//                String boodId = rs.getString("BOOK_ID");
//
//                Author author = new Author(authorId,null,firstName,fatherName,lastName);
//                author.setBookId(boodId);
//                myList.add(author);
//            }
//            return myList;
//        }
//        catch(SQLException e){
//            System.out.println(e);
//            throw new IllegalStateException();
//        }
//
//    }
//
//    public List<Author> loadByLastName(String lastName){
//        String sql = "SELECT * FROM AUTHOR WHERE LAST_NAME = ?";
//        try(Connection connection = dataSource.getConnection()) {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1,lastName);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            List<Author> myList = new ArrayList<>();
//            while(rs.next()){
//                String authorId = rs.getString("AUTHOR_ID");
//                String firstName = rs.getString("FIRST_NAME");
//                String fatherName = rs.getString("FATHER_NAME");
//                String lastName2 = rs.getString("LAST_NAME");
//                String boodId = rs.getString("BOOK_ID");
//
//                Author author = new Author(authorId,null,firstName,fatherName,lastName2);
//                author.setBookId(boodId);
//                myList.add(author);
//            }
//            return myList;
//        }
//        catch(SQLException e){
//            System.out.println(e);
//            throw new IllegalStateException();
//        }
//    }
//
//    public List<Author> loadByFirstName(String firstName){
//        String sql = "SELECT * FROM AUTHOR WHERE FIRST_NAME = ?";
//        try(Connection connection = dataSource.getConnection()) {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1,firstName);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            List<Author> myList = new ArrayList<>();
//            while(rs.next()){
//                String authorId = rs.getString("AUTHOR_ID");
//                String firstName2 = rs.getString("FIRST_NAME");
//                String fatherName = rs.getString("FATHER_NAME");
//                String lastName = rs.getString("LAST_NAME");
//                String boodId = rs.getString("BOOK_ID");
//
//                Author author = new Author(authorId,null,firstName2,fatherName,lastName);
//                author.setBookId(boodId);
//                myList.add(author);
//            }
//            return myList;
//        }
//        catch(SQLException e){
//            System.out.println(e);
//            throw new IllegalStateException();
//        }
//    }
//
//    public Author loadById(String id) {
//        String sql = "SELECT * FROM AUTHOR WHERE AUTHOR_ID = ?";
//        try (Connection connection = dataSource.getConnection()) {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, id);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            String firstName2 = rs.getString("FIRST_NAME");
//            String fatherName = rs.getString("FATHER_NAME");
//            String lastName = rs.getString("LAST_NAME");
//            String boodId = rs.getString("BOOK_ID");
//
//            Author author = new Author(id, null, firstName2, fatherName, lastName);
//            author.setBookId(boodId);
//
//            return author;
//        } catch (SQLException e) {
//            System.out.println(e);
//            throw new IllegalStateException();
//        }
//    }
//
//    public void deleteByLastName(String lastName){
//        String sql = "DELETE FROM AUTHOR WHERE LAST_NAME = ?";
//        try(Connection connection = dataSource.getConnection()){
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, lastName);
//            preparedStatement.executeUpdate();
//
//        }
//        catch(SQLException e){
//            System.out.println(e);
//            throw new IllegalStateException();
//        }
//    }
//
//    public void deleteById(String id){
//        String sql = "DELETE FROM AUTHOR WHERE AUTHOR_ID = ?";
//        try(Connection connection = dataSource.getConnection()){
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, id);
//            preparedStatement.executeUpdate();
//        }
//        catch(SQLException e){
//            System.out.println(e);
//            throw new IllegalStateException();
//        }
//    }
//
//    public void deleteAll(){
//        String sql = "DELETE FROM AUTHOR";
//        try(Connection connection = dataSource.getConnection()){
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.executeUpdate();
//        }
//        catch(SQLException e){
//            System.out.println(e);
//            throw new IllegalStateException();
//        }
//    }
//
//    public Author loadByIdWithBook(String id){
//        Author author = loadById(id);
//        Book book = getAuthorBook(author.getBookId());
//        book.setAuthor(author);
//        author.setBook(book);
//        return author;
//    }
//
//    public Author loadByLastNameWithBook(String lastName){
//        Author author = loadById(lastName);
//        Book book = getAuthorBook(author.getBookId());
//        book.setAuthor(author);
//        author.setBook(book);
//        return author;
//    }
//
//    public List<Author> loadAllWithBook(){
//        List<Author> myList = new ArrayList<>();
//        myList = loadAll();
//        for(Author author: myList){
//            author.setBook(getAuthorBook(author.getBookId()));
//        }
//        return myList;
//    }
//
//    public Book getAuthorBook(String id){
//        String sql = "SELECT * FROM BOOK WHERE BOOK_ID = ?";
//        try (Connection connection = dataSource.getConnection()) {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, id);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            List<Book> temp = new ArrayList<>();
//            while(rs.next()){
//                String bookName = rs.getString("BOOK_NAME");
//                String publishingDate = rs.getString("PUBLISHING_DATE");
//                String bookLanguage = rs.getString("BOOK_LANGUAGE");
//                Book book = new Book(id, bookName, publishingDate, bookLanguage, null, null);
//                temp.add(book);
//            }
//
//            return temp.get(0);
//
//        } catch (SQLException e) {
//            System.out.println(e);
//            throw new IllegalStateException();
//        }
//    }
//
//
//
//
//}
