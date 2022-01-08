package bank;

import java.sql.*;

public class ShowAllAccount {
    private final Connection connection;

    public ShowAllAccount(Connection connection){
        this.connection = connection;
    }


    public void show() throws SQLException {
        String sql = "select * from bank_account";
        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery(); // logical representation of physical table
        while (rs.next()) {
            int id = rs.getInt("account_num");
            int amount = rs.getInt("amount");
            String name = rs.getString("account_hld_name");
            Date dob = rs.getDate("account_cre_date");
            boolean status = rs.getBoolean("status");

            System.out.println(" id : " + id + ", amount" + amount + ", name : " + name + ", dob : " + dob.toString() + ", status : " + status);
        }
        connection.commit();
        rs.close(); // important to close the result set
    }
}
