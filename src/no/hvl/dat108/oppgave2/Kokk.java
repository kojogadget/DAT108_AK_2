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

            String navn = this.getName();
            Hamburger laget = brett.leggTil();
            System.out.println(navn + " (kokk) legger på hamburger " + laget + ". Brett: " + brett.toString());
        }
    }
    
}
