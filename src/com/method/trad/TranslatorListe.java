package com.method.trad;

import com.metier.Code;
import com.util.ArbreBinaire;
import com.util.ListeChaine;

public class TranslatorListe {

        private static ListeChaine<Code> list = new ListeChaine<>(new Code('a',"@",".-"),
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
                                 new ListeChaine<>(new Code(',',",","--..--"),
                                 new ListeChaine<>(new Code('?',"?","..--.."),
                                 new ListeChaine<>(new Code('\'',"'",".----."),
                                 new ListeChaine<>(new Code('!',"!","-.-.-----."),
                                 new ListeChaine<>(new Code('/',"/","-..-."),
                                 new ListeChaine<>(new Code('(',"(","-.--."),
                                 new ListeChaine<>(new Code(')',")","-.--.-"),
                                 new ListeChaine<>(new Code('&',"&",".-..."),
                                 new ListeChaine<>(new Code(':',":","---..."),
                                 new ListeChaine<>(new Code(';',";","-.-.-."),
                                 new ListeChaine<>(new Code('=',"=","-...-"),
                                 new ListeChaine<>(new Code('+',"+",".-.-."),
                                 new ListeChaine<>(new Code('_',"_","..--.-"),
                                 new ListeChaine<>(new Code('\"',"\"",".-..-."),
                                 new ListeChaine<>(new Code('$',"$","...-..-"),
                                 new ListeChaine<>(new Code('@',"@",".--.-.")
                                         ))))))))))))))))))))))))))))))))))))))))))))))))))))));

    public static String romainToL33t(char rom){
        ListeChaine<Code> p = list;
        while (p != null){
            if (p.getDonne().getRomain() == rom){
                return p.getDonne().getL33t();
            }
            p = p.getSuiv();
        }
        return null;
    }

    public static String romainToMorse(char rom){
        ListeChaine<Code> p = list;
        while (p != null){
            if (p.getDonne().getRomain() == rom){
                return p.getDonne().getMorse();
            }
            p = p.getSuiv();
        }
        return null;
    }


    public static char L33tToRomain(String l33t) throws Exception {
        ListeChaine<Code> p = list;
        while (p != null){
            if (p.getDonne().getL33t().equals(l33t)){
                return p.getDonne().getRomain();
            }
            p = p.getSuiv();
        }
        throw new Exception("valeur inexistante");
    }

    public static char morseToRomain(String morse) throws Exception {
        ListeChaine<Code> p = list;
        while (p != null){
            if (p.getDonne().getMorse().equals(morse)){
                return p.getDonne().getRomain();
            }
            p = p.getSuiv();
        }
        throw new Exception("valeur inexistante");
    }

    static ArbreBinaire toArbre(){
        Code[] tab = list.toTab();
        ArbreBinaire.tri(tab);
        return ArbreBinaire.addOrganized(tab);
    }

}
