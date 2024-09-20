package no.hvl.dat108.oppgave2;

import java.util.Random;

public class Kokk extends Thread {

    HamburgerBrett brett;

    public Kokk(HamburgerBrett brett, String navn) {
        super(navn);
        this.brett = brett;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(new Random().nextInt(2000, 6000));
            } catch (InterruptedException e) {
            }

            synchronized (brett) {
                String navn = this.getName();
                if (brett.erFull()) {
                    System.out.println(navn + " (kokk) ønsker å legge på hamburger, men brettet er fullt. Venter!");
                    try {
                        brett.wait();
                    } catch (InterruptedException e) {
                    }
                }
                Hamburger laget = brett.leggTil();
                System.out.println(navn + " (kokk) legger på hamburger " + laget + ". Brett: " + brett.toString());
                brett.notifyAll();
            }
        }
    }
    
}
