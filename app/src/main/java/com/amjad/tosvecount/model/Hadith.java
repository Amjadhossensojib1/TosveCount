package com.amjad.tosvecount.model;

public class Hadith {
    private String hadithArobi;
    private String hadithBangla;
    private String hadithEnglish;
    private String  hadithName;

    public Hadith(String hadithArobi, String hadithBangla, String hadithEnglish, String hadithName) {
        this.hadithArobi = hadithArobi;
        this.hadithBangla = hadithBangla;
        this.hadithEnglish = hadithEnglish;
        this.hadithName = hadithName;
    }

    public String getHadithArobi() {
        return hadithArobi;
    }

    public void setHadithArobi(String hadithArobi) {
        this.hadithArobi = hadithArobi;
    }

    public String getHadithBangla() {
        return hadithBangla;
    }

    public void setHadithBangla(String hadithBangla) {
        this.hadithBangla = hadithBangla;
    }

    public String getHadithEnglish() {
        return hadithEnglish;
    }

    public void setHadithEnglish(String hadithEnglish) {
        this.hadithEnglish = hadithEnglish;
    }

    public String getHadithName() {
        return hadithName;
    }

    public void setHadithName(String hadithName) {
        this.hadithName = hadithName;
    }
}
