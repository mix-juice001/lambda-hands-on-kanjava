/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 *
 * @author bitter_fox
 */
public class Main6_1 {
    //<editor-fold defaultstate="collapsed" desc="bootstrap">
    public static void main(String... args) {
        new Main6_1();
    }

    private Main6_1() {
        int millis = 5;
        int numbers = 2000;
        System.out.println("seq: "+ bench(() -> sleepTest(millis, numbers)) + " millis");
        System.out.println("par: "+ bench(() -> sleepTestParallel(millis, numbers)) + " millis");
    }

    private long bench(Runnable r) {
        long start = System.currentTimeMillis();
        r.run();
        long end = System.currentTimeMillis();

        return end - start;
    }
    //</editor-fold>

    private void sleepTest(int millis, int number) {
        IntStream.generate(() -> millis)
                .limit(number)
                .forEach(m -> sleep(m));
    }

    private void sleepTestParallel(int millis, int number) {
        IntStream.generate(() -> millis).parallel()
                .limit(number)
                .forEach(m -> sleep(m));
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main6_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
