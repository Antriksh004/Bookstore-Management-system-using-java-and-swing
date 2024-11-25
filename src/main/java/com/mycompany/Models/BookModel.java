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
public class BookModel {
    public String name = "";
    public String price = "";
    public String author = "";
    public String publication = "";
    public Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    public Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
    public BookModel(String name, String price, String author, String publication){
        this.name = name;
        this.price = price;
        this.author = author;
        this.publication = publication;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
        
    }
    
    
    
    
}
