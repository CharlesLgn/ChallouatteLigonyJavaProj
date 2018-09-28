package com.main;

import com.metier.Code;
import com.util.ListeChaine;

public class test {
    public static void main(String[] args){
        ListeChaine<Code> list = new ListeChaine<>(new Code('a',"@",".-"),
                                 new ListeChaine<>(new Code('b',"8","-..."),
                                 new ListeChaine<>(new Code('c',"(","-.-."),
                                 new ListeChaine<>(new Code('d',"[)","-.."),
                                 new ListeChaine<>(new Code('e',"3","."),
                                 new ListeChaine<>(new Code('f',"|=","..-."),
                                 new ListeChaine<>(new Code('g',"6","--."),
                                 new ListeChaine<>(new Code('h',"#","...."),
                                 new ListeChaine<>(new Code('i',"1",".."),
                                 new ListeChaine<>(new Code('j',"_|",".---"),
                                 new ListeChaine<>(new Code('k',"X","-.-"),
                                 new ListeChaine<>(new Code('l',"£",".-.."),
                                 new ListeChaine<>(new Code('m',"|V|","--"),
                                 new ListeChaine<>(new Code('n',"|V","-."),
                                 new ListeChaine<>(new Code('o',"[]","---"),
                                 new ListeChaine<>(new Code('p',"|*",".--."),
                                 new ListeChaine<>(new Code('q',"¶","--.-"),
                                 new ListeChaine<>(new Code('r',"2",".-."),
                                 new ListeChaine<>(new Code('s',"5","..."),
                                 new ListeChaine<>(new Code('t',"7","-"),
                                 new ListeChaine<>(new Code('u',"(_)","..-"),
                                 new ListeChaine<>(new Code('v',"\\/","...-"),
                                 new ListeChaine<>(new Code('w',"\\/\\/",".--"),
                                 new ListeChaine<>(new Code('x',"><","-..-"),
                                 new ListeChaine<>(new Code('y',"'/","-.--"),
                                 new ListeChaine<>(new Code('z',"≥","--.."),

                                 new ListeChaine<>(new Code('0',"≥","-----"),
                                 new ListeChaine<>(new Code('1',"≥",".----"),
                                 new ListeChaine<>(new Code('2',"≥","..---"),
                                 new ListeChaine<>(new Code('3',"≥","...--"),
                                 new ListeChaine<>(new Code('4',"≥","....-"),
                                 new ListeChaine<>(new Code('5',"≥","....."),
                                 new ListeChaine<>(new Code('6',"≥","-...."),
                                 new ListeChaine<>(new Code('7',"≥","--..."),
                                 new ListeChaine<>(new Code('8',"≥","---.."),
                                 new ListeChaine<>(new Code('9',"≥","----."),

                                 new ListeChaine<>(new Code(' '," ","   "),
                                 new ListeChaine<>(new Code('.',".",".-.-.-"),
                                 new ListeChaine<>(new Code(',',",","--..--")
                        )))))))))))))))))))))))))))))))))))))));

        boolean found = false;
        ListeChaine<Code> p = list;
        while (!found || p != null){
            if (p.getDonne().getRomain() == 'k'){
                System.out.println(p.getDonne().getL33t());
                found = true;
            }
            p = p.getSuiv();
        }
    }
}
