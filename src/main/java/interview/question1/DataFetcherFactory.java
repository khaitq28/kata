package interview.question1;

/**
 * Factory — wires the correct Strategy for a given FetchType.
 * Callers never write if/else; adding a new type = add a new Strategy + one enum value.
 */
public class DataFetcherFactory {

    private final ActiveOrderFetcher activeOrderFetcher;
    private final ArchivedReportFetcher archivedReportFetcher;

    public DataFetcherFactory(ActiveOrderFetcher activeOrderFetcher,
                              ArchivedReportFetcher archivedReportFetcher) {
        this.activeOrderFetcher = activeOrderFetcher;
        this.archivedReportFetcher = archivedReportFetcher;
    }

    public DataFetcher create(FetchType type) {
        return switch (type) {                      // sealed switch — compiler enforces exhaustiveness
            case ACTIVE_ORDERS    -> activeOrderFetcher;
            case ARCHIVED_REPORTS -> archivedReportFetcher;
        };
    }
}
