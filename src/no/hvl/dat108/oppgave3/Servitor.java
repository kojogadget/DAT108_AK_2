package no.hvl.dat108.oppgave3;

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

                String navn = this.getName();
                System.out.println(navn + " (servitør) tar av hamburger " + brett.taAv() + ". Brett: " + brett.toString());
            } catch (InterruptedException e) {
            }
        }
    }
    
}
