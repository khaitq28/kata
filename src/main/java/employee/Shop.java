package employee;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private final List<Employee> employees;

    private final Reporter reporter;

    public Shop(Reporter reporter) {
        this.employees = new ArrayList<>();
        this.reporter = reporter;
    }

    public void addEmployee(Employee e) {
        this.employees.add(e);
    }

    private List<Employee> filterEmployees(EmployeeFilter filter) {
        return filter.filterEmployees(employees);
    }

    public String reportAdultEmployees() {
        return reporter.getReport(filterEmployees(new AdultFilter()));
    }
    public String reportSeniorEmployees() {
        return reporter.getReport(filterEmployees(new SeniorFilter()));
    }
}
