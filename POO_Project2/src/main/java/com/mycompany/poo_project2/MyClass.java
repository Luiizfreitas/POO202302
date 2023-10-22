/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo_project2;
import java.util.List;

/**
 *
 * @author luiiz
 */
public class MyClass {
    public static Tuple<Double, Double> metodo(List<Double> entradas, List<Double> saidas) {
        Integer epocas = 2000;
        Double taxaAprendizado = 0.025;

        return metodo(entradas, saidas, epocas, taxaAprendizado);
    }

    public static Tuple<Double, Double> metodo(List<Double> entradas, List<Double> saidas, Integer epocas) {
        Double taxaAprendizado = 0.025;

        return metodo(entradas, saidas, epocas, taxaAprendizado);
    }

    public static Tuple<Double, Double> metodo(List<Double> entradas, List<Double> saidas, Integer epocas, Double taxaAprendizado) {
        Double peso0 = 0.0;
        Double peso1 = 0.0;
        Double previsao;
        Double erro;
        Integer contador = 0;

        for (int i = 0; i < epocas; i++) {
            for (int j = 0; j < entradas.size(); j++) {
                previsao = peso1 * entradas.get(j) + peso0;
                erro = saidas.get(j) - previsao;
                peso0 += erro * taxaAprendizado;
                peso1 += erro * taxaAprendizado * entradas.get(j);
            }
            if (contador % 10 == 0) {
                System.out.printf("Época: %d / Peso1: %.3f / Peso0: %.3f\n", i, peso1, peso0);
            }
            contador++;
        }

        return new Tuple<>(peso1, peso0);
    }
}
