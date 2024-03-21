package employee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SeniorFilterTest {

    private final SeniorFilter seniorFilter = new SeniorFilter();
    @Test
    void getPredicate() {
        assertTrue(seniorFilter.getPredicate() instanceof SeniorEmployeePredicate);
    }

    @Test
    void getSortOrder() {
        assertEquals(SortOrder.DESC, seniorFilter.getSortOrder());
    }
}