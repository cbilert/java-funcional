package br.com.digital.innovation.one;

import java.util.function.Function;

public class LambdaBuscarUsuario {

    public static void main(String[] args) {
        Function<Integer, Object> buscarUsuario = idUsuario -> new Object();//busca meu usuario

        System.out.println(buscarUsuario.apply(10));
    }
}
