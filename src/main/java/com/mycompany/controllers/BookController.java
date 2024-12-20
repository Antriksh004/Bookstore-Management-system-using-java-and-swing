/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.mycompany.database.connection;
import com.mycompany.Models.BookModel;
import com.mycompany.Models.IssueBookModel;
import com.mycompany.Models.UserModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.Models.BooksComingSoon;

/**
 *
 * @author ANTRIKSH
 */
public class BookController {
    public boolean InsertBookData(String name, String price, String author, String publication){
        Connection con = null;
        Statement stmt = null;
        BookModel bm = new BookModel(name, price, author, publication);
        
        
        String query = "INSERT INTO books (name, price, author,publication, created_at, updated_at) "
                 + "VALUES ('" + bm.name + "', '" + bm.price + "', '" + bm.author +"', '" + bm.publication +"', '" + bm.createdAt + "', '" + bm.updatedAt + "');"; // Proper SQL syntax
        try {
            connection c = new connection();
            con = c.getConnection();
            
            
            System.out.println("Query is: " + query);
            
            //Create Statement
            Statement st = con.createStatement();
            int val = st.executeUpdate(query);

            System.out.println(val + " row(s) affected");
            
            con.close();
            return true;
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
        return false;
        
    }
    public boolean InsertDonatedBookData(String name, String price, String author, String publication, String pickupAddress){
        Connection con = null;
        Statement stmt = null;
        
        
        
        String query = "INSERT INTO donated_books (name, price, author,publication, picku_address) "
                 + "VALUES ('" + name + "', '" + price + "', '" + author +"', '" + publication +"', '" + pickupAddress + "');"; // Proper SQL syntax
        try {
            connection c = new connection();
            con = c.getConnection();
            
            
            System.out.println("Query is: " + query);
            
            //Create Statement
            Statement st = con.createStatement();
            int val = st.executeUpdate(query);

            System.out.println(val + " row(s) affected");
            
            con.close();
            return true;
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
        return false;
        
    }
    static public boolean InsertIssuedBook(String userId, String username, String emailId, String bookid, String bookname){
        Connection con = null;
        Statement stmt = null;
        IssueBookModel ibm = new IssueBookModel(userId, username, emailId, bookid, bookname);
        
        
        String query = "INSERT INTO issuedbooks (userid, username, email_id, book_name, book_id, issued_date, due_date) "
                 + "VALUES ('" + ibm.userId + "', '" + ibm.username + "', '" + ibm.emailId +"', '" + ibm.bookname +"', '" + ibm.bookid +"', '" + ibm.issuedAt + "', '" + ibm.dueOn + "');"; 
        try {
            connection c = new connection();
            con = c.getConnection();
            
            
            System.out.println("Query is: " + query);
            
            //Create Statement
            Statement st = con.createStatement();
            int val = st.executeUpdate(query);

            System.out.println(val + " row(s) affected");
            
            con.close();
            return true;
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
        return false;
        
    }
    public static String getCountOfIssuedBooks(String userId) {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        
        connection c = new connection();
        con = c.getConnection();

        
        String query = "SELECT COUNT(*) AS count FROM issuedbooks WHERE userid = ?";
        pstmt = con.prepareStatement(query);
        pstmt.setString(1, userId); 

        
        rs = pstmt.executeQuery();

        
        if (rs.next()) { 
            return rs.getString("count");
        }
    } catch (SQLException e) {
        System.out.println("SQL exception occurred: " + e.getMessage());
    } finally {
        
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            System.out.println("Failed to close resources: " + ex.getMessage());
        }
    }
    return "0"; 
}
    public static String getCountOfDueBooks(String userId) {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        
        connection c = new connection();
        con = c.getConnection();

        
        String query = "SELECT COUNT(*) AS count FROM issuedbooks WHERE userid = ? AND due_date < ?";
        pstmt = con.prepareStatement(query);
        pstmt.setString(1, userId); 
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        pstmt.setTimestamp(2, ts);

        
        rs = pstmt.executeQuery();

        
        if (rs.next()) { 
            return rs.getString("count");
        }
    } catch (SQLException e) {
        System.out.println("SQL exception occurred: " + e.getMessage());
    } finally {
        
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            System.out.println("Failed to close resources: " + ex.getMessage());
        }
    }
    return "0"; 
}
    static public List<BooksComingSoon> getBooksComingSoon() {
        List<BooksComingSoon> books = new ArrayList<>();
        connection c = new connection();

        try (Connection conn = c.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM bookscomingsoon")) {

            while (rs.next()) {
//                
                String bookname = rs.getString("name");
                String author = rs.getString("author");
                String publication = rs.getString("publication");
                String expectedDate = rs.getString("expected_date");
                

                books.add(new BooksComingSoon(bookname, author, publication, expectedDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    static public boolean removeBookById(String id){
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection c = new connection();
            con = c.getConnection();
            String query = "DELETE FROM books WHERE book_id = '" + id  + "';";
            System.out.println(query);
            
                            
            
            
           
            stmt = con.createStatement();
            int rowsAffected = stmt.executeUpdate(query);
            System.out.println(rowsAffected);
            return true;
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    static public boolean getBookByName(String bookname){
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection c = new connection();
            con = c.getConnection();
            String query = "SELECT * FROM books WHERE name = '" + bookname  + "';";
            System.out.println(query);
            
                            
            
            
           
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) { 
                    String book = rs.getString(1);
                    System.out.println(book);
                    return true;
                }

            
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    static public List<BookModel> getBooks() {
        List<BookModel> books = new ArrayList<>();
        connection c = new connection();

        try (Connection conn = c.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM books ORDER BY book_id")) {

            while (rs.next()) {
//                
                String name = rs.getString("name");
                String price = rs.getString("price");
                String author = rs.getString("author");
                String publication = rs.getString("publication");
                
                
                

                books.add(new BookModel(name, price, author, publication));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }


}
