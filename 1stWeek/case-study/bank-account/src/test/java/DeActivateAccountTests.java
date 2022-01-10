import bank.DeActivateAccount;
import db.Connectivity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class DeActivateAccountTests {
    @DisplayName("Checking for expected and actual")
    @Test
    public void checkSame() throws SQLException, ClassNotFoundException {
        Connectivity connectivity = new Connectivity();
        DeActivateAccount act = new DeActivateAccount(connectivity.getConnection());
        var expected = 1;
        var actual = act.deActive(103);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkSame1() throws SQLException, ClassNotFoundException {
        Connectivity connectivity = new Connectivity();
        DeActivateAccount act = new DeActivateAccount(connectivity.getConnection());
        var expected = 1;
        var actual = act.deActive(102);
        Assertions.assertEquals(expected, actual);
    }
}
