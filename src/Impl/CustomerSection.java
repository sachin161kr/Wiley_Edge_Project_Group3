package Impl;

import Entity.Admin;
import Entity.Customer;
import Entity.EditProfile;

import java.util.Scanner;
import java.util.logging.SocketHandler;

public class CustomerSection {

    public void loginMenu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.VIEW PRODUCT LIST");
        System.out.println("2.SEARCH A PRODUCT NAMEWISE ");
        System.out.println("3.SEARCH PRODUCT TYPEWISE");
        System.out.println("4. ADD PRODUCT TO CART");
        System.out.println("5.REMOVE PRODUCT FROM CART");
        System.out.println("6.VIEW CART");
        System.out.println("7.PROCEED TO PAYMENT");
        System.out.println("8.EDIT PROFILE");
        System.out.println("9.LOGOUT FROM SYSTEM");
        System.out.println();
        System.out.println("ENTER YOUR CHOICE: ");

        int choice = sc.nextInt();
        switch (choice){
            case 1: ;

                break;
            case 2: ;

                break;
            case 3: ;

                break;
            case 4: ;

                break;
            case 5: ;

                break;
            case 6: ;

                break;
            case 7: ;

                break;
            case 8: new EditProfile();

                break;
            case 9: ;

                break;
        }
    }

}
