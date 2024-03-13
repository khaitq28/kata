package employee;

import java.util.function.Predicate;

public class SeniorEmployeePredicate implements Predicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() > 60;
    }
}
