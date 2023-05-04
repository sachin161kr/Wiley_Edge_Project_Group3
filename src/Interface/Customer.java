package Interface;

import Entity.CustomerImpl;
import Entity.Payment;
import Entity.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface Customer {

    public static void checkOut() {}

    public static void registerCustomer() {}

    public static void viewTheCart() {}

    public static void removeProductFromCart(String productName) throws FileNotFoundException {}

    public static void addProductToCart(String... products) throws FileNotFoundException {}

    public static void searchProductByName(String productName) {}

    public static void createUser(String username, String password) {}

    public static List<String[]> viewRegisteredCustomers() {return null;}


}
