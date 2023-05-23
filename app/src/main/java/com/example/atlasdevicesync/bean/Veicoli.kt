package com.example.atlasdevicesync.bean

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.Ignore
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class Veicoli() : RealmObject {
    @PrimaryKey
    var _id: String? = null
    var tipologia: String? = null
    var citta: String? = null
    var id_veicolo: String? = null
    var stato_veicolo: String? = null
    var ore_utilizzo_totali: String? = null
    var posizione: Posizione? = null

}