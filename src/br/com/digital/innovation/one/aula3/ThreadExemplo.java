package br.com.digital.innovation.one.aula3;

public class ThreadExemplo {

    public static void main(String[] args) {
//        BarraDeCarregamento barraDeCarregamento = new BarraDeCarregamento();
//        BarraDeCarregamento2 barraDeCarregamento2 = new BarraDeCarregamento2();
//        BarraDeCarregamento3 barraDeCarregamento3 = new BarraDeCarregamento3();
//        Thread t = new Thread(new BarraDeCarregamento3());
//
//        barraDeCarregamento.run();
//        t.start();
//        barraDeCarregamento2.start();
//        barraDeCarregamento3.start();


        GeradorPDF iniciarGeradorPDF = new GeradorPDF();
        BarraDeCarregamento3 iniciarBarraCarregamento = new BarraDeCarregamento3(iniciarGeradorPDF);

        iniciarGeradorPDF.start();
        iniciarBarraCarregamento.start();
    }

}


class GeradorPDF extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Iniciar geração do PDF...");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PDF Gerado.");
    }
}

class BarraDeCarregamento implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Loading...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BarraDeCarregamento2 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            super.run();
            System.out.println("Rodei BarraDeCarregamento2..." + this.getName());
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BarraDeCarregamento3 extends Thread {
    Thread thread;
    public BarraDeCarregamento3(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            while(true) {
                Thread.sleep(500);
                if(!thread.isAlive()) {
                    break;
                }
                System.out.println("Loading....");

            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
