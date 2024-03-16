package Store.item;

public class Builder {

    public Shelves build(ShelveType type) {

        switch (type) {
            case A:
                return new ShelveA();
            case B:
                return  new ShelveB();
        }
        throw  new IllegalArgumentException("Not found type");
    }
}
