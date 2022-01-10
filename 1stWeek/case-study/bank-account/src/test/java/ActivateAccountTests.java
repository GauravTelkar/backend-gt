import bank.ActivateAccount;
import db.Connectivity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class ActivateAccountTests {
    @DisplayName("Checking for expected and actual")
    @Test
    public void checkSame() throws SQLException, ClassNotFoundException {
        Connectivity connectivity = new Connectivity();
        ActivateAccount act = new ActivateAccount(connectivity.getConnection());
        var expected = 1;
        var actual = act.active(108);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkSame1() throws SQLException, ClassNotFoundException {
        Connectivity connectivity = new Connectivity();
        ActivateAccount act = new ActivateAccount(connectivity.getConnection());
        var expected = 1;
        var actual = act.active(103);
        Assertions.assertEquals(expected, actual);
    }


}
