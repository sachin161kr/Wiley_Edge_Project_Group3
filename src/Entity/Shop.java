package Entity;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Shop {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Scanner sc = new Scanner(System.in);


        while(true){
            System.out.println();
            System.out.println("========WELCOME TO ONLINE SHOPPING SYSTEM 😊=======");
            System.out.println();
            System.out.println("1. ADMIN SECTION");
            System.out.println("2. CUSTOMER SECTION");
            System.out.println("3. EXIT");
            int option = sc.nextInt();
            switch (option){
                case 1:
                    LoginAdmin.main(args);
                break;
                case 2 : Login.main(args);
                break;
                case 3 :return;
                default:
                    System.out.println("PLEASE ENTER CORRECT CHOICE ");
            }
            System.out.println("============================================");
        }
    }




}
