package br.com.digital.innovation.one.aula1;

public class FatorialTailCall {
    static int i=0;
    public static void main(String[] args) {
        System.out.println(fatorialA(5));
        System.out.println(i);
    }

    public static double fatorialA(double valor) {
        return fatorialComTailCall(valor,1);
    }

    public static double fatorialComTailCall(double valor, double numero) {
        if (valor == 0 ) return numero;
        i++;
        return fatorialComTailCall(valor-1, valor *numero);
    }
}
