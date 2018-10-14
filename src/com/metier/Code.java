package com.metier;

public class Code {
    private char romain;
    private String l33t;
    private String morse;

    public Code(char romain, String l33t, String morse) {
        this.romain = romain;
        this.l33t = l33t;
        this.morse = morse;
    }

    public Code() {}

    public char getRomain() {
        return romain;
    }

    public void setRomain(char romain) {
        this.romain = romain;
    }

    public String getL33t() {
        return l33t;
    }

    public void setL33t(String l33t) {
        this.l33t = l33t;
    }

    public String getMorse() {
        return morse;
    }

    public void setMorse(String morse) {
        this.morse = morse;
    }

    @Override
    public String toString() {
        return  "romain : " + romain +
                ", l33t : " + l33t +
                ", morse :" + morse;
    }
}
