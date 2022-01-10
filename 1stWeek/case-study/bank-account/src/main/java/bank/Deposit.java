package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deposit {
    private final Connection connection;

    public Deposit(Connection connection) {
        this.connection = connection;
    }

    public int deposit(int amt, int id) throws SQLException {
        String sql = " update bank_account set amount=amount+ ? where account_num = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, amt);
        ps.setInt(2, id);

        int affected = ps.executeUpdate(); // actually firing the query
        System.out.println("amount has bean deposit");
        connection.commit();
        return affected;
    }
}
