package com.amjad.tosvecount.model;

public class Audioquran {
    private String image;
    private String name;
    private String dsc;
    private String time;
    private String audioName;

    public Audioquran() {
    }

    public Audioquran(String image, String name, String dsc, String time, String audioName) {
        this.image = image;
        this.name = name;
        this.dsc = dsc;
        this.time = time;
        this.audioName = audioName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }
}
