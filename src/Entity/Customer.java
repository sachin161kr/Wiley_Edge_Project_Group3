package Entity;

import java.util.Scanner;

public class Customer extends Shop{
   private long customerId;
    private String customerName;
    private String mobile;
    
    public Customer()
    {
    	
    }
    
    public Customer(String name,String Mobile)
    {
    	 this.customerName = name;
    	 this.mobile = Mobile;
    	 this.customerId = System.currentTimeMillis();
    }
    
    public String getName()
    {
    	return customerName;
    }
    
    public void setName(String newName)
    {
    	this.customerName = newName;
    }
    
    public String getMobile()
    {
    	return  mobile;
    }
    
    public void setMobile(String newMobile)
    {
    	this.mobile = newMobile;
    }
    
    


    static Scanner in = new Scanner(System.in);
    static void registerCustomer() {
        System.out.println("==========CUSTOMER PORTAL===========");

//        while(true) {
        register();
        return;

    }
    static void register(){
        int check = 0;
        int id, age;
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

        //file input


        //
        System.out.println("SUCCESSFULLY REGISTERED AS CUSTOMER !!");
        System.out.println();
        System.out.println("*************************************");
    }


    public void loginCustomer() {
    	System.out.println("hello customer");
    }
}
