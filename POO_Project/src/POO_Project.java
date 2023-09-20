/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author luiiz
 */
public class POO_Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
              
        //<editor-fold defaultstate="collapsed" desc="Criando Pessoas">
            Pessoa pAna = new Pessoa("29/01/2000");
            try { pAna.setNome("Ana Zaira"); } catch (Exception e) {System.out.println("( ! ) Ana: " + e.getMessage());}
            
            Pessoa pBeatriz = new Pessoa("28/01/1999");
            try { pBeatriz.setNome("Beatriz Yana"); } catch (Exception e) {System.out.println("( ! ) Beatriz: " + e.getMessage());}
            
            Pessoa pCecilia = new Pessoa("27/01/1998");
            try { pCecilia.setNome("Cecilia Xerxes"); } catch (Exception e) {System.out.println("( ! ) Cecilia: " + e.getMessage());}
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Criando Telefones">
            Telefone tel1 = new Telefone(3812341234l);
            Telefone tel2 = new Telefone(3823452345l);
            Telefone tel3 = new Telefone(38923452345l);
            Telefone tel4 = new Telefone(38934563456l);
            Telefone tel5 = new Telefone(38834563456l);
            
            pAna.addTelefoneAtList(tel1);
            pBeatriz.addTelefoneAtList(tel2);
            pBeatriz.addTelefoneAtList(tel3);
            pCecilia.addTelefoneAtList(tel4);
            pCecilia.addTelefoneAtList(tel5);
            
            
            
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Criando Enderecos">
            Endereco end1 = new Endereco(), end2 = new Endereco(), end3 = new Endereco(), 
                     end4 = new Endereco(), end5 = new Endereco(), end6 = new Endereco();
            
            end1.setTipoLogradouro(Endereco.TipoLogradouro.RUA);
            end1.setLogradouro("A1");
            end1.setNumero(1011); 
            end1.setBairro("Santa Ana I");
            end1.setCep(39401111);
            
            end2.setTipoLogradouro(Endereco.TipoLogradouro.RUA);
            end2.setLogradouro("A2");
            end2.setNumero(1012);
            end2.setBairro("Santa Ana II");
            end2.setCep(39401112);
            
            end3.setTipoLogradouro(Endereco.TipoLogradouro.RUA);
            end3.setLogradouro("B");
            end3.setNumero(2022);
            end3.setBairro("Santa Beatriz");
            end3.setCep(39402222);
            
            end4.setTipoLogradouro(Endereco.TipoLogradouro.RUA);
            end4.setLogradouro("C1");
            end4.setNumero(3031);
            end4.setBairro("Santa Cecilia I");
            end4.setCep(39403331);
            
            end5.setTipoLogradouro(Endereco.TipoLogradouro.RUA);
            end5.setLogradouro("C2");
            end5.setNumero(3032);
            end5.setBairro("Santa Cecilia II");
            end5.setCep(39403332);
            
            end6.setTipoLogradouro(Endereco.TipoLogradouro.RUA);
            end6.setLogradouro("C3");
            end6.setNumero(3033);
            end6.setBairro("Santa Cecilia III");
            end6.setCep(39403333);
            
            pAna.addEnderecoAtList(end1);
            pAna.addEnderecoAtList(end2);
            pBeatriz.addEnderecoAtList(end3);
            pCecilia.addEnderecoAtList(end4);
            pCecilia.addEnderecoAtList(end5);
            pCecilia.addEnderecoAtList(end6);
            
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Criando Credenciais">
            Credencial c1 = new Credencial(pAna, true);
            Credencial c2 = new Credencial(pBeatriz, false);
            Credencial c3 = new Credencial(pCecilia, false);
            
            try {c1.setSenha("asdf123"); } catch (Exception e) { System.out.println("( ! ) C1: " + e.getMessage()); }
            try {c2.setSenha("123asdf"); } catch (Exception e) { System.out.println("( ! ) C2: " + e.getMessage()); }
            try {c3.setSenha("123123");  } catch (Exception e) { System.out.println("( ! ) C3: " + e.getMessage()); }
            
            c1.setEmail("ana.zaira@mail.com");
            c2.setEmail("beatriz.yana@mail.com");
            c3.setEmail("cecilia.xerxes@mail.com");
            
            pAna.setCredencial(c1);
            pBeatriz.setCredencial(c2);
            pCecilia.setCredencial(c3);
            
            
            
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Criando Produtos">
            
        Produto produto1 = new Produto(), produto2 = new Produto(), produto3 = new Produto(),
                produto4 = new Produto(), produto5 = new Produto();
        
        try {
            produto1.setNome("Abacaxi");
            produto1.setPreco(BigDecimal.valueOf(1.99));
        } catch (Exception e) {
            System.out.println("( ! ) Produto 1: " + e.getMessage());
        }
        
        try {
            produto2.setNome("Banana");
            produto2.setPreco(BigDecimal.valueOf(2.99));
        } catch (Exception e) {
            System.out.println("( ! ) Produto 2: " + e.getMessage());
        }
        
        try {
            produto3.setNome("Caqui");
            produto3.setPreco(BigDecimal.valueOf(3.99));
        } catch (Exception e) {
            System.out.println("( ! ) Produto 3: " + e.getMessage());
        }
        
        try {
            produto4.setNome("Damasco");
            produto4.setPreco(BigDecimal.valueOf(4.99));
        } catch (Exception e) {
            System.out.println("( ! ) Produto 4: " + e.getMessage());
        }
        
        try {
            produto5.setNome("Espinafre");
            produto5.setPreco(BigDecimal.valueOf(5.99));
        } catch (Exception e) {
            System.out.println("( ! ) Produto 5: " + e.getMessage());
        }
       //</editor-fold>
       
        //<editor-fold defaultstate="collapsed" desc="Associando Itens às compras">
            
            Compra compra1Ana = new Compra(pAna, 1100101l);
            compra1Ana.addItemAtList(new Item(produto1, 11));
           
            
            Compra compra1Beatriz = new Compra(pBeatriz, 200202l);
            compra1Beatriz.addItemAtList(new Item(produto2, 11));
            compra1Beatriz.addItemAtList(new Item(produto3, 12));
            compra1Beatriz.addItemAtList(new Item(produto4, 13));
            compra1Beatriz.addItemAtList(new Item(produto5, 14));
            
            Compra compra2Beatriz = new Compra(pBeatriz, 200212l);
            compra2Beatriz.addItemAtList(new Item(produto1, 21));
            compra2Beatriz.addItemAtList(new Item(produto3, 22));
            compra2Beatriz.addItemAtList(new Item(produto5, 23));
            
            
            Compra compra1Cecilia = new Compra(pCecilia, 300303l);
            compra1Cecilia.addItemAtList(new Item(produto1, 31));
            compra1Cecilia.addItemAtList(new Item(produto3, 32));
            compra1Cecilia.addItemAtList(new Item(produto5, 33));
            
            
       
       //</editor-fold>
       
        //<editor-fold defaultstate="collapsed" desc="Associando Compras às Pessoas">
            pAna.addCompraAtList(compra1Ana);
            
            pBeatriz.addCompraAtList(compra1Beatriz);
            pBeatriz.addCompraAtList(compra2Beatriz);
            
            pCecilia.addCompraAtList(compra1Cecilia);
       //</editor-fold>
       
        //<editor-fold defaultstate="collapsed" desc="toString das Pessoas">
            System.out.println("Pessoa.toString");
            System.out.println("\t" + pAna.toString());
            System.out.println("\t" + pBeatriz.toString());
            System.out.println("\t" + pCecilia.toString());
       //</editor-fold>
       
       
       //<editor-fold defaultstate="collapsed" desc="toString dos Produtos">
            System.out.println("\nProduto.toString");
            System.out.println("\t" + produto1.toString());
            System.out.println("\t" + produto2.toString());
            System.out.println("\t" + produto3.toString());
            System.out.println("\t" + produto4.toString());
            System.out.println("\t" + produto5.toString());
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="toString das Credenciais">
            System.out.println("\nCredencial.toString");
            System.out.println("\t" + c1.toString());
            System.out.println("\t" + c2.toString());
            System.out.println("\t" + c3.toString());
        //</editor-fold>
       
    }
    
}
