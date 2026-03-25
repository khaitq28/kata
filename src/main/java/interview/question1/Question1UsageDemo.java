package interview.question1;

import java.util.List;

/**
 * Shows side-by-side HOW the original getData() was called
 * and HOW the refactored version is called.
 *
 * Also addresses the forgotten smell: String s (unnamed string parameter).
 * In this context "s" was a customer name filter — renamed to customerNameFilter.
 */
public class Question1UsageDemo {

    // -------------------------------------------------------------------------
    // BEFORE — caller must know magic numbers, flags, and what "s" means
    // -------------------------------------------------------------------------
    static void beforeRefactoring() {
        Question1Original service = new Question1Original();

        // What does (1, true, "Alice") mean? Only the author knows.
        var activeOrders   = service.getData(1, true,  "Alice");

        // What does (2, false, null) mean? No idea without reading the method.
        var archivedReports = service.getData(2, false, null);
    }

    // -------------------------------------------------------------------------
    // AFTER — caller reads like plain English, zero guesswork
    // -------------------------------------------------------------------------
    static void afterRefactoring() {

        // 1. Build strategies (in real Spring app these are @Component beans)
        ActiveOrderFetcher    activeFetcher   = new ActiveOrderFetcher();
        ArchivedReportFetcher archivedFetcher = new ArchivedReportFetcher();

        // 2. Build factory
        DataFetcherFactory factory = new DataFetcherFactory(activeFetcher, archivedFetcher);

        // 3. Build service
        Question1Correction service = new Question1Correction(factory);

        // 4. Call — intent is crystal clear
        List<OrderDto> activeOrders    = service.fetchActiveUserOrders();
        List<OrderDto> archivedReports = service.fetchArchivedReports();
    }

    // -------------------------------------------------------------------------
    // WHAT ABOUT String s ?  — the forgotten parameter
    //
    // "s" was a filter (customer name search term).
    // It should NOT be a flag on getData().
    // It belongs as a named parameter on the specific method that needs it.
    // -------------------------------------------------------------------------
    static void withFilterParameter() {

        ActiveOrderFetcher    activeFetcher   = new ActiveOrderFetcher();
        ArchivedReportFetcher archivedFetcher = new ArchivedReportFetcher();
        DataFetcherFactory    factory         = new DataFetcherFactory(activeFetcher, archivedFetcher);
        Question1Correction   service         = new Question1Correction(factory);

        // Filter is explicit on the method that actually needs it
        // (archived reports don't need a name filter — they never did)
        List<OrderDto> aliceOrders = service.fetchActiveUserOrdersByCustomer("Alice");
    }
}
