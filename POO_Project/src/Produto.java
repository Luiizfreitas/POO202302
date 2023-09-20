/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.math.BigDecimal;

/**
 *
 * @author luiiz
 */


/*

---> Faltando fazer o toString da classe compra
*/

public class Produto{
    private String nome; 
    private BigDecimal preco; 
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) throws Exception{
            if(nome.length() > 150)
                throw new Exception("Nome do produto nao pode ter 150+ caracteres");

            this.nome = nome;
        }

        public BigDecimal getPreco() {
            return preco;
        }

        public void setPreco(BigDecimal preco) {
            this.preco = preco;
        }
    //</editor-fold>

    @Override
    
    public String toString(){
        return nome + " R$ " + preco;
    }
}