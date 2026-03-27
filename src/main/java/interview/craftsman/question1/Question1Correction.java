package interview.craftsman.question1;

import java.util.List;

/**
 * INTERVIEW QUESTION 1 — Corrected version.
 *
 * Fixes applied:
 *  ✔ Flag Argument removed  → two explicit, well-named methods
 *  ✔ Primitive Obsession    → FetchType enum
 *  ✔ Generic return type    → List<OrderDto> (strong-typed record)
 *  ✔ SRP                    → each method / class has one reason to change
 *  ✔ OCP                    → adding a new fetch type = new Strategy class, no existing code touched
 *  ✔ Strategy Pattern       → DataFetcher interface + concrete implementations
 *  ✔ Factory Pattern        → DataFetcherFactory wires the right strategy
 *  ✔ Clean names            → fetchActiveUserOrders(), fetchArchivedReports()
 */
public class Question1Correction {

    private final DataFetcherFactory factory;

    public Question1Correction(DataFetcherFactory factory) {
        this.factory = factory;
    }

    /**
     * Replaces: getData(1, true, null)
     * Fetches all active orders — no filter.
     */
    public List<OrderDto> fetchActiveUserOrders() {
        return factory.create(FetchType.ACTIVE_ORDERS).fetch();
    }

    /**
     * Replaces: getData(1, true, "Alice")
     * String s is now a named, typed, scoped parameter — only where it's needed.
     */
    public List<OrderDto> fetchActiveUserOrdersByCustomer(String customerNameFilter) {
        return factory.create(FetchType.ACTIVE_ORDERS).fetch()
                .stream()
                .filter(order -> order.customerName().equalsIgnoreCase(customerNameFilter))
                .toList();
    }

    /**
     * Replaces: getData(2, false, s)
     * Name communicates intent — no parameters needed, no flags.
     */
    public List<OrderDto> fetchArchivedReports() {
        return factory.create(FetchType.ARCHIVED_REPORTS).fetch();
    }
}
