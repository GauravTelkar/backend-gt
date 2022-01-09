import bank.ShowAllAccount;
import bank.TransferMoney;
import db.Connectivity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class TransferMoneyTests {
    @DisplayName("Checking for expected and actual")
    @Test
    public void checkSame() throws SQLException, ClassNotFoundException {
        Connectivity connectivity= new Connectivity();
        TransferMoney transferMoney = new TransferMoney(connectivity.getConnection());
        var expected = 1;
        var actual = transferMoney.transfer(1000,102,101);
        Assertions.assertEquals(expected,actual);
    }
}
