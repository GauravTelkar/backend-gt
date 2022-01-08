package bank;

import java.sql.*;

public class AccountCreation {
    private final Connection connection;

    public AccountCreation(Connection connection){
        this.connection = connection;
    }

    public int create(int account_num, int amount, String account_hld_name, Date dob, Boolean status) throws SQLException {
        String sql = "insert into bank_account values(?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, account_num);
        ps.setInt(2, amount);
        ps.setString(3, account_hld_name);
        ps.setDate(4, dob );
        ps.setBoolean(5,status);
        // above 5 lines create SQL statement

        int affected = ps.executeUpdate(); // actually firing the query
        connection.commit();
        return affected;
    }


}
