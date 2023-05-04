package Entity;

import Repository.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {
    private static final String CSV_FILE_PATH = "customer.csv";



    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the User Login System");


            System.out.println("\nPlease select an option:");
            System.out.println("1. Login");
            System.out.println("2. Signup");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    signup();
                    login();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }

    }

    public static void login() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter your username:");
        String username = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        if (validateUser(username, password)) {
            System.out.println("Login successful.");
             Repository repository = new Repository();
            System.out.println();
            System.out.println("==============AVAILABLE PRODUCTS=================");
            System.out.println();
             repository.getAllProducts();

            System.out.println("Add names of the products you want to buy(case sensitive)");

            ArrayList<String> list = new ArrayList<String>();
            String input;

            while (true) {
                input = scanner.nextLine();
                if (input.equals("stop")) {
                    break;
                }
                list.add(input);
            }

            String str[] = new String[list.size()];
            for (int i = 0; i <str.length ; i++) {
                str[i] = list.get(i);
            }
            CustomerImpl.addProductToCart(str);
            CustomerImpl.viewTheCart();
            System.out.println("Do you want to checkout ?");
            String answer = scanner.nextLine();
            if(answer.equals("YES")||answer.equals("yes")){
                CustomerImpl.checkOut();
            }
            else{
                Login.login();
            }

            return;

        } else {
            System.out.println("Invalid username or password, please try again.");
        }
    }

    public static boolean validateUser(String username, String password) {
        List<String[]> users = readUsersFromCSV();

        for (String[] user : users) {
            if (user[0].equals(username) && user[1].equals(password)) {
                return true;
            }
        }

        return false;
    }

    public static void signup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter your username:");
        String username = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        if (createCutomer(username, password)) {
            System.out.println("Signup successful. You can now login.");
        } else {
            System.out.println("Username already exists, please try again with a different username.");
        }
    }

    public static boolean createCutomer(String username, String password) {
        List<String[]> users = readUsersFromCSV();

        try (FileWriter writer = new FileWriter("customer.csv", true)) {
            writer.append(String.join(",", username, password)).append("\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            return false;
        }

        return true;
    }

    public static List<String[]> readUsersFromCSV() {
        List<String[]> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("customer.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                users.add(fields);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return users;
    }
}
