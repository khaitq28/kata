package employee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdultEmployeePredicateTest {

    private final AdultEmployeePredicate predicate = new AdultEmployeePredicate();;

    @Test
    void test1() {
        assertFalse(predicate.test(new Employee("abc", 15)));
        assertTrue(predicate.test(new Employee("abc", 25)));
    }

    @ParameterizedTest
    @ValueSource(ints = {16, 17,2,3,10,12,13,15,17})
    public void employeeAdultFalse(int age) {
        assertFalse(predicate.test(new Employee("abc", age)));
    }
}