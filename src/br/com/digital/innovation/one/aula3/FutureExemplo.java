package br.com.digital.innovation.one.aula3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class FutureExemplo {

    private static final ExecutorService pessoasParaExecutarAtividade = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {
        Casa casa = new Casa(new Quarto());
        List<? extends Future<String>> futuros =
        new CopyOnWriteArrayList<>(casa.obterAfazeresDaCasa().stream()
                .map(atividade -> pessoasParaExecutarAtividade.submit(() -> {
                    try {
                        return atividade.realizar();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                }))
                .collect(Collectors.toList()));

//        while (!futuros.stream().allMatch(Future::isDone)) {
        while (true) {
            int numeroDeAtividadesNaoFinalizadas = 0;
            for(Future<?>futuro: futuros){
                if (futuro.isDone()) {
                    try {
                        System.out.println("Parabéns você terminou de "+ futuro.get());
                        futuros.remove(futuro);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                } else {
                    numeroDeAtividadesNaoFinalizadas ++;
                }
            }
            if (futuros.stream().allMatch(Future::isDone)) {
                break;
            }
            System.out.println("Número de atividades não finalizadas :: "+ numeroDeAtividadesNaoFinalizadas);
            Thread.sleep(1000);
        }
        pessoasParaExecutarAtividade.shutdown();
    }
}

class Casa {
    private List<Comodo> comodos;

    Casa(Comodo... comodos) {this.comodos = Arrays.asList(comodos);}

    List<Atividade> obterAfazeresDaCasa() {
        return this.comodos.stream()
                .map(Comodo::obterAfazeresDoComodo)
                .reduce(new ArrayList<Atividade>(),(pivo, atividades) -> {
                    pivo.addAll(atividades);
                    return pivo;
                });
    }
}

interface Atividade {
    String realizar() throws InterruptedException;
}

abstract class Comodo {
    abstract List<Atividade> obterAfazeresDoComodo();
}

class Quarto extends Comodo {

    @Override
    List<Atividade> obterAfazeresDoComodo() {
        return Arrays.asList(
                this::getArrumarACama,
                this::varrerQuarto,
                this::arrumarGuardaRoupa
        );
    }

    private String arrumarGuardaRoupa() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Arrumar o guarda roupa.");
        return "Arrumar o guarda roupa.";
    }

    private String varrerQuarto() throws InterruptedException {
        Thread.sleep(7000);
        System.out.println("Varrer o Quarto.");
        return "Varrer o Quarto.";
    }

    private String getArrumarACama() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("Arrumar a Cama.");
        return "Arrumar a Cama.";
    }
}