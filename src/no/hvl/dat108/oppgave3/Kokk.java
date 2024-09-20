package no.hvl.dat108.oppgave3;

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

                String navn = this.getName();
                System.out.println(navn + " (kokk) legger på hamburger " + brett.leggTil() + ". Brett: " + brett.toString());
            } catch (InterruptedException e) {
            }
        }
    }
    
}
