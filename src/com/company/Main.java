package com.company;

import com.company.exceptions.NegativeDistanceTraveledException;
import com.company.exceptions.NegativeFuelUsageException;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        Car car = new Car(60.0, 0.0, 75.0, 6.0, 1500.0);
        int randomNum;

        while(true){
            randomNum = ThreadLocalRandom.current().nextInt(1,11);//randomizing showing logs
            try {
                Thread.sleep(randomNum*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                car.changeDistanceTraveled(car.getSpeed()/3600*randomNum);//changing distance traveled according to last speed
            } catch (NegativeDistanceTraveledException e) {
                System.out.println(e.getMessage());//if the speed is negative (car moving backwards) distance traveled isn't changing
            }
            randomNum = ThreadLocalRandom.current().nextInt(-100,100);//randomizing changes to car's attributes
            car.changeSpeed(randomNum*0.1);
            randomNum = ThreadLocalRandom.current().nextInt(-30,30);
            car.changeEngineTemp(randomNum*0.1);
            randomNum = ThreadLocalRandom.current().nextInt(-90,90);
            car.changeWheelRotation(randomNum);
            randomNum = ThreadLocalRandom.current().nextInt(-100,100);
            try {
                car.changeCurrentFuelUsage(randomNum*0.01);
            } catch (NegativeFuelUsageException e) {
                System.out.println(e.getMessage());
            }
            car.update();
        }

    }
}
