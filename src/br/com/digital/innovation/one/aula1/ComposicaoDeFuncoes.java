package br.com.digital.innovation.one.aula1;

import java.util.Arrays;

public class ComposicaoDeFuncoes {
    public static void main(String[] args) {
        int[] valores = {1,2,3,4};
        System.out.println("Expressoes lambda - java funcional - verifica numero par e dobra o valor");
        Arrays.stream(valores)
                .filter(numero -> numero % 2 == 0)//se for par
                .map(numero -> numero * 2)//dobra o valor
                .forEach(System.out::println);


        System.out.println("Expressoes lambda - java imperativo - verifica numero par e dobra o valor");
        for (int i=0; i< valores.length; i++){
            int valor=0;
            if (valores[i] % 2 == 0) {
                valor = valores[i]*2;
                if (valor != 0) {
                    System.out.println(valor);
                }
            }
        }
    }
}
