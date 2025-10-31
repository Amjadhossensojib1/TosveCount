package com.amjad.tosvecount.model;

public class SunnahDetails {
    private String title;
    private String description;

    public SunnahDetails(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
