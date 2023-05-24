package com.example.atlasdevicesync.bean;

import java.util.ArrayList;

import io.realm.kotlin.types.EmbeddedRealmObject;

public class Posizione implements EmbeddedRealmObject {
    String type;
    ArrayList<Float> coordinates;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Float> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<Float> coordinates) {
        this.coordinates = coordinates;
    }

}
