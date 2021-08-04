package br.com.digital.innovation.one.aula3;

public class ThreadExemplo {

    public static void main(String[] args) {
        BarraDeCarregamento2 barraDeCarregamento20 = new BarraDeCarregamento2();
        BarraDeCarregamento2 barraDeCarregamento21 = new BarraDeCarregamento2();
        BarraDeCarregamento2 barraDeCarregamento22 = new BarraDeCarregamento2();
        barraDeCarregamento20.start();
        barraDeCarregamento21.start();
        barraDeCarregamento22.start();
    }

}


class GerarPDF implements Runnable {

    @Override
    public void run() {
        System.out.println("Gera PDF");
    }
}

class BarraDeCarregamento implements Runnable {

    @Override
    public void run() {
        System.out.println("Loading...");
    }
}

class BarraDeCarregamento2 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("Rodei..."+this.getName());
    }
}
