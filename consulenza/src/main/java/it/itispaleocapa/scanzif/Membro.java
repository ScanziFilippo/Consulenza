package it.itispaleocapa.scanzif;

import java.time.LocalDate;

public class Membro {
    String codice;
    String nome;
    String cognome;
    Ruolo ruolo;
    LocalDate annoAssunzione;
    int orario;
    public Membro(String codice, String nome, String cognome, Ruolo ruolo, LocalDate annoAssunzione, int orario){
        this.codice = codice;
        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
        this.annoAssunzione = annoAssunzione;
        this.orario = orario;
    }
    public Membro(String codice, String nome, String cognome, Posizione posizione, Specializzazione specializzazione, LocalDate annoAssunzione, int orario){
        this.codice = codice;
        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = Ruolo.Tecnico;
        this.ruolo.posizione = posizione;
        this.ruolo.specializzazione = specializzazione;
        this.annoAssunzione = annoAssunzione;
        this.orario = orario;
    }
    public int calcolaCosto(){
        int costo = 0;
        switch(ruolo){
            case Dirigente:
                costo = 100 * orario;
                break;
            case Funzionario:
                costo = LocalDate.now().getYear() - annoAssunzione.getYear() < 10? 70 : 80;
                costo *= orario;
                break;
            case Tecnico:
                if(ruolo.specializzazione == Specializzazione.informatica || ruolo.specializzazione == Specializzazione.telecomunicazione){
                    costo = 40 * orario;
                }else if(ruolo.specializzazione == Specializzazione.elettronica || ruolo.specializzazione == Specializzazione.automazione){
                    costo = 50 * orario;
                }else{
                    try {
                        throw new EccezzioneSpecializzazione();
                    } catch (EccezzioneSpecializzazione e) {
                        e.printStackTrace();
                    }
                }
                costo += ruolo.posizione == Posizione.interno? LocalDate.now().getYear() - annoAssunzione.getYear() : 0;
                break;
        }
        return costo;
    }
    public void stampaCosto(){
        System.out.println(nome + "\t" + cognome + ":         €" + calcolaCosto());
    }
}

class EccezzioneSpecializzazione extends Exception{
    public EccezzioneSpecializzazione(){
        super("Specializzazione non valida");
    }
}   