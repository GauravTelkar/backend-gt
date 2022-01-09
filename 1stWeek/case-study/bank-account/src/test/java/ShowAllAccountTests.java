import bank.Deposit;
import bank.ShowAllAccount;
import db.Connectivity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class ShowAllAccountTests {
    @DisplayName("Checking for expected and actual")
    @Test
    public void checkSame() throws SQLException, ClassNotFoundException {
        Connectivity connectivity= new Connectivity();
        ShowAllAccount sc = new ShowAllAccount(connectivity.getConnection());
        var expected = 1;
        var actual = sc.show();
        Assertions.assertEquals(expected,actual);
    }
}
