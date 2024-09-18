package no.hvl.dat108.oppgave1;

import javax.swing.JOptionPane;

public class Main {
    private static String melding = "Hallo verden!";

    public static void main(String[] args) {
        Thread printMelding = new Thread(() -> {
            while (!melding.equals("slutt")) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }

                System.out.println(melding);
            }
        });

        Thread nyMelding = new Thread(() -> {
            while (!melding.equals("slutt")) {
                melding = JOptionPane.showInputDialog("Melding:");
            }
        });

        System.out.println(melding);

        printMelding.start();
        nyMelding.start();
    }
}
