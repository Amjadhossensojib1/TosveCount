package com.amjad.tosvecount.model;

public class Sunnah {
    private String id;
   private String sunnahImage;
   private String sunnahName;

    public Sunnah(String id, String sunnahImage, String sunnahName) {
        this.id = id;
        this.sunnahImage = sunnahImage;
        this.sunnahName = sunnahName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSunnahImage() {
        return sunnahImage;
    }

    public void setSunnahImage(String sunnahImage) {
        this.sunnahImage = sunnahImage;
    }

    public String getSunnahName() {
        return sunnahName;
    }

    public void setSunnahName(String sunnahName) {
        this.sunnahName = sunnahName;
    }
}
