package br.com.digital.innovation.one;

public class Recursividade {
    static int i;
    public static void main(String[] args) {
        i=0;
        System.out.println(fatorialRecursivo(10));
        System.out.println(i);
    }

    public static int fatorialRecursivo(int value) {
        i++;
        if (value == 1) {
            return value;
        } else {
            return value * fatorialRecursivo(value -1);
        }
    }
}
