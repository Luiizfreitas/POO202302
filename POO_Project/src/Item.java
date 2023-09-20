/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.math.BigDecimal;

/**
 *
 * @author luiiz
 */
public class Item {
    private int quantidade; 
    private Produto produto;
    
    
    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Item(){};
    public Item(Produto produto){
        this.produto = produto;
    };
    
    public Item(Produto produto, int quantidade){
        this(produto);
        this.quantidade = quantidade;
    }
//</editor-fold>
    
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public BigDecimal calcularTotal(){
        return produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
    }
    
    @Override
    public String toString(){
        return produto.getNome() + " " + quantidade + " x R$ " + produto.getPreco() + " = R$ " + calcularTotal(); 
    }
  
    
}