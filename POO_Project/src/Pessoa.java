/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author luiiz
 */
public class Pessoa {

    String nome;
    LocalDate nascimento;
    Byte idade; 
    Credencial credencial;
    
    ArrayList<Compra> listaCompras;
    ArrayList<Telefone> listaTelefones; 
    ArrayList<Endereco> listaEnderecos; 
    
    //<editor-fold defaultstate="collapsed" desc="Construtores">
    
    public Pessoa(){
        listaCompras = new ArrayList<>(); 
        listaTelefones = new ArrayList<>(); 
        listaEnderecos = new ArrayList<>(); 
    };
    public Pessoa(LocalDate nascimento){
        this();
        this.nascimento = nascimento; 
        calcularIdade();
    }
    public Pessoa(Credencial credencial){
        this();
        this.credencial = credencial;
    }
    public Pessoa(Credencial credencial, LocalDate nascimento){
        this(nascimento);
        this.credencial = credencial; 
    }  
    public Pessoa(Credencial credencial, String nascimento){
        this(credencial);
        setNascimento(nascimento);
    }
    public Pessoa(String nascimento){
        this();
        setNascimento(nascimento);
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos para os arrayLists">
    
    public boolean addCompraAtList(Compra compra){
        return listaCompras.add(compra);
    }
    public boolean addTelefoneAtList(Telefone telefone){
        return listaTelefones.add(telefone);
    }
    public boolean addEnderecoAtList(Endereco endereco){
        return listaEnderecos.add(endereco);
    }
    
    public ArrayList<Compra> getListaCompras() {
        return listaCompras;
    }
    public ArrayList<Telefone> getListaTelefones() {
        return listaTelefones;
    }
    public ArrayList<Endereco> getListaEnderecos() {
        return listaEnderecos;
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Demais Getters/Setters">
    
    public String getNome() {
        return nome;
    }
    public LocalDate getNascimento() {
        return nascimento;
    }
    public Byte getIdade() {
        return idade;
    }
    public String getNascimentoBr() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.forLanguageTag("pt-BR"));
        return nascimento.format(formatter);
    }
    
    public void setNome(String nome) throws Exception{
        if(nome.length() > 45){
            throw new Exception("O nome nao pode ter 45+ caracteres");
        }
        
        if(nome.isEmpty()){
            throw new Exception("O nome nao pode ser vazio");
        }
        
        this.nome = nome;
    }
    public void setNascimento(String nascimento) {
        this.nascimento = converterData(nascimento);
        calcularIdade();
    }
    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

    private void setIdade(Byte idade) {
        this.idade = idade;
    }
    
//</editor-fold>

    
    private byte calcularIdade() {
        
        if(nascimento != null){
            LocalDate hoje = LocalDate.now();
            Period periodo = Period.between(nascimento, hoje);
            setIdade((byte)periodo.getYears());
            return (byte)periodo.getYears();
        }
        
        return -1;
    }
    
    public BigDecimal calcularGastoTotal() {
        BigDecimal gastoTotal = BigDecimal.ZERO;
    
        for (Compra compra : listaCompras) {
            gastoTotal = gastoTotal.add(compra.calcularTotal());
        }

        return gastoTotal;
    }
    
    private LocalDate converterData(String dataNascimento) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.forLanguageTag("pt-BR"));
        return LocalDate.parse(dataNascimento, formatter);
    }

    @Override
    public String toString() {
        
        int contador = 1;
        
        //<editor-fold defaultstate="collapsed" desc="Dados Pessoais">
        String dadosPessoais =  getNome() + ", " +
                                getNascimentoBr() + ", " + 
                                getIdade() + " Anos, " +
                                credencial.getEmail() + ", " + 
                                "Senha: '" + credencial.getSenha() + "', " +
                                (credencial.isAdministrador() ? "Administrador" : "Usuario Geral");
//</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Endereços">
        StringBuilder enderecos = new StringBuilder("[");
        
        contador = 1;
        for(Endereco endereco : listaEnderecos){
            if (contador > 1) {
                enderecos.append("; ");
            }
            enderecos.append(endereco.toString());
            contador++;
        }
        
        enderecos.append("]");
//</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Telefones">
        StringBuilder telefones = new StringBuilder("[");
        
        contador = 1;
        for(Telefone tel : listaTelefones){
            if (contador > 1) {
               telefones.append("; ");
            }
            telefones.append(tel.toString());
            contador++;
        }
        
        telefones.append("]");
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Compras">
        
        StringBuilder compras = new StringBuilder("[");
        
        contador = 1;
        for(Compra compra : listaCompras){
            if(contador > 1){
                compras.append("; ");
            }
            
            compras.append(compra.getNotaFiscalFormatada());
            compras.append(", R$ ");
            compras.append(compra.calcularTotal());
            
            contador++;
        }
        
        compras.append("]");
        //</editor-fold>
        
        return dadosPessoais        + ", " +
               "Enderecos: "        + enderecos.toString() + ", " +
               "Telefones: "        + telefones.toString() + ", " + 
               "Gasto total: R$ "   + calcularGastoTotal() + ", " + 
               "Compras: "          + compras.toString(); 
    }
    
}