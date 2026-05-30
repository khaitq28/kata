package interview.craftsman.question16;

import java.util.List;

public class InventoryService {
    public void reserve(List<String> items) {
        System.out.println("Inventory reserved for " + items.size() + " items");
    }
}
