package refactoring_a;

public class Product {
    public String name;
    public String category;
    public double price;
    public int quantity;

    public Product(String name, String category, double price, int quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + ", " + category + ", " + price + ", " + quantity;
    }
}