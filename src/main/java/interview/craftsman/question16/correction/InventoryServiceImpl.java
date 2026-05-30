package interview.craftsman.question16.correction;

import java.util.List;

public class InventoryServiceImpl implements InventoryServiceInterface{
    public void reserve(List<String> items) {
        System.out.println("Inventory reserved for " + items.size() + " items");
    }
}
