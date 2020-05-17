package test;

import com.company.Car;
import com.company.exceptions.NegativeDistanceTraveledException;
import com.company.exceptions.NegativeFuelUsageException;
import org.junit.Assert;

class CarTest {

    Car car = new Car();

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws NegativeDistanceTraveledException, NegativeFuelUsageException {
        car.setCurrentFuelUsage(6.0);
        car.setSpeed(60.75);
        car.setDistanceTraveled(100.5);
        car.setWheelRotation(-2.1);
        car.setEngineTemp(80.4);
    }

    @org.junit.jupiter.api.Test
    void changeDistanceTraveled() throws NegativeDistanceTraveledException {
        car.changeDistanceTraveled(53.82);
        Assert.assertEquals(154.32,car.getDistanceTraveled(),0.01);
        car.changeDistanceTraveled(-33.2);
        Assert.assertEquals(121.12,car.getDistanceTraveled(),0.01);

    }


    @org.junit.jupiter.api.Test
    void changeWheelRotation() {
        car.changeWheelRotation(1.5);
        Assert.assertEquals(-0.6, car.getWheelRotation(),0.01);
        car.changeWheelRotation(-16.7);
        Assert.assertEquals(-17.3, car.getWheelRotation(), 0.01);
        car.changeWheelRotation(-360.0);
        Assert.assertEquals(-17.3,car.getWheelRotation(),0.01);
    }

    @org.junit.jupiter.api.Test
    void changeEngineTemp() {
        car.changeEngineTemp(10.3);
        Assert.assertEquals(90.7,car.getEngineTemp(),0.01);
        car.changeEngineTemp(-17.2);
        Assert.assertEquals(73.5,car.getEngineTemp(),0.01);
    }

    @org.junit.jupiter.api.Test
    void changeCurrentFuelUsage() throws NegativeFuelUsageException {
        car.changeCurrentFuelUsage(-1.3);
        Assert.assertEquals(4.7, car.getCurrentFuelUsage(),0.01);
        car.changeCurrentFuelUsage(5.6);
        Assert.assertEquals(10.3, car.getCurrentFuelUsage(),0.01);
    }
}