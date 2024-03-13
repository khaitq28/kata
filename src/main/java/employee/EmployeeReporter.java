package employee;

import java.util.List;

public class EmployeeReporter implements Reporter {


    @Override
    public String getReport(List<Employee> employeeList) {
        StringBuilder sb = new StringBuilder("name | age").append("\n");
        for (Employee e: employeeList) {
            sb.append(e.getInfo()).append("\n");
        }
        return sb.toString();
    }
}
