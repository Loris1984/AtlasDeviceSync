package com.example.atlasdevicesync.bean;

import java.util.ArrayList;

import io.realm.kotlin.types.EmbeddedRealmObject;
import io.realm.kotlin.types.RealmList;

public class Posizione implements EmbeddedRealmObject {
    String type;
    ArrayList<Float> coordinates;
}
