/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author bitter_fox
 */
public class Main10 {
    //<editor-fold defaultstate="collapsed" desc="bootstrap">
    public static void main(String... args) {
        new Main10();
    }

    private Main10() {
        // TODO: cases
        Random r = new Random(123456);
        List<People> peoples = Arrays.asList(
                new People("太郎", "田中", People.Gender.MALE),
                new People("一郎", "田中", People.Gender.MALE),
                new People("陽子", "田中", People.Gender.FEMALE),
                new People("藤子", "田中", People.Gender.FEMALE),
                new People("二郎", "山田", People.Gender.MALE),
                new People("花子", "山田", People.Gender.FEMALE),
                new People("美智子", "山田", People.Gender.FEMALE),
                new People("博樹", "小林", People.Gender.MALE),
                new People("慶貴", "小林", People.Gender.MALE),
                new People("優子", "吉田", People.Gender.FEMALE));

        System.out.println(groupingByGender(peoples));
        System.out.println(groupingFirstNameByLastName(peoples));
    }
    //</editor-fold>

    private static class People {
        private String firstName;
        private String lastName;
        private Gender gender;

        private enum Gender {
            MALE, FEMALE;
        }

        private People(String firstName, String lastName, Gender gender) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "People{" + "firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + '}';
        }
    }

    /**
     * peoplesの性別ごとのPeopleのリストを作ります
     * @param peoples
     * @return
     */
    private Map<People.Gender, List<People>> groupingByGender(List<People> peoples) {
        Map<People.Gender, List<People>> map = new HashMap<>();

        for (People p : peoples) {
            // Java 8 <
            map.computeIfAbsent(p.gender, g -> new ArrayList<>())
                .add(p);

            // <= Java 7
//            People.Gender g = p.gender;
//            List<People> l = map.containsKey(g) ? map.get(g) :
//                    map.put(g, new ArrayList<>());
//            l.add(p);
        }

        return map;
    }

    /**
     * 苗字(LastName)ごとのPeopleの名前(FirstName)のリストを作ります
     * @param peoples
     * @return
     */
    private Map<String, List<String>> groupingFirstNameByLastName(List<People> peoples) {
        Map<String, List<String>> map = new HashMap<>();

        for (People p : peoples) {
            map.computeIfAbsent(p.getLastName(), n -> new ArrayList<>())
                .add(p.getFirstName());
        }

        return map;
    }
}
