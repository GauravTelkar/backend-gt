import bank.AccountCreation;
import bank.Balance;
import db.Connectivity;
import  bank.ShowAllAccount;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Connectivity connectivity= new Connectivity();

            AccountCreation ac = new AccountCreation(connectivity.getConnection());
            ShowAllAccount sc = new ShowAllAccount(connectivity.getConnection());
            Balance bc=new Balance(connectivity.getConnection());
        //ac.create(105, 12000 , "gt", Date.valueOf(LocalDate.now()),true);

        sc.show();
        bc.balance(101);

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
