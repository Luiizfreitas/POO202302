/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javacrude;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import javacrude.DAO.Dao;

/**
 *
 * @author luiiz
 */
public class JavaCrude {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Dao executeDao = new Dao();
        
       
        
        
        //<editor-fold defaultstate="collapsed" desc="Creation of books">

            // 1 - Acquisition 3 days after the current date
            try{
                Book ficBook_1 = new Book(
                    "Aventuras no Mundo da Programacao",
                    "John Doe",
                    LocalDate.now().plusDays(3),
                    (short) 300,
                    (short) 2023,
                    (byte) 1,
                    new BigDecimal("29.99")
                );

                executeDao.saveOrUpdate(ficBook_1);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }




            // 2 - Inclusion of 3 classic Brazilian books
            try {
                Book classic1 = new Book(
                    "Dom Casmurro",
                    "Machado de Assis",
                    LocalDate.now(),
                    (short) 256,
                    (short) 1899,
                    (byte) 1,
                    new BigDecimal("15.99")
                );

                executeDao.saveOrUpdate(classic1);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            try {
                Book classic2 = new Book(
                    "Memórias Póstumas de Brás Cubas",
                    "Machado de Assis",
                    LocalDate.now(),
                    (short) 192,
                    (short) 1881,
                    (byte) 1,
                    new BigDecimal("12.99")
                );
                executeDao.saveOrUpdate(classic2);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            try {
                Book classic3 = new Book(
                    "Grande Sertão: Veredas",
                    "Guimarães Rosa",
                    LocalDate.now(),
                    (short) 600,
                    (short) 1956,
                    (byte) 1,
                    new BigDecimal("18.99")
                );
                executeDao.saveOrUpdate(classic3);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }


        //</editor-fold>

        ArrayList<Book> books = executeDao.findAll();
        
        System.out.println("------------- Books added to the BD -------------");
        for(Book book : books){
            book.printBook();
            System.out.println("-------------------------------------------------");
        }
        
        
        // 3 - Updating a book
       
        try{
                Book bookUpdate = new Book(
                2, 
                "Quarto de Despejo: Diário de uma Favelada",
                "Carolina Maria de Jesus",
                LocalDate.now(),
                (short) 250, 
                (short) 1960,
                (byte) 1, 
                new BigDecimal("19.99")
            );
            executeDao.saveOrUpdate(bookUpdate);
            
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        
        
        // 4 - Searching for a book
        
        System.out.println("----------------- Book Searched -----------------");
        Book bookSearch = executeDao.findById(3);
        bookSearch.printBook();
        System.out.println("-------------------------------------------------");
        
        
        // 5 - Showing all books
        books = executeDao.findAll();
        System.out.println("------------ All books in the database ----------");
        for(Book book : books){
            book.printBook();
            System.out.println("-------------------------------------------------");
        }
        
        // 6 - Deleting a book
        
        executeDao.delete(2);
        
        
        
        
    
        
    }
    
}
