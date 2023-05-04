package Entity;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Shop {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO ONLINE SHOPPING SYSTEM 😊");
        System.out.println();

        while(true){
            System.out.println("1. LOGIN AS ADMIN");
            System.out.println("2. REGISTER AS CUSTOMER");
            System.out.println("3. LOGIN TO SYSTEM");
            System.out.println("4. EXIT");
            System.out.println("ENTER YOUR CHOICE: ");
            int option = sc.nextInt();

            switch (option){
                case 1:
                    System.out.println("Enter username: ");
                    String username = sc.next();
                    System.out.println("Enter password: ");
                    String password = sc.next();
                    new Admin().loginAdmin(username,password);

                break;
                case 2 : new CustomerImpl().registerCustomer();
                break;
                case 3 :new Login().login();
                break;
                case 4:
                    System.out.println("THANK YOU");
                break;

                default:
                    System.out.println("PLEASE ENTER CORRECT CHOICE ");
            }

        }
    }




}
