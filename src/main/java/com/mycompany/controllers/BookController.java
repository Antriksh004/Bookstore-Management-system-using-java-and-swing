/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.mycompany.database.connection;
import com.mycompany.Models.BookModel;
import com.mycompany.Models.IssueBookModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

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

}
