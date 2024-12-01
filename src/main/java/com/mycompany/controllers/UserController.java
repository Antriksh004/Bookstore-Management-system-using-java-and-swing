/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.mycompany.Models.BooksComingSoon;
import com.mycompany.Models.InventoryBooksModel;
import com.mycompany.database.connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.Models.UserModel;


/**
 *
 * @author ANTRIKSH
 */
public class UserController {
    public boolean InsertUserData(String userid, String username, String password, String mobile, String securityQuestion,String securityAnswer, String emailId){
        Connection con = null;
        Statement stmt = null;
        
        
        String query = "INSERT INTO user (userid, username, password, mobile, security_question, security_answer, email_id) "
                 + "VALUES ('" + userid + "', '" + username + "', '" + password +"', '" + mobile +"', '" + securityQuestion + "', '" + securityAnswer + "', '"+emailId+"');"; // Proper SQL syntax
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
    static public boolean checkLogin(String userId, String username, String password){
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        

        try {
            connection c = new connection();
            con = c.getConnection();
            String query = "select password from user WHERE  userid = '" + userId + "' and username = '"+username+"';";
            // create a statement
            stmt = con.createStatement(); 

            rs = stmt.executeQuery(query); 

            
            while (rs.next()) {
                
                String clientPassword = rs.getString(1);
                
                if(password.equals(clientPassword)){
                    System.out.println("---------------");
                    System.out.println("UserId: " +userId);
                    System.out.println("Name: " + username);
                    System.out.println("Rollno: " + clientPassword);
                    return true;

                }
                else{
                    System.out.println("Incorrect Password");

                }
                
                
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // release database resources
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    static public boolean removeUserById(String id){
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection c = new connection();
            con = c.getConnection();
            String query = "DELETE FROM user WHERE userid = '" + id  + "';";
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
    static public List<UserModel> getUsers() {
        List<UserModel> users = new ArrayList<>();
        connection c = new connection();

        try (Connection conn = c.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM user ORDER BY username ASC")) {

            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//                String major = rs.getString("major");
                String username = rs.getString("username");
                String mobile = rs.getString("mobile");
                String id = rs.getString("userid");
                String emailId = rs.getString("email_id");
                

                users.add(new UserModel(username, mobile, id, emailId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    static public String[] getUserById(String userId){
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection c = new connection();
            con = c.getConnection();
            String query = "SELECT * FROM user WHERE userid = '" + userId  + "';";
            System.out.println(query);
            
                            
            
            
           
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) { 
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String mobile = rs.getString("mobile");
                    String securityQuestion = rs.getString("security_question");
                    String securityAnswer = rs.getString("security_answer");
                    String emailId = rs.getString("email_id");
                    String[] user = {username, password, mobile, securityQuestion, securityAnswer, emailId};
                    
                    
                    return user;
                }

            
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    static public List<InventoryBooksModel> listInventoryBooks(String userId) {
        List<InventoryBooksModel> books = new ArrayList<>();
        connection c = new connection();

        try (Connection conn = c.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM issuedbooks where userid = '"+userId+"';")) {

            while (rs.next()) {
//                
                String bookname = rs.getString("book_name");
                String bookid = rs.getString("book_id");
                String issued_date = rs.getString("issued_date");
                String due_date = rs.getString("due_date");
                System.out.println(bookname+bookid+issued_date+due_date);
                

                books.add(new InventoryBooksModel(bookname, bookid, issued_date, due_date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
//    public static void main(String[] args){
//        UserController sosc = new UserController();
////        boolean isSignedIn = sosc.InsertStudentOrStaffData("Mridul","22bcs056", "student", "9855985541", "22bcs056");
////        System.out.println(isSignedIn);
//        
//        boolean isLoggedIn = sosc.checkLogin("Mridul", "22bcs056");
//        System.out.println(isLoggedIn);
//    }
    
}
