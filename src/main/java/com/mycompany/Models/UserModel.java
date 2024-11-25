/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Models;
import java.time.LocalDateTime;



/**
 *
 * @author ANTRIKSH
 */
public class UserModel {
    String userId = "";
    String username = "";
    String password = "";
    String passwordHint = "";
    String emailId = "";
    String mobile = "";
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    
    public UserModel(String userId, String username, String password, String passwordHint, String emailId, String mobile){
        this.userId = userId;
        this.username = "";
        this.password = "";
        this.passwordHint = "";
        this.emailId = "";
        this.mobile = "";
        this.createdAt = LocalDateTime.now();//will use timestamp at the time of db query
        this.updatedAt = LocalDateTime.now();
    }
    
    public static void main(String[] args){
        UserModel um = new UserModel("1", "user","password", "passwordHint", "emailId", "mobile");
        System.out.println(um.userId+ um.username+ um.password+ um.passwordHint+ um.emailId + um.mobile + um.createdAt + um.updatedAt);
        
    }
    
}
