package com.method;

import com.util.ArbreBinaire;

public class TranslatorArbre {
    private static ArbreBinaire list = TranslatorListe.toArbre();

    public static String romainToL33t(char rom) throws Exception{
        return list.getByRomain(rom).getL33t();
    }

    public static String romainToMorse(char rom) throws Exception{
        return list.getByRomain(rom).getMorse();
    }
}
