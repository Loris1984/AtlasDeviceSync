package com.example.atlasdevicesync.bean;

public class Punteggio implements Comparable<Punteggio> {

    String _id;
    Double tot_punti;
    boolean utente;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Double getTot_punti() {
        return tot_punti;
    }

    public void setTot_punti(Double tot_punti) {
        this.tot_punti = tot_punti;
    }

    public boolean isUtente() {
        return utente;
    }

    public void setUtente(boolean utente) {
        this.utente = utente;
    }


    @Override
    public int compareTo(Punteggio o) {
        return (int) (this.tot_punti - o.getTot_punti());
    }
}
