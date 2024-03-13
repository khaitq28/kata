package employee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeniorEmployeePredicateTest {

    private final SeniorEmployeePredicate predicate = new SeniorEmployeePredicate();

    @Test
    public void testSenior() {
        assertFalse(predicate.test(new Employee("ab", 53)));
        assertTrue(predicate.test(new Employee("ab", 63)));
    }

}