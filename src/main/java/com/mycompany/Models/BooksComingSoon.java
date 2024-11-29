/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Models;

/**
 *
 * @author ANTRIKSH
 */
public class BooksComingSoon {
    
    public String bookname;
    
    
    public String authorName;
    public String publication;
    public String expectedDate;
    public BooksComingSoon(String bookname, String authorName, String publication, String expectedDate){
        this.bookname = bookname;
        this.authorName = authorName;
        this.publication = publication;
        this.expectedDate = expectedDate;
    }
    

    
    public String getBookname(){
        return this.bookname;
        
    };
   
    public String getAuthorName(){
        return this.authorName;
    };
    public String getPublication(){
        return this.publication;
    };
    public String getExpectedDate(){
        return this.expectedDate;
    };
    
    
    
}
