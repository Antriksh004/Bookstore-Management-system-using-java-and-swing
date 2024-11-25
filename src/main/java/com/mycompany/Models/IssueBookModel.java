/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Models;

import java.sql.Timestamp;
import java.util.Calendar;


/**
 *
 * @author ANTRIKSH
 */
public class IssueBookModel {
    public String userId = "";
    public String username = "";
    
    public String emailId = "";
    public String bookid = "";
    public String bookname = "";
    public Timestamp issuedAt = new Timestamp(System.currentTimeMillis());
    public Timestamp dueOn = null;
    
    public IssueBookModel(String userId, String username, String emailId, String bookid, String bookname){
        this.userId = userId;
        this.username = username;
        this.emailId = emailId;
        this.bookid = bookid;
        this.bookname = bookname;
        this.issuedAt = new Timestamp(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(issuedAt);
        calendar.add(Calendar.MONTH, 1); 

        
        this.dueOn = new Timestamp(calendar.getTimeInMillis());
    }
        
}
