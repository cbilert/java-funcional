package br.com.digital.innovation.one.aula2;

public class FuncaoAltaOrdem {
    public static void main(String[] args) {
        Calulo SOMA = Integer::sum;
        Calulo SUBT = (a, b) -> a-b;
        Calulo DIVI = (a, b) -> a/b;
        Calulo MULT = (a, b) -> a*b;

        System.out.println(executarOperacao(SOMA,1,3));//4
        System.out.println(executarOperacao(SUBT,4,3));//1
        System.out.println(executarOperacao(DIVI,4,2));//2
        System.out.println(executarOperacao(MULT,7,3));//21
    }

    public static int executarOperacao(Calulo calulo, int a, int b) {
        return calulo.calcular(a, b);
    }
}

interface Calulo {
    int calcular(int a, int b);
}
