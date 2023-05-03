package Repository;

import Entity.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Repository {
    HashMap<String,Product> productMap  = new HashMap<>();
   List<Product>productList  = new ArrayList<>();
    private static final String CSV_SPLIT_BY = ",";

    public void fillProductList(){
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
                        int price = Integer.parseInt(data[3].trim());;
                        double rating = Double.parseDouble(data[4].trim());

                        Product product = new Product(productId,productName,category,price,rating);
                   productList.add(product);
                   productMap.put(product.getProductName(),product);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    public Product searchProductByName(String productName) {
        if(productMap.containsKey(productName)){
            return productMap.get(productName);
        }else{
            return null;
        }
    }
    public List<Product> searchProductsByCategory(String category){
        List<Product> productListByCategory = new ArrayList<>();
       for(Product product1:productList){
           if(product1.getCategory().equals(category)){
               productListByCategory.add(product1);
           }
       }
       return productListByCategory;
    }
    public void getAllProducts() {
        fillProductList();
//        productList.forEach(product -> System.out.println(product.getProductName()));
        for (Product product:productList){
            product.printProduct();
        }
    }
}
