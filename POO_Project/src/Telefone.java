/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author luiiz
 */
public class Telefone {
    
    private Byte ddd;
    private int numero;
    
    public Telefone(){}
    
    public Telefone(long telefoneCompleto) {
        String telefoneStr = String.valueOf(telefoneCompleto);
        
              
        // Extrair o DDD (2 primeiros dígitos)
        this.ddd = Byte.valueOf(telefoneStr.substring(0, 2));
        
        // Extrair o número (os demais dígitos)
        this.numero = Integer.parseInt(telefoneStr.substring(2));
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Byte getDdd() {
        return ddd;
    }

    public void setDdd(Byte ddd) {
        this.ddd = ddd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    //</editor-fold>
    
    @Override
    public String toString() {
        int length = (int) (Math.log10(numero) + 1);
        String numeroStr = String.valueOf(numero);
        String retornoString;
        if(length == 8)
            retornoString = "(" + ddd + ") " + numeroStr.charAt(0) + numeroStr.charAt(1) + numeroStr.charAt(2) + numeroStr.charAt(3) + "-" + numeroStr.charAt(4) + numeroStr.charAt(5) + numeroStr.charAt(6) + numeroStr.charAt(7); 
        else if(length == 9)
            retornoString = "(" + ddd + ") " + numeroStr.charAt(0) + numeroStr.charAt(1) + numeroStr.charAt(2) + "-" + numeroStr.charAt(3) + numeroStr.charAt(4) + numeroStr.charAt(5) + "-" + numeroStr.charAt(6) + numeroStr.charAt(7) + numeroStr.charAt(8);
        else 
            retornoString = "(" + ddd + ") " + numeroStr; 
        
        return retornoString; 
    }
    
    
}