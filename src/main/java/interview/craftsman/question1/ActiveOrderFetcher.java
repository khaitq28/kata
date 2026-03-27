package interview.craftsman.question1;

import java.math.BigDecimal;
import java.util.List;

/**
 * Concrete Strategy — fetches active orders only.
 * Replaces: type=1, flag=true branch.
 */
public class ActiveOrderFetcher implements DataFetcher {

    @Override
    public List<OrderDto> fetch() {
        // Real implementation would call a repository.
        // Stub for illustration:
        return List.of(
            new OrderDto("ORD-001", "Alice Martin", new BigDecimal("149.99"))
        );
    }
}
