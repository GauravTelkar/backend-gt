package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeActivateAccount {
    private final Connection connection;

    public DeActivateAccount(Connection connection){
        this.connection = connection;
    }

    public int deActive(int id) throws SQLException {
        String sql = " update bank_account set status= 0 where account_num = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
        //  ResultSet rs = ps.executeQuery();

        int affected = ps.executeUpdate(); // actually firing the query


            connection.commit();

                System.out.println("Account has Deactivated");
                return affected;

    }
}
