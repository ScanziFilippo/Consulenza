package it.itispaleocapa.scanzif;

import java.time.LocalDate;
import java.util.HashMap;

public class Azienda {
    HashMap<String, Membro> membri = new HashMap<>();
    public void aggiungiMembro(Membro membro){
        membri.put(membro.codice, membro);
    }
    public void aggiungiMembro(String codice, String nome, String cognome, Ruolo ruolo, LocalDate annoAssunzione, int orario){
        membri.put(codice, new Membro(codice, nome, cognome, ruolo, annoAssunzione, orario));
    }
    public void aggiungiMembro(String codice, String nome, String cognome, Posizione posizione, Specializzazione specializzazione, LocalDate annoAssunzione, int orario){
        membri.put(codice, new Membro(codice, nome, cognome, posizione, specializzazione, annoAssunzione, orario));
    }
    public void modificaOrario(String codice, int orario){
        membri.get(codice).orario = orario;
    }
    public void rimuoviMembro(String codice){
        membri.remove(codice);
    }
    public int calcolaCostoTotale(){
        return membri.values().stream().reduce(0, (acc, membro) -> acc + membro.calcolaCosto(), Integer::sum);
    }
    public void stampaCostoTotale(){
        membri.values().forEach(membro -> membro.stampaCosto());
    }
}
