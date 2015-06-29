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
public class Main4 {
    //<editor-fold defaultstate="collapsed" desc="bootstrap">
    public static void main(String... args) {
        new Main4();
    }

    private Main4() {
        test1(IntStream.rangeClosed(0, 10).boxed().collect(Collectors.toList()));
    }
    //</editor-fold>

    /**
     * 条件で要素への操作を除外する
     * @param list
     */
    private void test1(List<Integer> list) {
        for (Integer n : list) {
            if (n % 2 == 0) {
                System.out.println(n);
            }
        }
    }
}
