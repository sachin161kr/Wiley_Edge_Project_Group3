package Repository;

import Entity.CustomerImpl;
import Entity.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Repository {
    HashMap<String, Product> productMap = new HashMap<>();
    Set<Product> productList = new HashSet<>();
    List<String> categoryList = new ArrayList<>();
    List<CustomerImpl> customerImplList = new ArrayList<>();
    private static final String CSV_SPLIT_BY = ",";

    public static void main(String[] args) {
        Repository repository = new Repository();
//        repository.removeProduct("Mouse");
//
//        repository.addCategory("Stationary");
//        repository.addCategory("Stationary");
//        repository.addCategory("Stationary");
//        repository.addCategory("Electronics");
//repository.removeCategory("Electronics");
//        repository.viewAllCategories();
    }

    public Repository() {

        //filling product ArrayList by taking data from product.csv as we create object of repository
        String csvFile = "product.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                //"1","Mouse","Electronics","300","4.5"
                String[] data = line.split(CSV_SPLIT_BY);
                // Process the data as needed
                int productId = Integer.parseInt(data[0].trim());
                String productName = data[1].trim();
                String category = data[2].trim();
                int price = Integer.parseInt(data[3].trim());
                double rating = Double.parseDouble(data[4].trim());

                Product product = new Product(productId, productName, category, price, rating);
                productList.add(product);
                productMap.put(product.getProductName(), product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String csvFile2 = "categories.csv";
        String line = "";
        String delimiter = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile2))) {

            while ((line = br.readLine()) != null) {
                String[] category = line.split(delimiter);
                categoryList.add(category[0]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Product searchProductByName(String productName) {
        if (productMap.containsKey(productName)) {
            return productMap.get(productName);
        } else {
            return null;
        }
    }

    public List<Product> searchProductsByCategory(String category) {

        //category list
        List<Product> productListByCategory = new ArrayList<>();


        for (Product product1 : productList) {

            //adding if category is same
            if (product1.getCategory().equals(category)) {
                productListByCategory.add(product1);
            }
        }
        if (productListByCategory.isEmpty()) {
            System.out.println("No Products of that category!");
        }

        return productListByCategory;
    }


    public void getAllProducts() {

//        productList.forEach(product -> System.out.println(product.getProductName()));
        for (Product product : productList) {
            product.printProduct();

            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        }
    }

    public void removeCategory(String categoryName) {

        categoryList.remove(categoryName.trim());
        fillCSVFromCategoryList();
    }


    public void addCategory(String categoryName) {
        //fetch data from csv
        categoryList.add(categoryName);
        //fill data to category.csv from categoryList
        fillCSVFromCategoryList();
        //add category to category list
        System.out.println("Successfully added Category 👍");
    }
    public void removeProduct(String productName){
        Product product1 = new Product();
        for(Product product:productList){
            if(product.getProductName().trim().equals(productName)){
                product1=product;
            }
        }
        productList.remove(product1);
        clearCsv();
        addProductsToCsv();
        System.out.println("Successfully removed Category 👍");
    }
public void addProduct(){
    Scanner sc = new Scanner(System.in);
    System.out.println("=========ADD PRODUCT SECTION=========");
    System.out.println();
    System.out.println("Id of the product: ");
    int id = sc.nextInt();
    System.out.println("Name of the product: ");
    String name = sc.next().trim();
    System.out.println("Enter the Category: ");
    String category =sc.next().trim();
    System.out.println("Enter the price: ");
    int price = sc.nextInt();
    System.out.println("Enter the Rating: ");
    double rating = sc.nextDouble();

    Product product = new Product(id,name,category,price,rating);
    productList.add(product);
    addProductsToCsv();

}
    public void viewAllCategories() {
        System.out.println("=============CATEGORIES==============");
        for (String s : categoryList) {
            System.out.println(s);
        }
    }


    //reusable functions===================================================================================

    //1.To Entirely clear csv
    public void clearCsv() {
        try (FileWriter writer = new FileWriter("product.csv")) {
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //2.To add all products productList to product.csv
    public void addProductsToCsv() {
        clearCsv();
        try (FileWriter writer = new FileWriter("product.csv", true)) {
            for (Product product : productList) {
                writer.write(product.getProductId() + CSV_SPLIT_BY);
                writer.write(product.getProductName() + CSV_SPLIT_BY);
                writer.write(product.getCategory() + CSV_SPLIT_BY);
                writer.write(product.getPrice() + CSV_SPLIT_BY);
                writer.write(product.getRating() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//3.To add all products categoryList to category.csv
    public void fillCSVFromCategoryList() {
        String csvFile = "categories.csv";
        String delimiter = ",";

        try (FileWriter writer = new FileWriter(csvFile)) {
            for (String category : categoryList) {
                writer.write(category);
                writer.write(delimiter);
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



//
//    public void removeCustomer(int id) {
//        for(CustomerImpl customer:customerImplList){
//            if(customer.getCustomerId()==id){
//                customerImplList.remove(customer);
//                return;
//            }
//        }
//        System.out.println("Invalid CustomerImpl id");
//        return;
//    }

    public void addCustomer(CustomerImpl customerImpl) {
        customerImplList.add(customerImpl);
    }
}
