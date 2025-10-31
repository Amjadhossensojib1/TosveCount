package com.amjad.tosvecount.model;

public class StepModel {
    private int imageRes;
    private String title;
    private String description;
    private String arabic;

    public StepModel(int imageRes, String title, String description, String arabic) {
        this.imageRes = imageRes;
        this.title = title;
        this.description = description;
        this.arabic = arabic;
    }

    public int getImageRes() {
        return imageRes;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getArabic() {
        return arabic;
    }
}
