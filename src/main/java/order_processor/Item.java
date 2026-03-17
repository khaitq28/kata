package order_processor;

public enum Item {

    BOOK(12.0),
    PEN(1.5),
    BAG(35.0);

    private final double price;

    Item(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public static Item fromString(String item) {
        for (Item i : Item.values()) {
            if (i.name().equals(item)) return i;
        }
        return null;
    }
}
