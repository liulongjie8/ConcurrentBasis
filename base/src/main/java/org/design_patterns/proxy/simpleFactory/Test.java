package org.design_patterns.proxy.simpleFactory;

public class Test {

    public static void main(String[] args) {
        Car car1 = CarFactory.createCar("Bmw");
        Car car2 = CarFactory.createCar("Aodi");
        car1.run();
        car2.run();
    }

}
