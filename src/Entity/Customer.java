package Entity;

import Connection.StorageConnection;
import Repository.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends Shop{
    static Repository repository;
    public static void main(String[] args) {
//        Scanner sc= new Scanner(System.in);
        repository.getAllProducts();
    }
    private int customerId;
    private String customerName;
    private String mobile;
    static Scanner in = new Scanner(System.in);
    private List<Product> cartList  = new ArrayList<>();


    static void registerCustomer() {
        System.out.println("==========CUSTOMER PORTAL===========");
        register();
        return;

    }
    static void register(){
        int check = 0;
        int id;
        String name, email, pass, num;

        System.out.print("Enter Name = ");
        name = in.nextLine();

        System.out.println("CUSTOMER ID= ");
        id = in.nextInt();
        in.nextLine();

        System.out.print("Enter password= ");
        pass = in.nextLine();

        System.out.print("Enter contact number = ");
        num = in.next();
        in.nextLine();

        System.out.print("Enter email= ");
        email = in.nextLine();

        System.out.println("SUCCESSFULLY REGISTERED AS CUSTOMER !!");
        System.out.println();
        System.out.println("*************************************");
    }





    public void viewTheCart(){
        for (Product p : cartList){
            System.out.println(p.toString());
        }
    }


    public void removeProductFromCart(String productName) throws FileNotFoundException {
        //1.remove from cartList
        for(Product product:cartList){
            if (product.getProductName().equals(productName)){
                cartList.remove(product);
                break;
            }
        }


    }
    public void addProductToCart(String... products) throws FileNotFoundException {
        int size = 0;
        repository.getAllProducts();
        while (size < products.length) {
            Product product = repository.searchProductByName(products[size].trim());
            if (product == null) {
                System.out.println(products[size] + " not found!!");
            } else {
                cartList.add(product);
            }
            size++;
        }
    }
    public void searchProductByName(String productName){
        Product product =repository.searchProductByName(productName);
        product.printProduct();
    }
    public void searchProductByCategory(String category){
        List<Product> productListByCategory =repository.searchProductsByCategory(category);
        for(Product product:productListByCategory){
            product.printProduct();
            System.out.println("++++++++++++++++++++++++++++++");
        }
    }
    public void loginCustomer() {
    }
}
