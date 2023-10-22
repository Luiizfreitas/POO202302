/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo_project2_2;

/**
 *
 * @author luiiz
 */
public class Util {
    public static boolean validarCpf(long cpf) {
        String cpfString = String.valueOf(cpf);
        return validarCpf(cpfString);
    }

    public static boolean validarCpf(String cpf) {
        cpf = cpf.replaceAll("\\D", ""); // Remove todos os caracteres não numéricos
        if (cpf.length() != 11 || cpf.matches(cpf.charAt(0) + "{11}")) {
            return false;
        }

        int digito1 = obterDigito(cpf, 9);
        int digito2 = obterDigito(cpf, 10);

        return digito1 == Character.getNumericValue(cpf.charAt(9)) &&
               digito2 == Character.getNumericValue(cpf.charAt(10));
    }

    public static int obterDigito(String numero, int posicao) {
        if (posicao < 1 || posicao > 11) {
            throw new IllegalArgumentException("Posição de dígito inválida. Deve estar entre 1 e 11.");
        }
        int soma = 0;
        int peso = posicao + 1;
        for (int i = 0; i < posicao; i++) {
            int valor = Character.getNumericValue(numero.charAt(i));
            soma += valor * peso;
            peso--;
        }
        int resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }

    
}
