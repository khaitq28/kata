package interview.craftsman.question14;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question14Correction {

    @Data
    static class Item {
        private final String name;
        private final double price;

    }
    static class Cart {

        private final List<Item> items = new ArrayList<>();

        public double getTotal() {
            return items.stream().mapToDouble(Item::getPrice).sum();
        }
        public void addItem(Item item) {
            items.add(item);
        }
        public void removeItem(String itemName) {
            items.removeIf(item -> item.getName().equals(itemName));
        }

        public String getCheckoutConfirmation() {
            if (items.isEmpty()) throw new IllegalStateException("Cart is empty");
            return "CONF-" + System.currentTimeMillis();
        }

        public void clear() {
            items.clear();
        }
    }
}
