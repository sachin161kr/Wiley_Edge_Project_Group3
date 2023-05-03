package Repository;

import Entity.Customer;
import Entity.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Repository {
    HashMap<String, Product> productMap = new HashMap<>();
    List<Product> productList = new ArrayList<>();
    List<String>categoryList = new ArrayList<>();
   List<Customer>customerList = new ArrayList<>();
    private static final String CSV_SPLIT_BY = ",";

    public Repository() {
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
    }
//    public void fillProductList(){
//
//
//    }

    public Product searchProductByName(String productName) {
        if (productMap.containsKey(productName)) {
            return productMap.get(productName);
        } else {
            return null;
        }
    }

    public List<Product> searchProductsByCategory(String category) {

        //1st check if category exists in the cateList
        if (!categoryList.contains(category)) {
            System.out.println("Invalid category name!");
            return new ArrayList<>();
        }
        {
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
    }

    public void getAllProducts() {

//        productList.forEach(product -> System.out.println(product.getProductName()));
        for (Product product : productList) {
            product.printProduct();

            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        }
    }

    public void addCategory(String categoryName) {
        categoryList.add(categoryName);
    }
//
//    public void removeCustomer(int id) {
//        for(Customer customer:customerList){
//            if(customer.getCustomerId()==id){
//                customerList.remove(customer);
//                return;
//            }
//        }
//        System.out.println("Invalid Customer id");
//        return;
//    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }
}
