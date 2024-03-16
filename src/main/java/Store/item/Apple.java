package Store.item;

public class Apple extends  Food{

    public Apple() {
        super(15, 50);
    }

    protected String getOutMessage() {
        return Constants.APPLE_MESSAGE;
    }
}
