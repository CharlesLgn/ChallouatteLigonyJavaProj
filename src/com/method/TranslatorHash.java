package com.method;

import com.metier.Code;
import com.util.HashMap;
import com.util.ListeChaine;

public class TranslatorHash {

    private static HashMap getHash(){
        HashMap<String,String,String> hash = new HashMap<>();
        hash.put("a", "morse", ".-");
        hash.put("b", "morse", ".-");
        hash.put("c", "morse", ".-");
        hash.put("d", "morse", ".-");
        hash.put("e", "morse", ".-");
        hash.put("f", "morse", ".-");
        hash.put("g", "morse", ".-");
        hash.put("h", "morse", ".-");
        hash.put("i", "morse", ".-");
        hash.put("j", "morse", ".-");
        hash.put("k", "morse", ".-");
        hash.put("l", "morse", ".-");
        hash.put("m", "morse", ".-");
        hash.put("n", "morse", ".-");
        hash.put("o", "morse", ".-");
        hash.put("p", "morse", ".-");
        hash.put("q", "morse", ".-");
        hash.put("r", "morse", ".-");
        hash.put("s", "morse", ".-");
        hash.put("t", "morse", ".-");
        hash.put("u", "morse", ".-");
        hash.put("v", "morse", ".-");
        hash.put("w", "morse", ".-");
        hash.put("x", "morse", ".-");
        hash.put("y", "morse", ".-");
        hash.put("z", "morse", ".-");

        hash.put("a", "l33t", "@");
        hash.put("b", "l33t", "8");
        hash.put("c", "l33t", "(");
        hash.put("d", "l33t", "[)");
        hash.put("e", "l33t", "3");
        hash.put("f", "l33t", "|=");
        hash.put("g", "l33t", "6");
        hash.put("h", "l33t", "#");
        hash.put("i", "l33t", "1");
        hash.put("j", "l33t", "_|");
        hash.put("k", "l33t", "X");
        hash.put("l", "l33t", "£");
        hash.put("m", "l33t", "|V|");
        hash.put("n", "l33t", "|V");
        hash.put("o", "l33t", "[]");
        hash.put("p", "l33t", "|*");
        hash.put("q", "l33t", "¶");
        hash.put("r", "l33t", "2");
        hash.put("s", "l33t", "5");
        hash.put("t", "l33t", "7");
        hash.put("u", "l33t", "(_)");
        hash.put("v", "l33t", "\\/");
        hash.put("w", "l33t", "\\/\\/");
        hash.put("x", "l33t", "><");
        hash.put("y", "l33t", "'/");
        hash.put("z", "l33t", "≥");

        return hash;
    }


    @SuppressWarnings("unchecked")
    public static String romainToL33t(String rom){
        return (String) getHash().getVal(rom, "l33t");
    }

    @SuppressWarnings("unchecked")
    public static String romainToMorse(String rom){
        return (String) getHash().getVal(rom, "morse");
    }


    @SuppressWarnings("unchecked")
    public static String L33tToRomain(String l33t) {
        return (String) getHash().getClePrimaire("l33t", l33t);
    }

    @SuppressWarnings("unchecked")
    public static String morseToRomain(String morse) {
        return (String) getHash().getClePrimaire("morse", morse);
    }

}
