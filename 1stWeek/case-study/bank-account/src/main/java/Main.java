import bank.*;
import db.Connectivity;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scan=new Scanner(System.in);

        System.out.println("1.Create Account");
        System.out.println("2.Show All Accounts");
        System.out.println("3.Display Balance");
        System.out.println("4.Transfer Money");
        System.out.println("5.Withdraw Money");
        System.out.println("6.Deposit Money");
        System.out.println("7.Activate Account");
        System.out.println("8.DeActivate Account");
        System.out.println("9.Exit");
        System.out.print("Enter your choice :");
        int choice = Integer.parseInt(scan.nextLine());
        Connectivity connectivity= new Connectivity();

        try {
            switch (choice){
                case 1 :  AccountCreation ac = new AccountCreation(connectivity.getConnection());
                    System.out.println("Enter Account number , Amount , Account Holder Name, Date , status");
                    int id = Integer.parseInt(scan.nextLine());
                    int amount = Integer.parseInt(scan.nextLine());
                    String name = scan.nextLine();
                    Date date = Date.valueOf(scan.nextLine());
                    Boolean status = Boolean.valueOf(scan.nextLine());
                    ac.create(id, amount , name,date,status);
                    break;

                case 2: ShowAllAccount sc = new ShowAllAccount(connectivity.getConnection());
                    sc.show();
                    break;

                case 3: Balance bc=new Balance(connectivity.getConnection());
                    System.out.println("Enter Account number : ");
                    int id1 = Integer.parseInt(scan.nextLine());
                    bc.balance(id1);
                    break;

                case 4: TransferMoney transferMoney = new TransferMoney(connectivity.getConnection());
                    System.out.print("Enter Account Number : ");
                    int num = Integer.parseInt(scan.nextLine());
                    System.out.println("Enter Account number who you want to Transfer");
                    int num2 = Integer.parseInt(scan.nextLine());
                    System.out.println("Enter Amount you want to Transfer");
                    int amount1= Integer.parseInt(scan.nextLine());
                    transferMoney.transfer(amount1,num,num2);
break;

                case 5: Withdraw withdraw = new Withdraw(connectivity.getConnection());
                    System.out.println("Enter your Account Number");
                    int acc= Integer.parseInt(scan.nextLine());
                    System.out.println("Enter Amount You Want To Withdrow");
                    int wit= Integer.parseInt(scan.nextLine());
                    withdraw.withdrow(wit,acc);
break;

                case 6: Deposit deposit = new Deposit(connectivity.getConnection());
                    System.out.println("Enter your Account Number");
                    int acc1= Integer.parseInt(scan.nextLine());
                    System.out.println("Enter Amount You Want To Deposit");
                    int dep= Integer.parseInt(scan.nextLine());
                    deposit.deposit(dep,acc1);
break;

                case 7:ActivateAccount act = new ActivateAccount(connectivity.getConnection());
                    System.out.println("Enter Account Number that you want to activate");
                    int ac1= Integer.parseInt(scan.nextLine());
                    act.active(ac1);
break;

                case 8:  DeActivateAccount de = new DeActivateAccount(connectivity.getConnection());
                    System.out.println("Enter Account Number that you want to Deactivate");
                    int ac2= Integer.parseInt(scan.nextLine());
                    de.deActive(ac2);
                    break;

                default:
                    System.out.println("You have entered wrong choice");
                    break;
            }


        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
