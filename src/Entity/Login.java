package Entity;

import java.util.Scanner;

public class Login {

    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.LOGIN AS ADMIN");
        System.out.println("2.LOGIN AS CUSTOMER");
        System.out.println("3.GO BACK ");
        System.out.println("ENTER YOUR CHOICE: ");

        int choice = sc.nextInt();
        switch (choice){
            case 1: new Admin().loginAdmin();

                break;
            case 2 : new Customer().loginCustomer();
                break;

            case 3 : return;

        }
    }
}
