package dev.obey.employee_registration.service;

import dev.obey.employee_registration.domain.Employee;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getEmployees();
    void  saveEmployee(Employee employee);
    Employee getEmployeeById(long id);

    void deleteById(long id);

    Page<Employee> findPaginated(int pageNo, int pageSize);
}
