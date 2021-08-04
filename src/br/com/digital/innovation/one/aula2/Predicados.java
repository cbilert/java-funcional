package br.com.digital.innovation.one.aula2;

import java.util.function.Predicate;

public class Predicados {
    public static void main(String[] args) {
        Predicate<String> estaVazioLambda = valor -> valor.isEmpty();
        Predicate<String> estaVazioMethodReference = String::isEmpty;

        System.out.println("Predicate Lambda");
        System.out.println(estaVazioLambda.test(""));
        System.out.println(estaVazioLambda.test("Cristian"));

        System.out.println("Predicate Method Reference");
        System.out.println(estaVazioMethodReference.test(""));
        System.out.println(estaVazioMethodReference.test("Cristian"));
    }
}
