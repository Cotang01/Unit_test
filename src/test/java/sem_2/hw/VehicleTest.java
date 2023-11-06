package sem_2.hw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;

class VehicleTest {
    
    @Nested
    class CarTest {
        
        private Car car;
        
        @BeforeEach
        void setupCar() {
            car = new Car("Dodge", "Ram", 2010);
        }
        
        @Test
        void testCarIsInstanceOfVehicle() {
            assertTrue(car instanceof Vehicle, "Car не унаследовался от Vehicle");
        }
        
        @Test
        void testCarHasFourWheels() {
            assertEquals(4, car.getNumWheels(), "У car не 4 колеса");
        }
        
        @Test
        void testCarTestDrive() {
            car.testDrive();
            assertEquals(60, car.getSpeed(), "car развивает не ту скорость");
        }
        
        @Test
        void testCarPark() {
            car.testDrive();
            car.park();
            assertEquals(0, car.getSpeed(), "Парковка car неиспаравна");
        }
        
    }
    
    @Nested
    class MotoTest {
        
        private Motorcycle moto;
        
        @BeforeEach
        void setupMoto() {
            moto = new Motorcycle("Yamaha", "XJ6", 2011);
        }
        
        
        @Test
        void testMotoHasTwoWheels() {
            assertEquals(2, moto.getNumWheels(), "У motorcycle не 2 колеса");
        }
        
        
        @Test
        void testMotoTestDrive() {
            moto.testDrive();
            assertEquals(75, moto.getSpeed(), "moto развивает не ту скорость");
        }
        
        @Test
        void testMotoPark() {
            moto.testDrive();
            moto.park();
            assertEquals(0, moto.getSpeed(), "Парковка moto неиспаравна");
        }
        
    }
    
}