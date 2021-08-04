package br.com.digital.innovation.one.aula2;

import javax.sound.midi.Soundbank;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {
    public static void main(String[] args) {
        String[] nomes = {"Nome 1","Nome 2","Nome 3","Nome 4","Nome 5","Nome 6","Cristian","Nome 7"};
        Integer[] numeros = {1,2,3,4,5};
        System.out.println("Imprime o dobro de cada numero laco for");
        imprimirODobroDeCadaItemDaListaFOR(numeros);

        System.out.println("\n\n\nImprime o dobro de cada numero stream");
        imprimirODobroDeCadaItemDaListaSTREAM(numeros);

        System.out.println("\n\n\nImprime com laco for");
        imprimirTodosOsNomesFOR(nomes);

        System.out.println("\n\n\nFiltro com laco for");
        imprimirNomesFiltradosFOR(nomes);

        System.out.println("\n\n\nImprime com stream");
        imprimirTodosOsNomesSTREAM(nomes);

        System.out.println("\n\n\nFiltro com stream");
        imprimirNomesFiltradosSTREAM(nomes);
    }

    public static void imprimirNomesFiltradosFOR(String... nomes) {
        String nomesParaImprimir="";
        for(int i=0; i<nomes.length; i++) {
            if (nomes[i].equals("Cristian")) {
                nomesParaImprimir=" "+nomes[i];
            }
        }
        System.out.println(nomesParaImprimir);
    }

    public static void imprimirNomesFiltradosSTREAM(String... nomes){
        String nomesResultado = Stream.of(nomes)
                .filter(nome -> nome.equals("Cristian"))
                .collect(Collectors.joining(","));
        System.out.println(nomesResultado);
    }

    public static void imprimirTodosOsNomesFOR(String... nomes) {
        for(int i=0; i<nomes.length; i++) {
            System.out.println(nomes[i]);
        }
    }
    public static void imprimirTodosOsNomesSTREAM(String... nomes) {
        Stream.of(nomes)
                .forEach(System.out::println);
    }

    public static void imprimirODobroDeCadaItemDaListaFOR(Integer... numeros) {
        for(Integer numero: numeros) {
            System.out.println(numero*2);
        }
    }

    public static void imprimirODobroDeCadaItemDaListaSTREAM(Integer... numeros) {
        Stream.of(numeros)
                .map(numero-> numero*2)
                .forEach(System.out::println);
    }

}
