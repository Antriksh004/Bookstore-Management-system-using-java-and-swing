/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Models;

/**
 *
 * @author ANTRIKSH
 */
public class UserModel {
    
    String username = "antriksh";
    
    
    String mobile = "66262626262";
    String id = "22bcs017";
    String emailId;
    public UserModel(String username, String mobile, String id, String emailId){
        this.username = username;
        this.mobile = mobile;
        this.id = id;
        this.emailId = emailId;
    }
    

    
    public String getUsername(){
        return this.username;
        
    };
   
    public String getMobile(){
        return mobile;
    };
    public String getId(){
        return id;
    };
    public String getEmailId(){
        return emailId;
    };
    
    
    
}
