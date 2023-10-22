/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo_project2;

/**
 *
 * @author luiiz
 */
public class Tuple<T,U> {
    
    private T valorA;
    private U valorB;

    public Tuple() {
    }

    public Tuple(T valorA, U valorB) {
        this.valorA = valorA;
        this.valorB = valorB;
    }

    public T getValorA() {
        return valorA;
    }

    public void setValorA(T valorA) {
        this.valorA = valorA;
    }

    public U getValorB() {
        return valorB;
    }

    public void setValorB(U valorB) {
        this.valorB = valorB;
    }
    
    @Override
    public String toString() {
        return '<' + valorA.toString() + ", " + valorB.toString() + '>';
    }
    
}
