package employee;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class EmployeeFilter {

    public List<Employee> filterEmployees(List<Employee> employees) {
        return employees.stream()
                .filter(getPredicate())
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }

    public abstract Predicate<Employee> getPredicate();
}
