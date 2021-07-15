package br.com.digital.innovation.one;

public class ComClasseAnonimaColocarPrefixoSenhorNaString {

    public static void main(String[] args) {
        FuncaoComClasseAnonima colocarPrefixoSenhorNaString = new FuncaoComClasseAnonima() {
            @Override
            public String gerar(String valor) {
                return "Sr. "+ valor;
            }
        };
        System.out.println(colocarPrefixoSenhorNaString.gerar("Cristian"));
    }
}

@FunctionalInterface
interface FuncaoComClasseAnonima {
    String gerar (String valor);
}
