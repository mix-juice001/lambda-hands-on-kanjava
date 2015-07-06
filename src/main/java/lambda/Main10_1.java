/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 *
 * @author bitter_fox
 */
public class Main10_1 {
    //<editor-fold defaultstate="collapsed" desc="bootstrap">
    public static void main(String... args) {
        new Main10_1();
    }

    private Main10_1() {
        List<Integer> l = IntStream.range(0, 5_000_000).boxed().collect(Collectors.toList());
        System.out.println("seq: "+ bench(() -> groupingBy(l)) + " millis");
        System.out.println("par: "+ bench(() -> groupingByParallel(l)) + " millis");
    }

    private double bench(Runnable r) {
        r.run(); // 最初は計測しない
        return LongStream.iterate(1, i -> i+1).map(i -> {
            long start = System.currentTimeMillis();
            r.run();
            long end = System.currentTimeMillis();

            System.out.println(i + "(" + (end-start) + ")");

            return end - start;
        }).limit(5).average().getAsDouble();
    }
    //</editor-fold>

    private Map<Integer, List<Integer>> groupingBy(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> (double)Math.sqrt(n))
                .map(n -> (int)Math.pow(n, 2))
                .collect(Collectors.groupingBy(n -> n % 250_000));
    }

    private Map<Integer, List<Integer>> groupingByParallel(List<Integer> numbers) {
        return numbers.stream().parallel()
                .map(n -> (double)Math.sqrt(n))
                .map(n -> (int)Math.pow(n, 2))
                .collect(Collectors.groupingBy(n -> n % 250_000));
    }
}
