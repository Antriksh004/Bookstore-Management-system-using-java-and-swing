/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bookmanagementsystem;
import com.mycompany.database.connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
/**
 *
 * @author ANTRIKSH
 */
public class BookManagementSystem {
    public String[] getUserById(String userId, String type){
        
        try{
            connection c = new connection();
            Connection con = c.getConnection();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM student "
                    + "WHERE universityid = '"+userId +"'";
            if("staff".equals(type)){
                query = "SELECT * FROM staff "
                    + "WHERE universityid = '"+userId +"'";
            }
            System.out.println(query);
            
            ResultSet rs = stmt.executeQuery(query);
            
            if(rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                String userType = rs.getString("type");
    
                String mobile = rs.getString("mobile");
                String universityId = rs.getString("universityid"); 
                String[] result = {username,password,userType, mobile, universityId};
                return result;
            }else{
                System.out.println("No result found for the user");
            }
            
            
        }catch(SQLException e){
            System.out.println("SQL exception occured!");
            e.printStackTrace();
            
        }
        return null;
        
    }

    public static void main(String[] args) {
        BookManagementSystem bms = new BookManagementSystem();
        String[] details = bms.getUserById("22bcs017", "student");
        if(details !=  null){
            for(String a : details){
                System.out.println(a);
            }
        }else{
            System.out.println("Null was returned");
        }
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        System.out.println(ts.getTime());
        System.out.println(ts);
        
        
        
        
    }
    
}
