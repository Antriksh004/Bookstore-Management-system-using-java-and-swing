/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.mycompany.database.connection;
import com.mycompany.Models.AdminModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ANTRIKSH
 */
public class AdminController {
    static String AdminAccessCode = "admin";
    static public boolean checkAdminLogin(String adminAccessCode, String adminId, String adminName, String password){
        if(adminAccessCode.equals(AdminAccessCode)){
            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;
        

        try {
            connection c = new connection();
            con = c.getConnection();
            String query = "select password from admin WHERE  id = '" + adminId + "' and name = '"+adminName+"';";
            // create a statement
            stmt = con.createStatement(); 

            rs = stmt.executeQuery(query); 

            
            while (rs.next()) {
                
                String clientPassword = rs.getString(1);
                
                if(password.equals(clientPassword)){
                    
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
        }
        return false;

    }
    public boolean InsertAdminData(String adminId,String adminAccessCode, String adminName, String password, String mobile, String securityQuestion,String securityAnswer, String emailId){
        
        AdminModel am = new AdminModel(adminId, adminName, password, mobile, securityQuestion, securityAnswer, emailId);
        Connection con; 
        Statement stmt = null;
        
        
        String query = "INSERT INTO admin (id,name, password, mobile, security_question, security_answer, email_id, created_at, updated_at) "
                 + "VALUES ('" + am.id + "', '" + am.name + "', '" + am.password +"', '" + am.mobile +"', '" + am.securityQuestion + "', '" + am.securityAnswer + "', '"+am.emailId+"', '" + am.createdAt + "', '" + am.updatedAt + "');"; // Proper SQL syntax
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
}
