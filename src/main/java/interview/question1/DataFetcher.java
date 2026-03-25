package interview.question1;

import java.util.List;

/**
 * Strategy interface — each implementation encapsulates one fetch behaviour.
 * Replaces the if/else branching on type code.
 */
public interface DataFetcher {
    List<OrderDto> fetch();
}
