/*
package com.test;

import com.method.TranslatorHash;
import org.junit.Assert;
import org.junit.Test;

public class TestHashMap {
    @Test
    public void romainToL33t_A(){
        Assert.assertEquals("@", TranslatorHash.romainToL33t("a"));
    }

    @Test
    public void romainToL33t_B(){
        Assert.assertEquals("8", TranslatorHash.romainToL33t("b"));
    }

    @Test
    public void romainToL33t_C(){
        Assert.assertEquals("(", TranslatorHash.romainToL33t("c"));
    }

    @Test
    public void romainToL33t_D(){
        Assert.assertEquals("[)", TranslatorHash.romainToL33t("d"));
    }

    @Test
    public void romainToL33t_E(){
        Assert.assertEquals("3", TranslatorHash.romainToL33t("e"));
    }

    @Test
    public void romainToL33t_F(){
        Assert.assertEquals("|=", TranslatorHash.romainToL33t("f"));
    }

    @Test
    public void romainToL33t_G(){
        Assert.assertEquals("6", TranslatorHash.romainToL33t("g"));
    }

    @Test
    public void romainToL33t_H(){
        Assert.assertEquals("#", TranslatorHash.romainToL33t("h"));
    }

    @Test
    public void romainToL33t_I(){
        Assert.assertEquals("1", TranslatorHash.romainToL33t("i"));
    }

    @Test
    public void romainToL33t_J(){
        Assert.assertEquals("_|", TranslatorHash.romainToL33t("j"));
    }

    @Test
    public void romainToL33t_K(){
        Assert.assertEquals("X", TranslatorHash.romainToL33t("k"));
    }

    @Test
    public void romainToL33t_L(){
        Assert.assertEquals("£", TranslatorHash.romainToL33t("l"));
    }

    @Test
    public void romainToL33t_M(){
        Assert.assertEquals("|V|", TranslatorHash.romainToL33t("m"));
    }

    @Test
    public void romainToL33t_N(){
        Assert.assertEquals("|V", TranslatorHash.romainToL33t("n"));
    }

    @Test
    public void romainToL33t_O(){
        Assert.assertEquals("[]", TranslatorHash.romainToL33t("o"));
    }

    @Test
    public void romainToL33t_P(){
        Assert.assertEquals("|*", TranslatorHash.romainToL33t("p"));
    }

    @Test
    public void romainToL33t_Q(){
        Assert.assertEquals("¶", TranslatorHash.romainToL33t("q"));
    }

    @Test
    public void romainToL33t_R(){
        Assert.assertEquals("2", TranslatorHash.romainToL33t("r"));
    }

    @Test
    public void romainToL33t_S(){
        Assert.assertEquals("5", TranslatorHash.romainToL33t("s"));
    }

    @Test
    public void romainToL33t_T(){
        Assert.assertEquals("7", TranslatorHash.romainToL33t("t"));
    }

    @Test
    public void romainToL33t_U(){
        Assert.assertEquals("(_)", TranslatorHash.romainToL33t("u"));
    }

    @Test
    public void romainToL33t_V(){
        Assert.assertEquals("\\/", TranslatorHash.romainToL33t("v"));
    }

    @Test
    public void romainToL33t_W(){
        Assert.assertEquals("\\/\\/", TranslatorHash.romainToL33t("w"));
    }

    @Test
    public void romainToL33t_X(){
        Assert.assertEquals("><", TranslatorHash.romainToL33t("x"));
    }

    @Test
    public void romainToL33t_Y(){
        Assert.assertEquals("'/", TranslatorHash.romainToL33t("y"));
    }

    @Test
    public void romainToL33t_Z(){
        Assert.assertEquals("≥", TranslatorHash.romainToL33t("z"));
    }


    */
/*public static void main(String[] args){

        System.out.println(TranslatorHash.romainToL33t("a"));
        System.out.println(TranslatorHash.romainToL33t("b"));
        System.out.println(TranslatorHash.romainToL33t("c"));
        System.out.println(TranslatorHash.romainToL33t("d"));
        System.out.println(TranslatorHash.romainToL33t("e"));
        System.out.println(TranslatorHash.romainToL33t("f"));
        System.out.println(TranslatorHash.romainToL33t("g"));
        System.out.println(TranslatorHash.romainToL33t("h"));
        System.out.println(TranslatorHash.romainToL33t("i"));
        System.out.println(TranslatorHash.romainToL33t("j"));
        System.out.println(TranslatorHash.romainToL33t("k"));
        System.out.println(TranslatorHash.romainToL33t("l"));
        System.out.println(TranslatorHash.romainToL33t("m"));
        System.out.println(TranslatorHash.romainToL33t("n"));
        System.out.println(TranslatorHash.romainToL33t("o"));
        System.out.println(TranslatorHash.romainToL33t("p"));
        System.out.println(TranslatorHash.romainToL33t("q"));
        System.out.println(TranslatorHash.romainToL33t("r"));
        System.out.println(TranslatorHash.romainToL33t("s"));
        System.out.println(TranslatorHash.romainToL33t("t"));
        System.out.println(TranslatorHash.romainToL33t("u"));
        System.out.println(TranslatorHash.romainToL33t("v"));
        System.out.println(TranslatorHash.romainToL33t("w"));
        System.out.println(TranslatorHash.romainToL33t("x"));
        System.out.println(TranslatorHash.romainToL33t("y"));
        System.out.println(TranslatorHash.romainToL33t("z"));

        System.out.println("\n");

        System.out.println(TranslatorHash.romainToMorse("a"));
        System.out.println(TranslatorHash.romainToMorse("b"));
        System.out.println(TranslatorHash.romainToMorse("c"));
        System.out.println(TranslatorHash.romainToMorse("d"));
        System.out.println(TranslatorHash.romainToMorse("e"));
        System.out.println(TranslatorHash.romainToMorse("f"));
        System.out.println(TranslatorHash.romainToMorse("g"));
        System.out.println(TranslatorHash.romainToMorse("h"));
        System.out.println(TranslatorHash.romainToMorse("i"));
        System.out.println(TranslatorHash.romainToMorse("j"));
        System.out.println(TranslatorHash.romainToMorse("k"));
        System.out.println(TranslatorHash.romainToMorse("l"));
        System.out.println(TranslatorHash.romainToMorse("m"));
        System.out.println(TranslatorHash.romainToMorse("n"));
        System.out.println(TranslatorHash.romainToMorse("o"));
        System.out.println(TranslatorHash.romainToMorse("p"));
        System.out.println(TranslatorHash.romainToMorse("q"));
        System.out.println(TranslatorHash.romainToMorse("r"));
        System.out.println(TranslatorHash.romainToMorse("s"));
        System.out.println(TranslatorHash.romainToMorse("t"));
        System.out.println(TranslatorHash.romainToMorse("u"));
        System.out.println(TranslatorHash.romainToMorse("v"));
        System.out.println(TranslatorHash.romainToMorse("w"));
        System.out.println(TranslatorHash.romainToMorse("x"));
        System.out.println(TranslatorHash.romainToMorse("y"));
        System.out.println(TranslatorHash.romainToMorse("z"));

        System.out.println("\n");

        System.out.println(TranslatorHash.l33tToRomain("@"));
    }*//*

}
*/
