package no.hvl.dat108.oppgave3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class HamburgerBrett {
    
    private BlockingQueue<Hamburger> brett; 
    private int antallTotaltLaget;

    public HamburgerBrett(int kapasitet) {
        this.brett = new ArrayBlockingQueue<Hamburger>(kapasitet);
        this.antallTotaltLaget = 0;
    }

    public Hamburger leggTil() throws InterruptedException {
        antallTotaltLaget++;
        Hamburger nyHamburger = new Hamburger(antallTotaltLaget);
        this.brett.put(nyHamburger);

        return nyHamburger;
    }

    public Hamburger taAv() throws InterruptedException {
        return this.brett.take();
    }

    @Override
    public String toString() {
        return brett.toString();
    }


}
