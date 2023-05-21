package it.itispaleocapa.scanzif;

import java.time.LocalDate;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        Azienda azienda = new Azienda();
        azienda.aggiungiMembro("123456", "Filippo", "Scanzi", Ruolo.Dirigente, LocalDate.of(2010, 1, 1), 10);   
        azienda.aggiungiMembro("12", "Giorgio", "Bonacina", Posizione.esterno, Specializzazione.telecomunicazione, LocalDate.now(), 12); 
        azienda.aggiungiMembro("abc", "Paolo", "Todeschini", Posizione.interno, Specializzazione.informatica, LocalDate.of(2013, 1, 1), 8);
        azienda.aggiungiMembro("fgh", "Stefano", "Volpi", Ruolo.Funzionario, LocalDate.of(2010, 1, 1), 10);
        azienda.stampaCostoTotale();
        System.out.println("Totale:\t\t\t€" + azienda.calcolaCostoTotale());
    }
}
