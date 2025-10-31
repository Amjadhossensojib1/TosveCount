package com.amjad.tosvecount.model;

public class Surah {
    private String surahNumber;
    private String surahName;
    private String surahDsc;
    private String surahNameArobi;
    private String surahAyahs;

    public Surah(String surahNumber, String surahName, String surahDsc, String surahNameArobi, String surahAyahs) {
        this.surahNumber = surahNumber;
        this.surahName = surahName;
        this.surahDsc = surahDsc;
        this.surahNameArobi = surahNameArobi;
        this.surahAyahs = surahAyahs;
    }

    public String getSurahNumber() {
        return surahNumber;
    }

    public void setSurahNumber(String surahNumber) {
        this.surahNumber = surahNumber;
    }

    public String getSurahName() {
        return surahName;
    }

    public void setSurahName(String surahName) {
        this.surahName = surahName;
    }

    public String getSurahDsc() {
        return surahDsc;
    }

    public void setSurahDsc(String surahDsc) {
        this.surahDsc = surahDsc;
    }

    public String getSurahNameArobi() {
        return surahNameArobi;
    }

    public void setSurahNameArobi(String surahNameArobi) {
        this.surahNameArobi = surahNameArobi;
    }

    public String getSurahAyahs() {
        return surahAyahs;
    }

    public void setSurahAyahs(String surahAyahs) {
        this.surahAyahs = surahAyahs;
    }
}
