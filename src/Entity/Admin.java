package Entity;

import Repository.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends Shop {
    static Scanner in = new Scanner(System.in);

    Repository repository = new Repository();
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

    public void loginAdmin(String username,String password) {
       if (username.equals("admin")&&password.equals("admin")){
           System.out.println("Logged in Successfully !");
           Admin admin = new Admin();
       }else {
           System.out.println("INCORRECT USERNAME OR PASSWORD!!");
       }

    }
    public void addCategory(String categoryName){
        repository.addCategory(categoryName);
    }
//    removing customers

//    public void removeCustomer(int id){
//        repository.removeCustomer(id);
//    }



//        email = in.nextLine();
//        if (Validation.validate(pass)) insert(name, id, pass, num, email, check);
//        else {
//            System.out.println("Your PassWord is Weak!\n Try Again!\n");
//            regisAdmin();
//        }
    }



