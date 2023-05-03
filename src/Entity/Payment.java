package Entity;

import java.util.List;
import java.util.Scanner;

public class Payment {
    public void getWay(List<Product> cartList, long sum) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER YOUR CARD NUMBER: ");
        String cardNo = sc.nextLine();
        System.out.println("ENTER YOUR CVV: ");

        int cvv = sc.nextInt();

        Bill bill = new Bill(cartList,sum);


    }
}
