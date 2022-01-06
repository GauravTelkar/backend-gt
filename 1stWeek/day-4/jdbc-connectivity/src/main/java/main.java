import db.Connectivity;
import service.DbService;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class main {
    public static void main(String[] args) {

        try {
            Connectivity connectivity = new Connectivity();

            DbService service = new DbService(connectivity.getConnection());
            int cnt = service.create(
                    6,
                    "abc",
                    Date.valueOf(LocalDate.now()),
                    true
            );
            if (cnt > 0) {
                System.out.println("Employee Created Successfully");
            }


            service.find();  //this is to call DbService (display the data)
            System.out.println("--------------------------------------------");
            service.findEmployeeByName("abc");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
