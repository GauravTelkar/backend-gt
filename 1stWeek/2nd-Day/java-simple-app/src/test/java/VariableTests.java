import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class VariableTests {
    @DisplayName("Check variable values are correct")
    @Test
    void learnTheVariableValidCase(){
        int osNum=12;
        int expectedValue=12;
        Assertions.assertEquals(expectedValue,osNum);
    }
    @DisplayName("Check variable values is not correct")
    @Test
    void learnVariablesInvalidCase(){
        int osNum=12;
        int expectedValue=13;
        Assertions.assertNotEquals(expectedValue,osNum);
    }
}
