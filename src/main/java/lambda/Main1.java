/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author bitter_fox
 */
public class Main1 {
    //<editor-fold defaultstate="collapsed" desc="bootstrap">
    public static void main(String... args) {
        new Main1();
    }
    private Main1() {
        test1();
        test2();
    }
    //</editor-fold>

    /**
     * 簡単なラムダ式の書き方
     */
    private void test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("HelloWorld!");
            }
        };

        r.run();
    }

    /**
     * j.u.functionパッケージを用いた0引数〜2引数のラムダ式の書き方
     */
    private void test2() {
        Consumer<Integer> con = new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println(t);
            }
        };
        con.accept(10);

        Predicate<Integer> isEven = new Predicate<Integer>() {
            @Override
            public boolean test(Integer t) {
                return t % 2 == 0;
            }
        };
        System.out.println(isEven.test(10));
        System.out.println(isEven.test(11));

        BiConsumer<Integer, Integer> biCon = new BiConsumer<Integer, Integer>() {

            @Override
            public void accept(Integer n, Integer m) {
                System.out.println(n + " + " + m + "=" + (n + m));
            }
        };
        biCon.accept(10, 20);
    }
}
