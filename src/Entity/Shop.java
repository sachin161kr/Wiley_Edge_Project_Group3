package Entity;

import java.util.Scanner;

import static sun.security.jgss.GSSUtil.login;

public class Shop {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO ONLINE SHOPPING SYSTEM 😊");
        System.out.println();

        while(true){
            System.out.println("1. REGISTER AS ADMIN");
            System.out.println("2. REGISTER AS CUSTOMER");
            System.out.println("3. LOGIN TO SYSTEM");
            System.out.println("4. EXIT");
            System.out.println("ENTER YOUR CHOICE: ");
            int option = sc.nextInt();

            switch (option){
                case 1: new Admin().registerAdmin();

                break;
                case 2 : new Customer().registerCustomer();
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
