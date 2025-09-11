package com.amjad.tosvecount.model;

import java.io.Serializable;

public class Doa implements Serializable {
    private  String catId;
    private String doaName;
    private String doaArabic;
    private String doaBangla;

    public Doa(String catId, String doaName, String doaArabic, String doaBangla) {
        this.catId = catId;
        this.doaName = doaName;
        this.doaArabic = doaArabic;
        this.doaBangla = doaBangla;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getDoaName() {
        return doaName;
    }

    public void setDoaName(String doaName) {
        this.doaName = doaName;
    }

    public String getDoaArabic() {
        return doaArabic;
    }

    public void setDoaArabic(String doaArabic) {
        this.doaArabic = doaArabic;
    }

    public String getDoaBangla() {
        return doaBangla;
    }

    public void setDoaBangla(String doaBangla) {
        this.doaBangla = doaBangla;
    }
}
