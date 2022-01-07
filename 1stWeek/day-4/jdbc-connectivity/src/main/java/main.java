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
//            int cnt = service.create(
//                    7,
//                    "klm",
//                    Date.valueOf(LocalDate.now()),
//                    true
//            );
//            if(cnt > 0) {
//                System.out.println("Employee Created Successfully");
//            }

//            service.find();

//            service.findEmployeeByName("abc");

            //service.txnDemo(61, "kol", Date.valueOf(LocalDate.now()), true, 100);
            service.update("gt12455",Date.valueOf(LocalDate.now()),5);
            service.delete(2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}