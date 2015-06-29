/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author bitter_fox
 */
public class Main5 {
    //<editor-fold defaultstate="collapsed" desc="bootstrap">
    public static void main(String... args) {
        new Main5();
    }

    private Main5() {
        List<Person> persons = Arrays.asList(
                new Person("田中太郎", 25),
                new Person("鈴木一郎", 32),
                new Person("山田花子", 47));
        test1(persons);
    }
    //</editor-fold>

    private static class Person {
        private String name;

        Person(String name, int age) {
            this.name = name;
        }
        String getName() {
            return name;
        }
    }

    /**
     * 要素を別の要素に変化させて処理をしてみよう
     * (Personの名前を出力する)
     * @param persons
     */
    private void test1(List<Person> persons) {
        for (Person p : persons) {
            System.out.println(p.getName());
        }
    }
}
