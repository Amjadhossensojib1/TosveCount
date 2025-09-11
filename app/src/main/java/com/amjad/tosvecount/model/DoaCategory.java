package com.amjad.tosvecount.model;

public class DoaCategory {
    private  String id;
    private String doaCatagoryName;
    private String doaCatagoryImg;


    public DoaCategory(String id, String doaCatagoryName, String doaCatagoryImg) {
        this.id = id;
        this.doaCatagoryName = doaCatagoryName;
        this.doaCatagoryImg = doaCatagoryImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoaCatagoryName() {
        return doaCatagoryName;
    }

    public void setDoaCatagoryName(String doaCatagoryName) {
        this.doaCatagoryName = doaCatagoryName;
    }

    public String getDoaCatagoryImg() {
        return doaCatagoryImg;
    }

    public void setDoaCatagoryImg(String doaCatagoryImg) {
        this.doaCatagoryImg = doaCatagoryImg;
    }
}
