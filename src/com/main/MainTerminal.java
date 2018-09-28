package com.main;

import com.util.ListeDeTableau;

public class MainTerminal {
    public static void main(String[] args){
            ListeDeTableau<Integer> array = new ListeDeTableau<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(7);
        array.add(8);
        array.add(9);
        array.add(10);
        array.add(11);

        System.out.println(array);

        System.out.println(array.estVide());
        System.out.println(array.taille());
        System.out.println(array.taille());
        System.out.println(array.contient(2));
        System.out.println(array.lastIndexDe(1));
        System.out.println(array.indexDe(5));

        array.retirer(2);
        array.vider();

        ListeDeTableau<String> i = new ListeDeTableau<>(4);
        i.add("1");
        i.add("12");
        i.add("jkj");

        System.out.println(i);
        System.out.println(i.get(5));
        i.set(0, "def");

    }
}
