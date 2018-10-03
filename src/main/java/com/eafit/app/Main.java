package com.eafit.app;

import java.util.Random;

public class Main {

    public static void main(String args[]) {
      Random rand = new Random(System.currentTimeMillis());
      Alternador alternador = new AltImpl();

      Tren trenes[] = new Tren[4];
      Thread threads[] = new Thread[4];

      for (int i = 0; i < trenes.length; i++) {
        trenes[i] = new Tren(alternador, true);
        threads[i] = new Thread(trenes[i]);
        threads[i].start();
      }

      while (true) {
        try {
          Thread.sleep(rand.nextInt(2000)+1);
          Puente actual = Puente.values()[rand.nextInt(3)];
          alternador.establecerPuente(actual);
        }
        catch (InterruptedException ie) {
        }
      }
    }
}
