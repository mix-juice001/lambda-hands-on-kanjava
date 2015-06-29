/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 *
 * @author bitter_fox
 */
public class Main9 {
    //<editor-fold defaultstate="collapsed" desc="bootstrap">
    public static void main(String... args) {
        new Main9();
    }

    private Main9() {
        List<Person> persons = Arrays.asList(
                new Person("田中太郎"),
                new Person("山田花子"),
                new Person("佐藤一郎"),
                new Person("小林博樹"),
                new Person("吉田慶貴"));

        System.out.println(joiningName1(persons));
        System.out.println(joiningName2(persons));
    }
    //</editor-fold>

    private static class Person {
        private String name;

        private Person(String name) {
            this.name = name;
        }

        private String getName() {
            return name;
        }
    }

    private String joiningName1(List<Person> persons) {
        StringBuilder sb = new StringBuilder();
        for (Iterator<Person> it = persons.iterator(); it.hasNext();) {
            Person p = it.next();
            sb.append(p.getName());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private String joiningName2(List<Person> persons) {
        StringBuilder sb = new StringBuilder("[");
        for (Iterator<Person> it = persons.iterator(); it.hasNext();) {
            Person p = it.next();
            sb.append(p.getName());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
