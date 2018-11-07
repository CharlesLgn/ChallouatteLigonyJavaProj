package com.controller;

import com.main.MainJavaFx;
import com.util.HashMap;

import java.io.*;

public class TestControler {
  public static void main(String[] args) throws InterruptedException {

    //code à insere dans l'initialize du splash screen
    MainJavaFx.getTraductor().put(" ", "morse", "   ");
    MainJavaFx.getTraductor().put(" ", "l33t", " ");
    Thread.sleep(4000);
    try {
      BufferedReader br = new BufferedReader(new FileReader("./src/resource/dico.txt"));
      String line;
      while ((line = br.readLine()) != null) {
        // process the line.
        String[] str = line.split(" ");
        MainJavaFx.getTraductor().put(str[0], str[1], str[2]);
        System.out.println(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
