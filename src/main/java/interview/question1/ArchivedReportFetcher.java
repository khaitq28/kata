package interview.question1;

import java.math.BigDecimal;
import java.util.List;

/**
 * Concrete Strategy — fetches archived reports only.
 * Replaces: type=2 branch.
 */
public class ArchivedReportFetcher implements DataFetcher {

    @Override
    public List<OrderDto> fetch() {
        // Real implementation would call a repository.
        // Stub for illustration:
        return List.of(
            new OrderDto("RPT-2023-12", "Bob Chen", new BigDecimal("0.00"))
        );
    }
}
