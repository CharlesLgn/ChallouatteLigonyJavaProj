package com.method.trad;

import com.main.MainJavaFx;

public class TranslatorHash {

    public static String romainToL33t(String rom){
        return MainJavaFx.getTraductor().getVal(rom, "l33t");
    }

    public static String romainToMorse(String rom){
        return MainJavaFx.getTraductor().getVal(rom, "morse");
    }

    public static String l33tToRomain(String l33t) {
        return MainJavaFx.getTraductor().getClePrimaire("l33t", l33t);
    }

    public static String morseToRomain(String morse) {
        return MainJavaFx.getTraductor().getClePrimaire("morse", morse);
    }

}
