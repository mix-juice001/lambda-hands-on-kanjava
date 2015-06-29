/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author bitter_fox
 */
public class Main6 {
    //<editor-fold defaultstate="collapsed" desc="bootstrap">
    public static void main(String... args) {
        new Main6();
    }

    private Main6() {
        sum(1, 10);
        sum(1, 30);
        sum(1, 100);

        Random random = new Random(0xcafebabe);
        ave(random, 10);
        ave(random, 30);
        ave(random, 100);
    }
    //</editor-fold>

    /**
     * 総和を求めます
     * reduceなどを使って書いてみよう
     * @param start
     * @param end
     */
    private void sum(int start, int end) {
        System.out.println(start + " + ... + " + (end-1));
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += i;
        }
        System.out.println(sum);

        // reduce

        // sum

        // summaryStatistics
    }

    /**
     * 平均値を求めます
     * averageなどを使って書いてみよう
     * @param random
     * @param size
     */
    private void ave(Random random, int size) {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += random.nextDouble();
        }
        System.out.println(sum / size);

        // average

        // summaryStatistics
    }
}
