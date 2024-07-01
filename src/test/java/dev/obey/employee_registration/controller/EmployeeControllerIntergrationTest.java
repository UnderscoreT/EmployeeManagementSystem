package dev.obey.employee_registration.controller;

import dev.obey.employee_registration.domain.Employee;
import dev.obey.employee_registration.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@AutoConfigureTestDatabase
@Transactional
class EmployeeControllerTest {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    JdbcTemplate jdbcTemplate;

    private List<Long> getIds(){
        return jdbcTemplate.query("select id from employees",(rs,num)->rs.getLong("id"));
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void viewHomePage() {
    }

    @Test
    void showNewEmployeeForm() {
    }

    @Test
    void testSaveEmployee() {
        Employee employee=new Employee();

        employee.setFirstName("Gary");
        employee.setLastName("Kasparov");
        employee.setEmail("garykaspa@gmail.com");
        employeeService.saveEmployee(employee);
        assertNotNull(employee.getId());

    }

    @Test
    void findOneThatExists() {
        getIds().forEach(id ->{
            Employee employee = employeeService.getEmployeeById(id);
            assertNotNull(employee);
            assertEquals(id,employee.getId());
        });
    }
    @Test
    void findOneThatDoesNotExist(){
        Employee employee = employeeService.getEmployeeById(99);
        assertNull(employee);
    }

    @Test
    void deleteEmployee() {
    }
}