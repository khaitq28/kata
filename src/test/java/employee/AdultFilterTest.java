package employee;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AdultFilterTest {

    private final AdultFilter filter = new AdultFilter();

    @Test
    void filterEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("xbc", 47));
        list.add(new Employee("def", 17));
        list.add(new Employee("ab", 61));

        assertEquals(filter.filterEmployees(list).get(0).getName(), "xbc");
        assertEquals(filter.filterEmployees(list).get(0).getAge(), 47);
    }
}