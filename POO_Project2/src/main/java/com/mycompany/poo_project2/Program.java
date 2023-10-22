/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poo_project2;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luiiz
 */
public class Program {

    // Método de teste para treinar o modelo com entradas e saídas iguais
    public static void primeiroTeste() {
        List<Double> entradas = new ArrayList<>();
        List<Double> saidas = new ArrayList();

        // Preenchendo as listas de entrada e saída
        entradas.add(1.0);
        entradas.add(3.0);
        entradas.add(5.0);

        saidas.add(1.0);
        saidas.add(3.0);
        saidas.add(5.0);

        // Chama o método MyClass.metodo para treinamento
        Tuple<Double, Double> resultado = MyClass.metodo(entradas, saidas, 2000, 0.025);
    }

    // Método de teste para treinar o modelo com entradas e saídas diferentes
    public static void segundoTeste() {
        List<Double> entradas = new ArrayList<>();
        List<Double> saidas = new ArrayList<>();

        // Preenchendo as listas de entrada e saída
        entradas.add(1.0);
        entradas.add(3.0);
        entradas.add(5.0);

        saidas.add(2.0);
        saidas.add(4.0);
        saidas.add(6.0);

        // Chama o método MyClass.metodo para treinamento
        Tuple<Double, Double> resultado = MyClass.metodo(entradas, saidas, 2000, 0.025);
    }

    // Métodos de teste adicionais para diferentes configurações de entrada e saída
    public static void terceiroTeste() {
        // ...
    }

    public static void quartoTeste() {
        // ...
    }

    public static void quintoTeste() {
        // ...
    }

    // Método principal que chama os métodos de teste
    public static void main(String[] args) {
        primeiroTeste();
        segundoTeste();
        terceiroTeste();
        quartoTeste();
        quintoTeste();
    }
}
