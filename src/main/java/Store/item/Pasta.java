package Store.item;

public class Pasta extends Food{

	public Pasta() {
		super(50, 75);
	}

    public String getOutMessage() {
        return Constants.PASTA_MESSAGE;
    }
}
