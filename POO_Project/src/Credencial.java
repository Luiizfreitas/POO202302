/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author luiiz
 */
public class Credencial {
    private String email, senha;
    private Boolean administrador;
    
    private Pessoa pessoa;
    
    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Credencial() {
        administrador = false;
    }
    
    public Credencial(Pessoa pessoa){
        this();
        this.pessoa = pessoa;
    }
    
    public Credencial(Pessoa pessoa, Boolean administrador){
        this(pessoa);
        this.administrador = administrador;
    }
    //</editor-fold>
    

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     public void setSenha(String senha) throws Exception {
        if(senha.length() > 12){
            throw new Exception("A senha não pode ter 12+ caracteres");
        }
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public Boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    //</editor-fold>

    @Override
    public String toString() {
        return email + ", '" + senha + "', " + (administrador?"Administrador":"Usuário geral");
    }
}