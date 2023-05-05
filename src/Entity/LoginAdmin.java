package Entity;

import Repository.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginAdmin {
    private static final String CSV_FILE_PATH = "admin.csv";

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("================ADMIN PORTAL=================");


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
                Login.main(args);
                break;
            case 3:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }
    public static void login() throws FileNotFoundException, InterruptedException {
         Repository repository = new Repository();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter your username:");
        String username = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        if (validateAdmin(username, password)) {
            System.out.println();
            System.out.println("Login successful🎊");
            System.out.println();
            System.out.println("Redirecting...");

            Thread.sleep(2000);
            ArrayList<String> list = new ArrayList<String>();
            String input;
            while(true) {
                System.out.println();
                System.out.println("       CHOOSE AN OPTION       ");
                System.out.println("==============================");
                System.out.println("1. View All Products");
                System.out.println("2. ADD A CATEGORY");
                System.out.println("3. REMOVE A CATEGORY");
                System.out.println("4. ADD PRODUCTS");
                System.out.println("5. REMOVE PRODUCTS");
                System.out.println("6.GET ALL CATEGORIES");
                System.out.println("7. LOGOUT FROM ADMIN");


                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println();
                        repository.getAllProducts();
                        System.out.println("=========================");
                        break;
                    case 2:
                        System.out.println("Enter the category you want to add..");
                        String category = scanner.next();
                        repository.addCategory(category);
                        break;

                    case 3:
                       System.out.println();
                        System.out.println("Enter the category you want to remove..");
                    String categoryToRemove = scanner.next().trim();
                    repository.removeCategory(categoryToRemove);
                    break;

                    case 4:
                        System.out.println();
                        repository.addProduct();
                        break;

                    case 5:
                        System.out.println();
                        System.out.println("Enter the Name of the product you want to remove: ");
                        String productName = scanner.next().trim();
                        repository.removeProduct(productName);
                        break;
                    case 6:
                        repository.viewAllCategories();
                        break;
                    case 7:
                        System.out.println();
                        System.out.println("Do you want to Exit ?");
                        String answer = scanner.next();
                        if (answer.equals("YES") || answer.equals("yes")) {
                            return;
                        } else {
                        }
                        break;
                    default:
                        System.out.println();

                        System.out.println("Choose Options only from 1,2,3,4,5 or 6");

                }
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
                scanner.nextLine();
            }



        } else {
            System.out.println("Invalid username or password, please try again.");
        }
    }

    public static boolean validateAdmin(String username, String password) {
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

        try (FileWriter writer = new FileWriter("admin.csv", true)) {
            writer.append(String.join(",", username, password)).append("\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            return false;
        }

        return true;
    }

    public static List<String[]> readUsersFromCSV() {
        List<String[]> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("admin.csv"))) {
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
