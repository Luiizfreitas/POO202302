/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author luiiz
 */
public class Endereco {
    private TipoLogradouro tipoLogradouro; 
    private String logradouro;
    private int numero;
    private String bairro;
    private int cep;
    
    
    public enum TipoLogradouro {
        AVENIDA, RUA, PRACA, OUTRO;
    }

    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    

         
    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }
    
    //</editor-fold>
    
    
    @Override
    
    public String toString(){
        String cepFormatado = String.format("%02d.%03d-%03d", cep / 1000000, (cep / 1000) % 1000, cep % 1000);
        return tipoLogradouro + " " + logradouro + ", " + numero + ", " + bairro + ", " + cepFormatado;
    
    }
    
}