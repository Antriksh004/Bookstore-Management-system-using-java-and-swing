/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;
//import com.mycompany.bookmanagementsystem.BookManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

/**
 *
 * @author ANTRIKSH
 */
public class connection {
    String driver = "com.mysql.cj.jdbc.Driver"; // jdbc driver path

    String url = "jdbc:mysql://localhost:3306/bookstoremanagementsystem"; // database path
    String databaseUsername = "root"; // jdbc username
    String databasePassword = "Antriksh"; // jdbc password
    public Connection getConnection(){
        try {
            Class.forName(driver);//used to load/initlaize the JDBC driver class

            Connection conn = DriverManager.getConnection(url, databaseUsername, databasePassword); // establish a connection to database
            System.out.println("conn=" + conn);

            return conn;
        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e);
        }
        return null;
        
    }
    
}
