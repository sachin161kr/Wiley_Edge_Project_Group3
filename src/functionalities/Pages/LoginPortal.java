package functionalities.Pages;

import java.util.Scanner;

public class LoginPortal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("****************************************");
        System.out.println();
        System.out.println("LOGIN PORTAL");
        System.out.println();

        while(true){
            System.out.println("1. LOGIN AS ADMIN");
            System.out.println("2. LOGIN AS CUSTOMER");
            System.out.println("3. GO BACK");
            System.out.println();
            System.out.println("ENTER YOUR CHOICE: ");
            int option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    AdminLogin.main(args);
                }
                case 2 -> {
                    System.out.println("Register As Admin");
                }
                case 3 -> {
                    System.out.println("THANK YOU");
                    return;
                }
                default -> System.out.println("PLEASE ENTER CORRECT CHOICE ");
            }
        }
    }
}
