package br.com.digital.innovation.one.aula3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamExemplo {

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        IntStream.range(1,10000).forEach(num -> fatorial(num));//serial
        long fim = System.currentTimeMillis();
        long tempoExecucao = fim - inicio;
        System.out.println("Tempo de execução serial: "+tempoExecucao+" ms");
/**********************************************************************************************************************/
        inicio = System.currentTimeMillis();
        IntStream.range(1,10000).parallel().forEach(num -> fatorial(num));//paralelo
        fim = System.currentTimeMillis();
        tempoExecucao = fim - inicio;
        System.out.println("Tempo de execução parallel: "+tempoExecucao+" ms");
/**********************************************************************************************************************/
        List<String> nomes = Arrays.asList("Cristian", "Bilert", "Java", "Desenvolvimento", "Parallel", "Stream");
        nomes.stream().parallel().forEach(System.out::println);

    }

    public static long fatorial(long num) {
        long fat = 1;
        for (long i = 2; i <= num; i++) {
            fat*=i;
        }
        return fat;
    }
}
