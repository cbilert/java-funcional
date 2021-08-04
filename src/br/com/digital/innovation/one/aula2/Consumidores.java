package br.com.digital.innovation.one.aula2;

import java.util.function.Consumer;

public class Consumidores {
    public static void main(String[] args) {
        //Method Reference

        // - apenas
        // - utilizar o paremetro da forma que ele foi recebido;

        Consumer<String> imprimirUmaFrase = System.out::println;
        imprimirUmaFrase.accept("Hello Word!  - Method Reference!!!");

        //Sintaxe da Lambda
        Consumer<String> imprimirUmaFrase2 = frase -> System.out.println(frase);
        imprimirUmaFrase2.accept("Hello Word!  - Sintaxe Lambda!!!");
    }

}
