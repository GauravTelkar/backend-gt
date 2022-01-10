import bank.AccountCreation;
import db.Connectivity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class AccountCreationTests {
    @DisplayName("Checking for expected and actual")
    @Test
    public void checkSame() throws SQLException, ClassNotFoundException {
        Connectivity connectivity = new Connectivity();
        AccountCreation ac = new AccountCreation(connectivity.getConnection());
        var expected = 1;
        var actual = ac.create(108, 12000, "gt", Date.valueOf(LocalDate.now()), true);
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Test for dublicate values")
    @Test
    public void testDublicate() throws SQLException, ClassNotFoundException {
        Connectivity connectivity = new Connectivity();
        AccountCreation ac = new AccountCreation(connectivity.getConnection());
        var expected = 0;
        var actual = ac.create(108, 12000, "gt", Date.valueOf(LocalDate.now()), true);
        Assertions.assertEquals(expected, actual);

    }
}
