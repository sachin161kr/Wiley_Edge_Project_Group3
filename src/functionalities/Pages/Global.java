package functionalities.Pages;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Global {

    private static String adminUsername = "Admin";
    private static String adminPassword = "Admin";

    public static HashMap<String, ArrayList<String>> getCategoryMap() {
        return categoryMap;
    }

    public static void setCategoryMap(HashMap<String, ArrayList<String>> categoryMap) {
        Global.categoryMap = categoryMap;
    }

    private static HashMap<String,ArrayList<String>> categoryMap = new HashMap<>();

    private static ArrayList<String> productsList = new ArrayList<>();

    public static void setProductsList(ArrayList<String> productsList) {
        Global.productsList = productsList;
    }

    public static ArrayList<String> getProductsList() {
        return productsList;
    }

    public static String getAdminUsername() {
        return adminUsername;
    }

    public static String getAdminPassword() {
        return adminPassword;
    }

    // Customers
//
//    private static ArrayList<Customers> customerList = new ArrayList<>();
//
//    public static ArrayList<Customers> getCustomerList() {
//        return customerList;
//    }
//
//    public static void setCustomerList(ArrayList<Customers> cus) {
//        Global.customerList = cus;
//    }



}
