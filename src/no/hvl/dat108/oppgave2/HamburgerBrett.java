package no.hvl.dat108.oppgave2;

public class HamburgerBrett {
    
    private int kapasitet;
    private Hamburger forste;
    private Hamburger siste;
    private int antallPaaBrett;
    private int antallTotaltLaget;

    public HamburgerBrett(int kapasitet) {
        this.kapasitet = kapasitet;
        this.forste = null;
        this.siste = null;
        this.antallPaaBrett = 0;
        this.antallTotaltLaget = 0;
    }

    public synchronized Hamburger leggTil() {
        while (erFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        this.antallTotaltLaget++;
        Hamburger nyHamburger = new Hamburger(antallTotaltLaget);

        if (this.erTom()) {
            this.forste = nyHamburger;
        } else {
            this.siste.setNeste(nyHamburger);
        }
        this.siste = nyHamburger;
        this.antallPaaBrett++;
        notifyAll();

        return nyHamburger; 
    }

    public synchronized Hamburger taAv() {
        while (erTom()) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        Hamburger tatt = this.forste;
        this.forste = this.forste.getNeste();
        this.antallPaaBrett--;
        notifyAll();

        return tatt;
    }

    public boolean erTom() {
        return this.forste == null;
    }

    public boolean erFull() {
        return this.antallPaaBrett == this.kapasitet;
    }
}
