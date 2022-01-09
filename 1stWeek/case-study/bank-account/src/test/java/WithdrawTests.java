import bank.TransferMoney;
import bank.Withdraw;
import db.Connectivity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class WithdrawTests {
    @DisplayName("Checking for expected and actual")
    @Test
    public void checkSame() throws SQLException, ClassNotFoundException {
        Connectivity connectivity= new Connectivity();
        Withdraw withdraw = new Withdraw(connectivity.getConnection());
        var expected = 1;
        var actual = withdraw.withdrow(1000,102);
        Assertions.assertEquals(expected,actual);
    }
}
