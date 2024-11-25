/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Models;

import java.sql.Timestamp;

/**
 *
 * @author ANTRIKSH
 */
public class AdminModel {
    public String id = "";
    public String name = "";
    public String password = "";
    public String mobile = "";

    public String securityQuestion = "";
    public String securityAnswer = "";
    public String emailId = "";
    public Timestamp createdAt;
    public Timestamp updatedAt;
    
    public AdminModel(String adminId, String adminName, String password, String mobile, String securityQuestion, String securityAnswer, String emailId){
        this.id = adminId;
        this.name = adminName;
        this.password = password;
        this.mobile = mobile;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.emailId = emailId;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
