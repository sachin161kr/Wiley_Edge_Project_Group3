package functionalities.Pages;

import java.util.*;

public class AdminMenu {

    public  static void getAllCategories()
    {
        System.out.println("All Categories Listed below");

        HashMap<String,ArrayList<String>> hs = Global.getCategoryMap();

        for (Map.Entry<String,ArrayList<String>> entry : hs.entrySet())
            System.out.println(entry.getKey());

        System.out.println();
    }

    public static void getProducts()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Category to view products");

        String category = sc.nextLine();

        HashMap<String, ArrayList<String>> temp = Global.getCategoryMap();

        if(temp.containsKey(category))
        {

            ArrayList<String> products = temp.get(category);

            products.forEach(System.out::println);
        }
        else
        {
            System.out.println("Category Not Found");
        }

        System.out.println();
    }
    public static void removeProducts()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Category to remove products");

        String category = sc.nextLine();

        HashMap<String, ArrayList<String>> temp = Global.getCategoryMap();

        if(temp.containsKey(category))
        {

            ArrayList<String> products = temp.get(category);

            while(true){

                products.forEach(System.out::println);

                System.out.println();

                System.out.println("Enter product name to remove or type \"Exit\" to Quit process");

                String option = sc.nextLine();

                if(Objects.equals(option, "Exit"))
                {
                    break;
                }
                else {
                    products.remove(option);
                    System.out.println(option+" successfully removed");
                    System.out.println();
                }
            }

            temp.put(category,products);

            Global.setCategoryMap(temp);

            System.out.println("Products successfully removed from category "+category);
        }
        else
        {
            System.out.println("Category Not Found");
        }
    }
    public static void addProducts()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Category to add products");

        String category = sc.nextLine();

        HashMap<String, ArrayList<String>> temp = Global.getCategoryMap();

        if(temp.containsKey(category))
        {
            System.out.println("Enter number of products to add");
            int n = sc.nextInt();
            sc.nextLine();
            ArrayList<String> newProducts = new ArrayList<>();
            while(n>0)
            {
                System.out.println("Enter Products to add");
                String products = sc.nextLine();
                newProducts.add(products);
                n--;
            }
            temp.get(category).addAll(newProducts);
            Global.setCategoryMap(temp);
            System.out.println("Products Successfully Added to "+category);
        }
        else
        {
            System.out.println("Category Not Found");
        }
    }

    public static void removeCategory()
    {
        Scanner sc = new Scanner(System.in);

        HashMap<String, ArrayList<String>> temp = Global.getCategoryMap();

        for (Map.Entry<String, ArrayList<String>> stringArrayListEntry : temp.entrySet()) {
            System.out.println(stringArrayListEntry);
        }

        System.out.println("Enter Category to remove");

        String category = sc.nextLine();



        if(temp.containsKey(category))
        {
            temp.remove(category);
            Global.setCategoryMap(temp);
            System.out.println("Category Successfully Removed");
        }
        else
        {
            System.out.println("Category Not Found");
        }

    }
    public static void addCategory()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter category to add");
        String category = sc.nextLine();

        ArrayList<String> newProducts = new ArrayList<>();

        System.out.println("Enter number of products to add in this category");

        int n = sc.nextInt();

        sc.nextLine();

        System.out.println("Enter Product Names");

        while(n>0)
        {
            String product = sc.nextLine();
            newProducts.add(product);
            n--;
        }

        HashMap<String, ArrayList<String>> temp = Global.getCategoryMap();

        temp.put(category,newProducts);

        Global.setCategoryMap(temp);

        System.out.println("Category Successfully Added");

    }

    public static void main(String[] args) {
        // Add/Remove Category
        // Add/Remove Products

        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("****************************************");
        System.out.println();
        System.out.println("WELCOME TO ADMIN PORTAL");

        while(true){
            System.out.println("1. View All Categories");
            System.out.println("2. View Product List");
            System.out.println("3. ADD A CATEGORY");
            System.out.println("4. REMOVE A CATEGORY");
            System.out.println("5. ADD PRODUCTS");
            System.out.println("6. REMOVE PRODUCTS");
            System.out.println("7. LOGOUT FROM ADMIN");
            System.out.println();
            System.out.println("ENTER YOUR CHOICE: ");
            int option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    AdminMenu.getAllCategories();
                }
                case 2 -> {
                    AdminMenu.getProducts();
                }
                case 3 -> {
                    AdminMenu.addCategory();
                }
                case 4 -> {
                    AdminMenu.removeCategory();
                }
                case 5 -> {
                    AdminMenu.addProducts();
                }
                case 6 -> {
                    AdminMenu.removeProducts();
                }
                case 7 -> {
                    System.out.println("Logging out Admin");
                    return;
                }
                default -> System.out.println("PLEASE ENTER CORRECT CHOICE ");
            }
        }

    }
}
