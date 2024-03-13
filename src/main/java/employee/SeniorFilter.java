package employee;

import java.util.function.Predicate;

public class SeniorFilter extends EmployeeFilter {
    @Override
    public Predicate<Employee> getPredicate() {
        return new SeniorEmployeePredicate();
    }
}
