/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Models;

/**
 *
 * @author ANTRIKSH
 */
public class AdminListModel {
    
    String name = "antriksh";
    
    
    String mobile = "66262626262";
    String id = "22bcs017";
    String emailId;
    public AdminListModel(String username, String mobile, String id, String emailId){
        this.name = username;
        this.mobile = mobile;
        this.id = id;
        this.emailId = emailId;
    }
    

    
    public String getUsername(){
        return this.name;
        
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
