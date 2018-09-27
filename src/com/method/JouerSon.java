package com.method;

public class JouerSon {

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
            }
        }
    }
}
