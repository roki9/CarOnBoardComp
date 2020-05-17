package com.company;

import com.company.exceptions.NegativeDistanceTraveledException;
import com.company.exceptions.NegativeFuelUsageException;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Car {
    private double speed;
    private double wheelRotation;
    private double engineTemp;
    private double currentFuelUsage;
    private double distanceTraveled;

    private LocalTime startTime;

    public Car() {
        speed = 0.0;
        wheelRotation = 0.0;
        engineTemp = 0.0;
        currentFuelUsage = 0.0;
        distanceTraveled = 0.0;
        startTime = LocalTime.now();
    }

    public Car(double speed, double wheelRotation, double engineTemp, double currentFuelUsage, double distanceTraveled) {
        this.speed = speed;
        this.wheelRotation = wheelRotation;
        this.engineTemp = engineTemp;
        this.currentFuelUsage = currentFuelUsage;
        this.distanceTraveled = distanceTraveled;
        this.startTime = LocalTime.now();
    }

    public Car(double speed, double wheelRotation, double engineTemp, double currentFuelUsage, double distanceTraveled, LocalTime startTime) {
        this(speed,wheelRotation,engineTemp,currentFuelUsage,distanceTraveled);
        this.startTime = startTime;
    }

    //updating logs
    public void update(){
        System.out.println("------------------------------------------------");
        System.out.println("Current speed: "+speed+"km/h");
        System.out.println("Current wheel rotation: "+wheelRotation+"°");
        System.out.println("Current engine temperature: "+engineTemp+"°C");
        System.out.println("Current fuel usage: "+currentFuelUsage+" l/100km");
        System.out.println("Current distance traveled: "+distanceTraveled+"km");
        System.out.println("Time since starting the car: "+getTimeSinceStarting());
        System.out.println("------------------------------------------------");
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setWheelRotation(double wheelRotation) {
        this.wheelRotation = wheelRotation;
        while(this.wheelRotation>180.0){
            this.wheelRotation-=360.0;
        }
        while(this.wheelRotation<=-180.0){
            this.wheelRotation+=360.0;
        }
        //keeping the rotation in (-180;180> range
    }

    public void setEngineTemp(double engineTemp) {
        this.engineTemp = engineTemp;
    }

    public void setCurrentFuelUsage(double currentFuelUsage) throws NegativeFuelUsageException {
        if(currentFuelUsage<0){
            throw new NegativeFuelUsageException("Unable to change current fuel usage - it cannot be lesser than 0");
        }
        this.currentFuelUsage = currentFuelUsage;
    }

    public void setDistanceTraveled(double distanceTraveled) throws NegativeDistanceTraveledException {
        if(distanceTraveled<0){
            throw new NegativeDistanceTraveledException("Unable to set distance traveled - it cannot be lesser than 0");
        }
        this.distanceTraveled = distanceTraveled;
    }

    public double getSpeed() {
        return speed;
    }

    public double getWheelRotation() {
        return wheelRotation;
    }

    public double getEngineTemp() {
        return engineTemp;
    }

    public double getCurrentFuelUsage() {
        return currentFuelUsage;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public LocalTime getTimeSinceStarting() {
        return LocalTime.ofSecondOfDay(startTime.until(LocalTime.now(), ChronoUnit.SECONDS));
    }

    public void changeDistanceTraveled(double distance) throws NegativeDistanceTraveledException {
        if(distance < 0){
            throw new NegativeDistanceTraveledException("Unable to change distance traveled - it cannot be lesser than 0");
        }
        this.setDistanceTraveled(distanceTraveled+distance);
    }

    public void changeWheelRotation(double rotation){
        this.setWheelRotation(wheelRotation+rotation);
    }

    public void changeEngineTemp(double temp){
        this.setEngineTemp(engineTemp+temp);
    }

    public void changeCurrentFuelUsage(double usage) throws NegativeFuelUsageException {
        this.setCurrentFuelUsage(currentFuelUsage+usage);
    }
    public void changeSpeed(double speed){
        this.setSpeed(this.speed+speed);
    }
}
