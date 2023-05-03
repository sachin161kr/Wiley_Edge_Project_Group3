package Entity;

import Repository.Repository;

import java.util.Scanner;

public class Admin extends Shop {
    static Scanner in = new Scanner(System.in);

    static void registerAdmin() {
        System.out.println("==========ADMIN PORTAL===========");

//        while(true) {
           register();
           return;

    }
    static void register(){
        int check = 0;
        int id, age;
        String name, email, pass, num;

        System.out.print("Enter Name = ");
        name = in.nextLine();


        System.out.println("Admin ID= ");
        id = in.nextInt();
        in.nextLine();

        System.out.print("Enter password= ");
        pass = in.nextLine();

        System.out.print("Enter contact number = ");
        num = in.next();
        in.nextLine();

        System.out.print("Enter email= ");
        email = in.nextLine();

        //file input


        //
        System.out.println("SUCCESSFULLY REGISTERED AS ADMIN !!");
        System.out.println();
        System.out.println("*************************************");
    }

    public void loginAdmin() {

    }
//        email = in.nextLine();
//        if (Validation.validate(pass)) insert(name, id, pass, num, email, check);
//        else {
//            System.out.println("Your PassWord is Weak!\n Try Again!\n");
//            regisAdmin();
//        }
    }



