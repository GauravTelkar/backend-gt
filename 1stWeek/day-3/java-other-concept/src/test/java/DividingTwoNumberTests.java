import oop.Divid;
import oop.DividingTwoNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DividingTwoNumberTests extends DividingTwoNumber {

    @Test
    public void testNotNull() {
        DividingTwoNumber div = new DividingTwoNumber();
        Assertions.assertNotNull(div);
    }

    @Test
    void testForTwoNum() {
        Divid div = new Divid();
        double expected = 2;
        double actual = div.divided(4, 2);
        Assertions.assertEquals(expected, actual);
    }
}
