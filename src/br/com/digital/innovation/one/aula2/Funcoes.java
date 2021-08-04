package br.com.digital.innovation.one.aula2;

import java.util.function.Function;

public class Funcoes {
    public static void main(String[] args) {
        Function<String,String> retornarNomeAoContrario = texto -> new StringBuilder(texto).reverse().toString();
        Function<String, Integer> converteStringParaInteiro = string -> Integer.parseInt(string);
        Function<String, Integer> converteStringParaInteiroECalculaODobro = string-> converteStringParaInteiro.apply(string)*2;
        System.out.println(retornarNomeAoContrario.apply("Cristian Bilert"));
        System.out.println(converteStringParaInteiro.apply("22021988"));
        System.out.println(converteStringParaInteiroECalculaODobro.apply("22021988"));
    }
}
