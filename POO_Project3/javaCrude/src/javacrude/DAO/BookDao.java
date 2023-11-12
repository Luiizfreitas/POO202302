/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javacrude.DAO;

import java.util.List;
import javacrude.Book;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author luiiz
 */
public interface BookDao {

    String getSaveStatement();

    String getUpdateStatement();

    String getFindByIdStatement();

    String getFindAllStatement();

    String getDeleteStatement();

    void composeSaveOrUpdateStatement(PreparedStatement pstmt, Book book);

    Book extractObject(ResultSet rs);

    List<Book> extractObjects(ResultSet rs);
}
