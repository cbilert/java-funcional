package br.com.digital.innovation.one.aula2;

import java.util.function.Supplier;

public class Supridores {
    public static void main(String[] args) {
        Supplier<Pessoa> instanciaPessoaLambda = () -> new Pessoa();
        Supplier<Pessoa> instanciaPessoaMethodReference = Pessoa::new;
        System.out.println(instanciaPessoaLambda.get());
        System.out.println(instanciaPessoaMethodReference.get());
    }
}

class Pessoa {
    private String nome;
    private Integer idade;

    public Pessoa() {
        this.nome = "Cristian";
        this.idade = 33;
    }

    @Override
    public String toString() {
        return String.format("nome: %s, idade: %d",nome,idade);
    }
}
