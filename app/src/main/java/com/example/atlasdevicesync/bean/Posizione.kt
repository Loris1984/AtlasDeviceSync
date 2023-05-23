package com.example.atlasdevicesync.bean

import io.realm.kotlin.ext.realmDictionaryOf
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.internal.interop.RealmPointer
import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmDictionary
import io.realm.kotlin.types.RealmList

open class Posizione() : EmbeddedRealmObject {

    var type: String? = null
    var coordinates: Rea<Float> = realmDictionaryOf()
}