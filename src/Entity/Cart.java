package Entity;

import Repository.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product>cartList  = new ArrayList<>();

     Repository repository;

     public void getProductsInTheCart() throws IOException {
         FileInputStream fin = new FileInputStream("cart.csv");
         BufferedInputStream bis = new BufferedInputStream(fis);

         int i;
         while((i=bis.read())!=-1) {
             System.out.println((char)i);
         }
         bis.close();
         fin.close();


         cartList.forEach(product -> System.out.println(product.getProductName()));
     }
    public void addProductToCart(String... productName) throws FileNotFoundException {
        int size = 0;
        while (size < productName.length) {
            Product product = repository.searchProduct(productName[size++]);
            if (product == null) {
                System.out.println(productName[size]+ " not found!!");
            } else {
                cartList.add(product);

                FileOutputStream fout = new FileOutputStream("cart.csv");
                BufferedOutputStream bof = new BufferedOutputStream(fout);
                String str = product.getProductName()+","+product.getPrice();

                  byte[]b = str.getBytes();

                  try {
                	  bof.write(b);
                	  bof.flush();
                	  bof.close();
//                      fout.flush();
//                      fout.close();
                 }catch(IOException e) {
                	  e.printStackTrace();
                 }
            }
        }
    }
}
