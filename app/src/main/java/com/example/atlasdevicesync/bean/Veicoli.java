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
}
