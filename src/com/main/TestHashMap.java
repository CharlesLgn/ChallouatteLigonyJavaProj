package com.main;

import com.util.HashMap;

public class TestHashMap {
    public static void main(String[] args){
        HashMap<String, String, String> code = new HashMap<>();
        code.put("a","l33t", "@");
        //code.put("a","l33t", "@");
        code.put("a","morse", ".-");

        code.put("b","l33t", "8");
        code.put("b","morse", "-...");

        System.out.println(code.contient("@"));
        System.out.println(code.contient("-..."));
        System.out.println(code.contient("2-25"));
        System.out.println(code.getClePrimaire("l33t", "8"));
        System.out.println(code.getVal("a", "morse"));
        System.out.println(code.getVal("c","morse"));
    }
}
