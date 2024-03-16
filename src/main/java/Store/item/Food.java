package Store.item;

public abstract class Food {

    protected int price;

    protected int quantity;

    protected boolean normalVoucher;

    protected boolean superVoucher;

    public Food(int price, int quantity) {
        this.price = price;
        this.quantity = quantity;
        this.normalVoucher = false;
        this.superVoucher = false;
    }

    public int getPrice() {
        if (isSuperVoucher())
            return price / 2;
        if (isNormalVoucher())
            return  price -2;
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        if (quantity == 0)
            System.out.print(getOutMessage());
    }

    protected String getOutMessage() {
        return "no food available";
    }

    public boolean isNormalVoucher() {
        return normalVoucher;
    }

    public void setNormalVoucher(boolean normalVoucher) {
        this.normalVoucher = normalVoucher;
        if(normalVoucher)
            setSuperVoucher(false);
    }

    public boolean isSuperVoucher() {
        return superVoucher;
    }

    public void setSuperVoucher(boolean superVoucher) {
        this.superVoucher = superVoucher;
        if (superVoucher)
            setNormalVoucher(false);
    }
}
