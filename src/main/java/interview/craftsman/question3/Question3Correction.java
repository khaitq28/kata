package interview.craftsman.question3;

/**
 * INTERVIEW QUESTION 3 — Correction placeholder.
 *
 * TODO (candidate):
 *  1. Name ALL smells you see in Question3Original
 *  2. Fix the train wreck: order.getCustomer().getAddress().getCountry().code()
 *  3. Fix the Tell Don't Ask violation on Shipment
 *  4. Move behaviour to the right class (which class should own shipping logic?)
 *  5. Ensure no external class reaches inside Order's object graph
 */
public class Question3Correction {

    public void process(Order order) {
        order.processShipmentPrice();
    }

}
