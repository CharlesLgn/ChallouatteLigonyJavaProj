package com.method.autre;

public class JouerSon {

    /**
     * Joue le son en fonction du caractère rencontré
     * @param morse
     * @throws Exception
     */
    public static void jouerson (String morse) throws Exception{
        for (char item : morse.toCharArray()) {
            switch (item){
                case '-':
                    Beep.beepLong();
                    break;
                case '.':
                    Beep.beepCourt();
                    break;
                case ' ':
                    Beep.pauseEntreLettre();
                    break;
            }
        }
    }
}
