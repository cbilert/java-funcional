package br.com.digital.innovation.one.aula1;

import java.util.function.UnaryOperator;

public class Aula01 {
    public static void main(String[] args){
        System.out.println("Hello World!!!");
        System.out.println("Java Funcional!!!");
        System.out.println("Função Lambda que calcula o valor vezes 3 !!!");
        UnaryOperator<Integer> calculaValorVezesTres = valor -> valor*3;
        int valor = 10;
        System.out.println(calculaValorVezesTres.apply(valor));
    }
}
