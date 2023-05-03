package Entity;

import java.util.*;

public class EditProfile {
	
	Scanner sc = new Scanner(System.in);
	
	Customer c = new Customer("Sachin","8989898989") ;
	
	public void updateName()
	{      
		  System.out.println("Enter New Name");
		  String newName = sc.nextLine();
		   c.setName(newName);
		  System.out.println("Name updated");
	}
	
	public void updatePhone()
	{
		System.out.println("Enter New Mobile");
		  String newMobile = sc.nextLine();
		   c.setName(newMobile);
		  System.out.println("Phone updated");
	}
	
	public EditProfile() // Add customer object
	{   
		this.c = c;
		
		 Scanner sc = new Scanner(System.in);
	        System.out.println("EDIT PROFILE");
	        System.out.println();

	        while(true){
	            System.out.println("1. UPDATE NAME");
	            System.out.println("2. UPDATE MOBILE");
	            System.out.println("3. GO BACK");
	            System.out.println();
	            System.out.println("ENTER YOUR CHOICE: ");
	            int option = sc.nextInt();

	            switch (option){
	                case 1: updateName();

	                break;
	                case 2 : updatePhone();
	                break;
	                case 3:
	                    System.out.println("THANK YOU");
	                break;

	                default:
	                    System.out.println("PLEASE ENTER CORRECT CHOICE ");
	            }

	        }
	}

}
