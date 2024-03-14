package employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShopTest {

    private Shop shop;

    @BeforeEach
    void setUp() {
        shop = new Shop(new EmployeeReporter());
    }


    @Test
    void getAdultEmployeeSorted() {
        shop.addEmployee(new Employee("xbc", 47));
        shop.addEmployee(new Employee("def", 27));
        assertThat(shop.reportAdultEmployees(new AdultFilter())).isEqualTo("name | age\n" +
                "def | 27\n" +
                "xbc | 47\n");
    }

    @Test
    void getAdultEmployeeReport() {
        shop.addEmployee(new Employee("xbc", 47));
        shop.addEmployee(new Employee("def", 17));
        shop.addEmployee(new Employee("ab", 61));
        assertThat(shop.reportAdultEmployees(new AdultFilter())).isEqualTo("name | age\n" +"xbc | 47\n");
    }

    @Test
    void getSeniorEmployeeReport() {
        shop.addEmployee(new Employee("xbc", 47));
        shop.addEmployee(new Employee("def", 17));
        shop.addEmployee(new Employee("ab", 61));
        assertThat(shop.reportSeniorEmployees(new SeniorFilter())).isEqualTo("name | age\n" +"ab | 61\n");
    }

}