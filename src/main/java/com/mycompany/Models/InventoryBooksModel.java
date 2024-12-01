/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Models;

/**
 *
 * @author ANTRIKSH
 */
public class InventoryBooksModel {
    
    public String bookname;
    
    
    public String bookid;
    public String issuedDate;
    public String dueDate;
    public InventoryBooksModel(String bookname, String bookId, String issuedDate, String dueDate){
        this.bookname = bookname;
        this.bookid = bookId;
        this.issuedDate = issuedDate;
        this.dueDate = dueDate;
    }
    

    
    public String getBookname(){
        return this.bookname;
        
    };
   
    public String getBookId(){
        return this.bookid;
    };
    public String getIssuedDate(){
        return this.issuedDate;
    };
    public String getDueDate(){
        return this.dueDate;
    };
    
    
    
}
