/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poo_project2_2;

import static com.mycompany.poo_project2_2.Util.validarCpf;

/**
 *
 * @author luiiz
 */
public class Program {
    public static void main(String[] args) {
        // Teste 1
        String cpf1 = "14230703058";
        System.out.println("Teste 1");
        System.out.println("CPF: " + cpf1);
        System.out.println("Resposta: " + (Util.validarCpf(cpf1) ? "Válido" : "Inválido"));

        // Teste 2
        String cpf2 = "142.307.030-58";
        System.out.println("\nTeste 2");
        System.out.println("CPF: " + cpf2);
        System.out.println("Resposta: " + (Util.validarCpf(cpf2) ? "Válido" : "Inválido"));

        // Teste 3
        String cpf3 = "230703058";
        System.out.println("\nTeste 3");
        System.out.println("CPF: " + cpf3);
        System.out.println("Resposta: " + (Util.validarCpf(cpf3) ? "Válido" : "Inválido"));

        // Teste 4
        String cpf4 = "002.307.030-58";
        System.out.println("\nTeste 4");
        System.out.println("CPF: " + cpf4);
        System.out.println("Resposta: " + (Util.validarCpf(cpf4) ? "Válido" : "Inválido"));
        
        
    }
   
}
