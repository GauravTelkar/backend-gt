package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActivateAccount {
    private final Connection connection;

    public ActivateAccount(Connection connection) {
        this.connection = connection;
    }

    public int active(int id) throws SQLException {
        String sql = " update bank_account set status= 1 where account_num = ?";
        // String sql2= "select status from bank_account where account_num= ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        //  PreparedStatement ps1 = connection.prepareStatement(sql2);
        ps.setInt(1, id);
        System.out.println("Account Active");
        int affected = ps.executeUpdate(); // actually firing the query
        connection.commit();
        return affected;

    }
}
