package no.hvl.dat108.oppgave2;

public class Hamburger {

    private int hamburgerNr;
    private Hamburger neste;

    public Hamburger(int hamburgerNr) {
        this.hamburgerNr = hamburgerNr;
        this.neste = null;
    }

    public int getHamburgerNr() {
        return hamburgerNr;
    }

    public Hamburger getNeste() {
        return neste;
    }

    public void setNeste(Hamburger neste) {
        this.neste = neste;
    }

    @Override
    public String toString() {
        return "◖ " + hamburgerNr + " ◗";
    }
}
