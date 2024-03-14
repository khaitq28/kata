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

    public String reportAdultEmployees(EmployeeFilter filter) {
        return reporter.getReport(filterEmployees(filter));
    }
    public String reportSeniorEmployees(EmployeeFilter filter) {
        return reporter.getReport(filterEmployees(filter));
    }
}
