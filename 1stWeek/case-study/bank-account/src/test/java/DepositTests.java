import bank.ActivateAccount;
import bank.DeActivateAccount;
import bank.Deposit;
import db.Connectivity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class DepositTests {
    @DisplayName("Checking for expected and actual")
    @Test
    public void checkSame() throws SQLException, ClassNotFoundException {
        Connectivity connectivity= new Connectivity();

        Deposit de = new Deposit(connectivity.getConnection());
        var expected = 1;
        var actual = de.deposit(100,102);
        Assertions.assertEquals(expected,actual);

    }
}
