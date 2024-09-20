package no.hvl.dat108.oppgave2;

import java.util.LinkedList;

public class HamburgerBrett {
    
    private int kapasitet;
    private LinkedList<Hamburger> brett; 
    private int antallPaaBrett;
    private int antallTotaltLaget;

    public HamburgerBrett(int kapasitet) {
        this.kapasitet = kapasitet;
        this.brett = new LinkedList<Hamburger>();
        this.antallPaaBrett = 0;
        this.antallTotaltLaget = 0;
    }

    public synchronized Hamburger leggTil() {
        if (this.erFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        this.antallTotaltLaget++;
        Hamburger nyHamburger = new Hamburger(antallTotaltLaget);

        this.brett.add(nyHamburger);
        this.antallPaaBrett++;
        notifyAll();

        return nyHamburger; 
    }

    public synchronized Hamburger taAv() {
        if (erTom()) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        Hamburger tatt = this.brett.pop();
        this.antallPaaBrett--;

        return tatt;
    }

    public boolean erTom() {
        return this.brett.isEmpty();
    }

    public boolean erFull() {
        return this.antallPaaBrett == this.kapasitet;
    }

    @Override
    public String toString() {
        return brett.toString();
    }


}
