import clasobj.Bmw;
import clasobj.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BmwTests {
    @DisplayName("Testing Object nullability")
    @Test
    void testInValidObject(){
        Bmw bmw=null;
        Assertions.assertNull(bmw);
    }
    @DisplayName("Testing Object Validity")
    @Test
    void testValidObject(){
        Bmw bmw = new Bmw();
        Assertions.assertNotNull(bmw);
        int expectedSpeed=10;
        int actualSpeed= bmw.speed;
        Assertions.assertEquals(expectedSpeed,actualSpeed);
    }
    @DisplayName("test is bmw is a car")
    @Test
    void testBmwObjectCar(){
       Bmw bmw=new Bmw();
       boolean expected =true;
       boolean actual = bmw instanceof Car;
       Assertions.assertEquals(expected, actual);
    }
    @DisplayName("Test car is not a bmw")
    @Test
    void testCarObjectNotBmw(){
        Car car = new Car();
        boolean expected = false;
        boolean actual = car instanceof Bmw;
        Assertions.assertEquals(expected, actual);
    }
}
