package interview.question3;

/**
 * INTERVIEW QUESTION 3 — Original (smelly) code.
 *
 * Smells present (do NOT read this before answering — covered by question):
 *  - ???
 *  - ???
 *  - ???
 *  - ???
 */
public class Question3Original {

    public void process(Order order) {
        if (order.getCustomer().getAddress().getCountry().code().equals("US")) {
            order.getShipment().setCarrier("UPS");
            order.getShipment().setPrice(
                order.getItems().stream()
                    .mapToDouble(Item::getPrice)
                    .sum() * 0.1
            );
        }
    }
}
