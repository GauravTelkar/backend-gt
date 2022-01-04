import clasobj.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CarTest {

    @DisplayName("Car invalid object")
    @Test
    void testCarInvalidObject()
    {
        Car car =null;
        Assertions.assertNull(car);
    }

    @DisplayName("Car valid object")
    @Test
    void testCarValidObject()
    {
        Car car =new Car();
        Assertions.assertNotNull(car);
    }

    @DisplayName("Car Speed by Default Constructor")
    @Test
    void testCarSpeedDefault(){
        Car car = new Car();
        int expectedSpeed=10;
        int actualSpeed= car.speed;
        Assertions.assertEquals(expectedSpeed,actualSpeed);
    }

    @DisplayName("Car Speed by Parameterized Constructor")
    @Test
    void testCarSpeedParameterized(){
        Car car =new Car(100);
        int expectedSpeed =100;
        int actualSpeed = car.speed;
        Assertions.assertEquals(expectedSpeed,actualSpeed);
    }
}
