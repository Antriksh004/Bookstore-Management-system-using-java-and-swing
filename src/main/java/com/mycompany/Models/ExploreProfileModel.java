/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Models;
import com.mycompany.controllers.BookController;

/**
 *
 * @author ANTRIKSH
 */
public class ExploreProfileModel {
    public String username = "User1";
    public String userId = "22xxxxxx";
    public String noOfBooksIssued = "0";
    public String noOfBooksDue = "0";
    
    public static String booksIssued(String userid){
        
        String count = BookController.getCountOfIssuedBooks(userid);
        return count;
        
        
        
    }
    public static String booksDue(String userid){
        String count = BookController.getCountOfDueBooks(userid);
        return count;
    }
    
    public ExploreProfileModel(String username, String userId){
        this.username = username;
        this.userId = userId;
        this.noOfBooksIssued = booksIssued(userId);
        this.noOfBooksDue = booksDue(userId);
    }
    
}
