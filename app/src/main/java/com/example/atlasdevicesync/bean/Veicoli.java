package com.example.atlasdevicesync.bean;

import io.realm.kotlin.types.annotations.PrimaryKey;

public class Veicoli {
    @PrimaryKey
    String _id;
    String tipologia;
    String citta;
    String id_veicolo;
    String stato_veicolo;
    String ore_utilizzo_totali;
    Posizione posizione;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getId_veicolo() {
        return id_veicolo;
    }

    public void setId_veicolo(String id_veicolo) {
        this.id_veicolo = id_veicolo;
    }

    public String getStato_veicolo() {
        return stato_veicolo;
    }

    public void setStato_veicolo(String stato_veicolo) {
        this.stato_veicolo = stato_veicolo;
    }

    public String getOre_utilizzo_totali() {
        return ore_utilizzo_totali;
    }

    public void setOre_utilizzo_totali(String ore_utilizzo_totali) {
        this.ore_utilizzo_totali = ore_utilizzo_totali;
    }

    public Posizione getPosizione() {
        return posizione;
    }

    public void setPosizione(Posizione posizione) {
        this.posizione = posizione;
    }
}
