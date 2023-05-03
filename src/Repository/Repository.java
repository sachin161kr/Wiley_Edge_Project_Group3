package Repository;

import Entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Repository {
    HashMap<String,Product> productMap  = new HashMap<>();
   List<Product>productList  = new ArrayList<>();

    public Product searchProduct(String productName) {
        if(productMap.containsKey(productName)){
            return productMap.get(productName);
        }else{
            return null;
        }
    }
}
