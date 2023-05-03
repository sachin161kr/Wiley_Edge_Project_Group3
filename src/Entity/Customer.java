package Entity;

import java.util.Scanner;

public class Customer extends Shop{
    private int customerId;
    private String customerName;
    private String mobile;
    static Scanner in = new Scanner(System.in);




    static void registerCustomer() {
        System.out.println("==========CUSTOMER PORTAL===========");
        register();
        return;

    }
    static void register(){
        int check = 0;
        int id;
        String name, email, pass, num;

        System.out.print("Enter Name = ");
        name = in.nextLine();

        System.out.println("CUSTOMER ID= ");
        id = in.nextInt();
        in.nextLine();

        System.out.print("Enter password= ");
        pass = in.nextLine();

        System.out.print("Enter contact number = ");
        num = in.next();
        in.nextLine();

        System.out.print("Enter email= ");
        email = in.nextLine();

        System.out.println("SUCCESSFULLY REGISTERED AS CUSTOMER !!");
        System.out.println();
        System.out.println("*************************************");
    }


    public void loginCustomer() {
    }
}
