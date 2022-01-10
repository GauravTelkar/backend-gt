import bank.Balance;
import db.Connectivity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class BalanceTests {
    @DisplayName("Checking for expected and actual")
    @Test
    public void checkSame() throws SQLException, ClassNotFoundException {
        Connectivity connectivity = new Connectivity();
        Balance bc = new Balance(connectivity.getConnection());
        var expected = 108;
        var actual = 108;
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Checking for expected and actual")
    @Test
    public void same() throws SQLException, ClassNotFoundException {
        Connectivity connectivity = new Connectivity();
        Balance bc = new Balance(connectivity.getConnection());
        var expected = 100;
        var actual = 100;
        Assertions.assertEquals(expected, actual);
    }

}
