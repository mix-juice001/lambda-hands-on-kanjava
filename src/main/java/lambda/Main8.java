/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author bitter_fox
 */
public class Main8 {
    //<editor-fold defaultstate="collapsed" desc="bootstrap">
    public static void main(String... args) {
        new Main8();
    }

    private Main8() {

        List<Car> toyotaCar = Arrays.asList(
                new Car("ピクシス エポック", 658),
                new Car("ピクシス スペース", 658),
                new Car("アクア", 1496),
                new Car("アルファード", 1000), // 適当
                new Car("ヴォクシー", 1000), // 適当
                new Car("プリウス", 1000) // 適当
        );

        List<Car> hondaCar = Arrays.asList(
                new Car("S660", 660),
                new Car("N-BOX", 660),
                new Car("N-WGN", 660),
                new Car("FIT", 1000),
                new Car("CR-V", 1000)
        );
        List<Car> nissanCar = Arrays.asList(
                new Car("デイズ", 658),
                new Car("モコ", 658),
                new Car("キューブ", 1498),
                new Car("マーチ", 1000)
        );

        List<Campany> campanies = Arrays.asList(
                new Campany(toyotaCar),
                new Campany(hondaCar),
                new Campany(nissanCar)
        );

        System.out.println(lightCarNames(campanies).stream()
                .collect(Collectors.joining(", ")));
    }
    //</editor-fold>

    /**
     * すべての会社の自動車のうち，軽自動車(排気量が660cc以下)の名前のリストを取得
     * @param campanies
     * @return
     */
    private List<String> lightCarNames(List<Campany> campanies) {
        List<String> names = new ArrayList<>();
        for (Campany campany : campanies) {
            for (Car car : campany.getCars()) {
                if (car.getDisplacement() <= 660) {
                    names.add(car.getName());
                }
            }
        }
        return names;
    }

    private class Car {
        private String name;
        private double displacement;

        private Car(String name, double displacement) {
            this.name = name;
            this.displacement = displacement;
        }

        private String getName() {
            return name;
        }
        private double getDisplacement() {
            return displacement;
        }
    }

    private class Campany {
        private List<Car> cars;

        private Campany(List<Car> cars) {
            this.cars = cars;
        }

        private List<Car> getCars() {
            return cars;
        }
    }
}
