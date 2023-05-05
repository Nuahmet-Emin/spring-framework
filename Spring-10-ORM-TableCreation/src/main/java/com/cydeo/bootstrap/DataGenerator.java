package com.cydeo.bootstrap;

import com.cydeo.entity.Car;
import org.springframework.boot.CommandLineRunner;

public class DataGenerator implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        Car c1 = new Car("BMW","X5");
        Car c2 = new Car("Honda","Pilot");
        Car c3 = new Car("Toyota","Camry");

        // save these object to db



    }
}
