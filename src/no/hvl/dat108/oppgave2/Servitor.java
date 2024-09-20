package no.hvl.dat108.oppgave2;

import java.util.Random;

public class Servitor extends Thread {

    HamburgerBrett brett;

    public Servitor(HamburgerBrett brett, String navn) {
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
            Hamburger tatt = brett.taAv();
            System.out.println(navn + " (servitør) tar av hamburger " + tatt + ". Brett: " + brett.toString());
        }
    }
    
}
