package Entity;
import Exceptions.InvalidProductNameException;
import Interface.Customer;
import Repository.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerImpl extends Shop implements Customer {
    static Repository repository = new Repository();
    public static void main(String[] args) {

    }
    private String username;
    private String password;

    public CustomerImpl(String username, String password) {

        this.username = username;
        this.password = password;
    }

    public CustomerImpl() {
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
        CustomerImpl.in = in;
    }

    public static List<Product> getCartList() {
        return cartList;
    }

    public static void setCartList(List<Product> cartList) {
        CustomerImpl.cartList = cartList;
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
            Product product = new Product();
            try {
                 product = repository.searchProductByName(products[size].trim());
                if (product == null) {
                    throw new InvalidProductNameException(products[size] + " not found!!");
                }
            }
             catch (InvalidProductNameException e){
                 System.out.println(e.getMessage());
             }
                cartList.add(product);
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

    public static void createUser(String username, String password) {
        CustomerImpl customerImpl = new CustomerImpl(username,password);
        repository.addCustomer(customerImpl);
        List<String[]> users = viewRegisteredCustomers();


    }

    //    view registered customers

    public static List<String[]> viewRegisteredCustomers() {
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
