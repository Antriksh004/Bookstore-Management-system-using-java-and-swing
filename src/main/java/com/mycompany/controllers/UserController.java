/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.mycompany.database.connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
//    public static void main(String[] args){
//        UserController sosc = new UserController();
////        boolean isSignedIn = sosc.InsertStudentOrStaffData("Mridul","22bcs056", "student", "9855985541", "22bcs056");
////        System.out.println(isSignedIn);
//        
//        boolean isLoggedIn = sosc.checkLogin("Mridul", "22bcs056");
//        System.out.println(isLoggedIn);
//    }
}