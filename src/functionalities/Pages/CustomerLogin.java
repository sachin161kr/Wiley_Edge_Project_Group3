package functionalities.Pages;

import java.util.Objects;
import java.util.Scanner;

public class CustomerLogin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Customer Username");

        String username = sc.nextLine();

        System.out.println("Enter Customer Password");

        String password = sc.nextLine();

        if(Objects.equals(Global.getAdminUsername(), username) && Objects.equals(Global.getAdminPassword(), password))
        {
            System.out.println("Admin Login Successful");
        }
        else
        {
            System.out.println("Admin Login Failed");
        }
    }
}
