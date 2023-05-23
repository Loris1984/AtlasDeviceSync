package com.example.atlasdevicesync.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Ship implements Serializable {
    private String _id;
    private String recrd;
    private String vesslterms;
    private String feature_type;
    private String chart;
    @SerializedName("latdec")
    private double latdec = 0L;
    @SerializedName("londec")
    private double londec = 0L;
    private String gp_quality;
    private double depth;
    private String sounding_type;
    private String history;
    private String quasou;
    private String watlev;
    private double[] coordinates;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getRecrd() {
        return recrd;
    }

    public void setRecrd(String recrd) {
        this.recrd = recrd;
    }

    public String getVesslterms() {
        return vesslterms;
    }

    public void setVesslterms(String vesslterms) {
        this.vesslterms = vesslterms;
    }

    public String getFeature_type() {
        return feature_type;
    }

    public void setFeature_type(String feature_type) {
        this.feature_type = feature_type;
    }

    public String getChart() {
        return chart;
    }

    public void setChart(String chart) {
        this.chart = chart;
    }

    public double getLatdec() {
        return latdec;
    }

    public void setLatdec(Long latdec) {
        this.latdec = latdec;
    }

    public double getLondec() {
        return londec;
    }

    public void setLondec(Long londec) {
        this.londec = londec;
    }

    public String getGp_quality() {
        return gp_quality;
    }

    public void setGp_quality(String gp_quality) {
        this.gp_quality = gp_quality;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(Long depth) {
        this.depth = depth;
    }

    public String getSounding_type() {
        return sounding_type;
    }

    public void setSounding_type(String sounding_type) {
        this.sounding_type = sounding_type;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getQuasou() {
        return quasou;
    }

    public void setQuasou(String quasou) {
        this.quasou = quasou;
    }

    public String getWatlev() {
        return watlev;
    }

    public void setWatlev(String watlev) {
        this.watlev = watlev;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }
}
