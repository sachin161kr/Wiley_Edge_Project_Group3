package Entity;
//remaining
//editing profiles,






import Connection.StorageConnection;
import Repository.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends Shop{
    static Repository repository = new Repository();
    public static void main(String[] args) {
        try {
            addProductToCart("Mouse","Pc");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        checkOut();
    }
    private String username;
    private String password;

    public Customer(String username, String password) {

        this.username = username;
        this.password = password;
    }

    public Customer() {
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Scanner getIn() {
        return in;
    }

    public static void setIn(Scanner in) {
        Customer.in = in;
    }

    public static List<Product> getCartList() {
        return cartList;
    }

    public static void setCartList(List<Product> cartList) {
        Customer.cartList = cartList;
    }

    static Scanner in = new Scanner(System.in);
    private static List<Product> cartList  = new ArrayList<>();


    static void checkOut(){
        long sum = 0;
        for (Product product:cartList){
            sum+=product.getPrice();
        }
       Payment payment = new Payment();
        payment.getWay(cartList,sum);
    }

    static void registerCustomer() {
        System.out.println("==========CUSTOMER PORTAL===========");
        register();
        return;

    }
    static void register(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter customer id :");
        int id = sc.nextInt();

        System.out.println("Enter customer name :");
        String name =sc.nextLine();

        System.out.println("Enter mobile no :");
        String mobile = sc.nextLine();

        System.out.println("Enter username :");
        String username = sc.nextLine();

        System.out.println("Enter Password :");
        String password = sc.nextLine();

         createUser(username,password);

        System.out.println("SUCCESSFULLY REGISTERED AS CUSTOMER !!");
        System.out.println();
        System.out.println("*************************************");
    }
    public static void viewTheCart(){
        System.out.println("YOUR CART ITEMS: ");
        System.out.println();
        for (Product p : cartList){
            p.printProduct();
            System.out.println();
        }
    }


    public static void removeProductFromCart(String productName) throws FileNotFoundException {
        //1.remove from cartList
        for(Product product:cartList){
            if (product.getProductName().equals(productName)){
                cartList.remove(product);
                break;
            }
        }


    }
    public static void addProductToCart(String... products) throws FileNotFoundException {
        int size = 0;

        while (size < products.length) {
            if(products[size].equals("END")){
                return;
            }
            Product product = repository.searchProductByName(products[size].trim());
            if (product == null) {
                System.out.println(products[size] + " not found!!");
            } else {
                cartList.add(product);
            }
            size++;
        }
    }
    public static void searchProductByName(String productName){
        Product product =repository.searchProductByName(productName);
        product.printProduct();
    }
    public static void searchProductByCategory(String category){
        List<Product> productListByCategory =repository.searchProductsByCategory(category);
        for(Product product:productListByCategory){
            product.printProduct();
            System.out.println("++++++++++++++++++++++++++++++");
        }
    }

    private static void createUser(String username, String password) {
        Customer customer = new Customer(username,password);
        repository.addCustomer(customer);
        List<String[]> users = viewRegisteredCustomers();


    }
    //    view registered customers









    private static List<String[]> viewRegisteredCustomers() {
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
    public static void loginCustomer() {


    }
}
