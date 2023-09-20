/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author luiiz
 */

import java.math.BigDecimal;
import java.util.ArrayList;


public class Compra {
    private Long notaFiscal;
    
    private ArrayList<Item> listaItens;

    private Pessoa pessoa;
    
    public Compra() {
        listaItens = new ArrayList<>();
    }
    
    
    public Compra(Pessoa pessoa){
        this();
        this.pessoa = pessoa;
    }
    
    public Compra(Pessoa pessoa, Long notaFiscal){
        this(pessoa);
        setNotaFiscal(notaFiscal);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
    
    

    //<editor-fold defaultstate="collapsed" desc="Gettres/Setters">
    public Long getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(Long notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    
    
    
    public boolean addItemAtList(Item item){
        return listaItens.add(item); 
    }
    
    public ArrayList<Item> getItens(){
        return listaItens;
    }


    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public BigDecimal calcularTotal(){
        BigDecimal soma = new BigDecimal("0");
        
        for(int i=0; i < listaItens.size(); i++){
            soma = soma.add(listaItens.get(i).calcularTotal());
        }
        
        return soma;
    }
    
     
    private String formatarNotaFiscal(Long notaFiscal) {
        if (notaFiscal != null) {
            // Usando String.format para formatar o número da nota fiscal
            return String.format("%09d", notaFiscal);
        } else {
            return "Nota Fiscal não disponível";
        }
    }
    
    public String getNotaFiscalFormatada(){
        String notaFiscalStr = formatarNotaFiscal(notaFiscal);
        String notaFiscalConstruida = notaFiscalStr.substring(0, 3) + "." + 
                                      notaFiscalStr.substring(3, 6) + "." + 
                                      notaFiscalStr.substring(6);
        
        return notaFiscalConstruida;
    }
    
    
    
    @Override
    public String toString() {
        String notaFiscalConstruida = getNotaFiscalFormatada();
        
        

        StringBuilder listaItensConstruida = new StringBuilder("[");
        int contador = 1;

        for (Item i : listaItens) {
            if (contador > 1) {
                listaItensConstruida.append("; ");
            }
            listaItensConstruida.append("Item ").append(contador).append(": ").append(i.toString());
            contador++;
        }

        listaItensConstruida.append("]");

        return "Nota Fiscal: " + notaFiscalConstruida + "; " +
               "Cliente: " + pessoa.getNome() + "; " +
               "R$ " + pessoa.calcularGastoTotal() + "; " + 
               listaItensConstruida.toString();
    }

}
