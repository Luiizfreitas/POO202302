/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javacrude.DAO;

import java.util.ArrayList;
import javacrude.Book;



/**
 *
 * @author luiiz
 */
public interface lDao{
    long saveOrUpdate(Book book);
    Book findById(long id); 
    ArrayList<Book> findAll();
    void delete(long id);
}
