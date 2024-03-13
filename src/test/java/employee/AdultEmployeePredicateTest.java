package employee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdultEmployeePredicateTest {

    private final AdultEmployeePredicate predicate = new AdultEmployeePredicate();;

    @Test
    void test1() {
        assertFalse(predicate.test(new Employee("abc", 15)));
        assertTrue(predicate.test(new Employee("abc", 25)));
    }
}