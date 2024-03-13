package employee;

import java.util.function.Predicate;

public class AdultEmployeePredicate implements Predicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 18 && employee.getAge() < 60;
    }
}
