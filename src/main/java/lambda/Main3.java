/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author bitter_fox
 */
public class Main3 {
    //<editor-fold defaultstate="collapsed" desc="bootstrap">
    public static void main(String... args) {
        new Main3();
    }

    private Main3() {
        test1(IntStream.rangeClosed(0, 10).boxed().collect(Collectors.toList()));
    }
    //</editor-fold>

    /**
     * for-eachをラムダ式を用いて書いてみよう
     * Iterable#forEach
     * Stream#forEach
     * @param list
     */
    private void test1(List<Integer> list) {
        for (Integer n : list) {
            System.out.println(n);
        }
    }
}
