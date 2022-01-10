package bank;

import db.Connectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransferMoney {
    private final Connection connection;

    public TransferMoney(Connection connection) {
        this.connection = connection;
    }

    public int transfer(int amt, int id, int id2) throws SQLException, ClassNotFoundException {
        String sql = " update bank_account set amount=amount- ? where account_num = ?";
        String sql1 = " update bank_account set amount=amount+ ? where account_num = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        PreparedStatement ps1 = connection.prepareStatement(sql1);
        ps.setInt(1, amt);
        ps.setInt(2, id);

        Connectivity connectivity = new Connectivity();


        ps1.setInt(1, amt);
        ps1.setInt(2, id2);

        int affected = ps.executeUpdate(); // actually firing the query
        int affected1 = ps1.executeUpdate();
        System.out.println("Amount has bean Transfered ");
        connection.commit();
        return affected;
    }
}
