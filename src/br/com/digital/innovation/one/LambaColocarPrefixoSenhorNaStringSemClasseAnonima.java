package br.com.digital.innovation.one;

public class LambaColocarPrefixoSenhorNaStringSemClasseAnonima {

    public static void main(String[] args) {
        FuncaoSemClasseAnonima colocarPrefixoSenhorNaString = valor -> "Sr. " + valor;
        System.out.println(colocarPrefixoSenhorNaString.gerar("Cristian"));
    }
}

@FunctionalInterface
interface FuncaoSemClasseAnonima {
    String gerar (String valor);
}
