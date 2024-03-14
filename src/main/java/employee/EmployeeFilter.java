package employee;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class EmployeeFilter {


    public List<Employee> filterEmployees(List<Employee> employees) {

        return employees.stream()
                .filter(getPredicate())
                .sorted(getComparator())
                .collect(Collectors.toList());
    }

    private Comparator<Employee> getComparator() {
        return getSortOrder() == SortOrder.ASC ?
                                        Comparator.comparing(Employee::getName) :
                                        Comparator.comparing(Employee::getName).reversed();
    }

    public abstract Predicate<Employee> getPredicate();

    public abstract SortOrder getSortOrder();
}
