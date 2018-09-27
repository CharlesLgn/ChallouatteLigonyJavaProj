package com.method;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class Beep {

    private static float SAMPLE_RATE = 8000f;

    private static int speed = 50;

    private static void tone(int hz, int msecs)
            throws LineUnavailableException
    {
        tone(hz, msecs, 1.0);
    }

    private static void tone(int hz, int msecs, double vol)
            throws LineUnavailableException
    {
        byte[] buf = new byte[1];
        AudioFormat af =
                new AudioFormat(
                        SAMPLE_RATE, // sampleRate
                        8,           // sampleSizeInBits
                        1,           // channels
                        true,        // signed
                        false);      // bigEndian
        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
        sdl.open(af);
        sdl.start();
        for (int i=0; i < msecs*8; i++) {
            double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
            buf[0] = (byte)(Math.sin(angle) * 127.0 * vol);
            sdl.write(buf,0,1);
        }
        sdl.drain();
        sdl.stop();
        sdl.close();
    }


    public static  void beepLong() throws Exception{
        tone(1000, speed*3);
        pauseEntreBeep();
    }

    public static  void beepCourt()throws Exception{
        tone(1000, speed);
        pauseEntreBeep();
    }

    private static  void pauseEntreBeep()throws Exception{
        tone(0, speed);
    }

    public static  void pauseEntreLettre()throws Exception{
        tone(0, speed*2);
    }

    public static  void pauseEntreMot()throws Exception{
        tone(0, speed*6);
    }
}
