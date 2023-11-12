/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacrude.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javacrude.Book;
import javax.swing.JOptionPane;

/**
 *
 * @author luiiz
 */
public class Dao implements lDao{

    Connection conn;
    PreparedStatement pstm; 
    
    @Override
    public long saveOrUpdate(Book book) {
        //Verifica se o ID já existe no banco de dados. Caso sim, Atualiza. Caso não, Salva
        
        String sql = "SELECT id FROM book WHERE id = ?";
        conn = new ConnectionDao().conectaBD();
        
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setLong(1, book.getId());
            ResultSet rs = pstm.executeQuery();
            
            
            
            if(rs.next()){
                try {
                    sql = book.getUpdateStatement();
                   pstm = conn.prepareStatement(sql);
                    // title authors acquisition pages year edition price
                    pstm.setString(1, book.getTitle());
                    pstm.setString(2, book.getAuthors());
                    pstm.setDate(3, java.sql.Date.valueOf(book.getAcquisition()));
                    pstm.setShort(4, book.getPages());
                    pstm.setShort(5, book.getYear());
                    pstm.setByte(6, book.getEdition());
                    pstm.setBigDecimal(7, book.getPrice());
                
                    pstm.executeUpdate();
                    System.out.println("\n( ! ) Atualizado com sucesso\n");
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "javaCrude.Dao/Dao/saveOrUpdate/Update: " + erro.getMessage());
                }

            }else{
                sql = book.getSaveStatement();
                try {
                    pstm = conn.prepareStatement(sql);
                    pstm.executeUpdate();
                    System.out.println("\n( ! ) Inserido com sucesso\n");
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "javaCrude.Dao/Dao/saveOrUpdate/Save: " + erro.getMessage());
                }
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "javaCrude.Dao/Dao/saveOrUpdate/VerificacaoSeExiste: " + e.getMessage());
        } 
        
        return book.getId();
        
    }

    @Override
    public Book findById(long id) {
        conn = new ConnectionDao().conectaBD();
        PreparedStatement pstm;
       
        try {
            String sql = "SELECT * FROM book WHERE id = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setLong(1, id);
            ResultSet rs = pstm.executeQuery();
            
            if (rs.next()) {
                Book book = new Book();
                book.setId(rs.getLong("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthors(rs.getString("authors"));
                book.setAcquisition(rs.getDate("acquisition").toLocalDate());
                book.setPages(rs.getShort("pages"));
                book.setYear(rs.getShort("year"));
                book.setEdition(rs.getByte("edition"));
                book.setPrice(rs.getBigDecimal("price"));
                return book;
            }else{
                Book voidBook = new Book();
                voidBook.setId(-1);
                return voidBook;
            }
           
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "javaCrude.Dao/Dao/findById" + e.getMessage());
        }
       
        return null;
    }

    @Override
    public ArrayList<Book> findAll() {
        Connection conn = new ConnectionDao().conectaBD();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        ArrayList<Book> books = new ArrayList<>();

        try {
            String sql = "SELECT * FROM book";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getLong("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthors(rs.getString("authors"));
                book.setAcquisition(rs.getDate("acquisition").toLocalDate());
                book.setPages(rs.getShort("pages"));
                book.setYear(rs.getShort("year"));
                book.setEdition(rs.getByte("edition"));
                book.setPrice(rs.getBigDecimal("price"));

                books.add(book);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "javaCrude.Dao/Dao/findAll/TentativaDeBusca: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "javaCrude.Dao/Dao/findAll/Finally: " + e.getMessage());
            }
        }

        return books;
    }

    @Override
    public void delete(long id) {
        Connection conn = new ConnectionDao().conectaBD();
        PreparedStatement pstm = null;

        try {
            String sql = "DELETE FROM book WHERE id = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setLong(1, id);
            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("( ! ) Livro excluido com sucesso");
            } else {
                System.out.println("( ! ) Nenhum livro foi excluido (ID não encontrado)");
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "javaCrude.Dao/Dao/delete: " + e.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "javaCrude.Dao/Dao/delete/Finally: " + e.getMessage());
            }
        }
    }

    
    
   
    
}
