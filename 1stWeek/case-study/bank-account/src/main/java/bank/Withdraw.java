package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Withdraw {
    private final Connection connection;

    public Withdraw(Connection connection) {
        this.connection = connection;
    }

    public int withdrow(int amt, int id) throws SQLException {
        String sql = " update bank_account set amount=amount- ? where account_num = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, amt);
        ps.setInt(2, id);

        int affected = ps.executeUpdate(); // actually firing the query
        System.out.println("amount has bean withdrawn ");
        connection.commit();
        return affected;
    }
}
