package it.itispaleocapa.scanzif;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;

class AppTest {
    Azienda azienda;
    @Test
    void aggiungiMembro () {
        azienda = new Azienda();
        azienda.aggiungiMembro("123456", "Filippo", "Scanzi", Ruolo.Dirigente, LocalDate.of(2010, 1, 1), 10);
        assertEquals(1, azienda.membri.size());
        assertEquals(azienda.membri.get("123456").codice, "123456");
        assertEquals(azienda.membri.get("123456").nome, "Filippo");
        assertEquals(azienda.membri.get("123456").cognome, "Scanzi");
        assertEquals(azienda.membri.get("123456").ruolo, Ruolo.Dirigente);
        assertEquals(azienda.membri.get("123456").annoAssunzione, LocalDate.of(2010, 1, 1));
        assertEquals(azienda.membri.get("123456").orario, 10);
    }

    @Test
    void aggiungiMembro2(){
        azienda = new Azienda();
        azienda.aggiungiMembro(new Membro("123456", "Filippo", "Scanzi", Ruolo.Dirigente, LocalDate.of(2010, 1, 1), 10));
        assertEquals(1, azienda.membri.size());
        assertEquals(azienda.membri.get("123456").codice, "123456");
        assertEquals(azienda.membri.get("123456").nome, "Filippo");
        assertEquals(azienda.membri.get("123456").cognome, "Scanzi");
        assertEquals(azienda.membri.get("123456").ruolo, Ruolo.Dirigente);
        assertEquals(azienda.membri.get("123456").annoAssunzione, LocalDate.of(2010, 1, 1));
        assertEquals(azienda.membri.get("123456").orario, 10);
    }

    @Test
    void modificaOrario(){
        azienda = new Azienda();
        azienda.aggiungiMembro("123456", "Filippo", "Scanzi", Ruolo.Dirigente, LocalDate.of(2010, 1, 1), 10);
        azienda.modificaOrario("123456", 20);
        assertEquals(20, azienda.membri.get("123456").orario);
    }

    @Test
    void rimuoviMembro(){
        azienda = new Azienda();
        azienda.aggiungiMembro("123456", "Filippo", "Scanzi", Ruolo.Dirigente, LocalDate.of(2010, 1, 1), 10);
        assertEquals(1, azienda.membri.size());
        azienda.rimuoviMembro("123456");
        assertEquals(0, azienda.membri.size());
    }

    @Test
    void calcolaCostoTotale(){
        azienda = new Azienda();
        azienda.aggiungiMembro("123456", "Filippo", "Scanzi", Ruolo.Dirigente, LocalDate.of(2010, 1, 1), 10);
        azienda.aggiungiMembro("12", "Giorgio", "Bonacina", Posizione.esterno, Specializzazione.telecomunicazione, LocalDate.now(), 10); 
        azienda.aggiungiMembro("abc", "Paolo", "Todeschini", Posizione.interno, Specializzazione.informatica, LocalDate.of(2013, 1, 1), 10);
        azienda.aggiungiMembro("fgh", "Stefano", "Volpi", Ruolo.Funzionario, LocalDate.of(2010, 1, 1), 10);
        assertEquals(azienda.calcolaCostoTotale(), 2610);
    }
}
