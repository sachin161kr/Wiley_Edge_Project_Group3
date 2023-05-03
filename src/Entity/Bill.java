package Entity;

import java.util.List;

public class Bill {
    public Bill(List<Product> cartList, long sum) {
        System.out.println("================================");
        System.out.println("===============BILL=============");
        System.out.printf("%-10s %-10s %-10s" ,"Name","","Price");
        System.out.println();
        System.out.println();

        for(Product product:cartList){

            System.out.printf("%-10s %-10s %-10d",product.getProductName(),"|",product.getPrice());
            System.out.println();
        }
        System.out.println("----------------------------");

        System.out.printf("%-10s %-10s %-10s","Subtotal ","",sum);
    }
}
