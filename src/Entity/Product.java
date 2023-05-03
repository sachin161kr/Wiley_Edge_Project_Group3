package Entity;

public class Product {
    private int productId;
    private String productName;
    private String category;
    private int price;
    private double rating;

    public Product() {
    }

    public Product(int productId, String productName, String category, int price, double rating) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    public String toString(){
        return "Name: "+ getProductName()+", Category: "+getCategory()+", Price: "+getPrice()+", Rating: "+getRating();
    }
    public void printProduct(){
        System.out.println("Name: "+ getProductName()+"\n Category: "+getCategory()+"\n Price: "+getPrice()+"\n Rating: "+getRating());
    }

}
