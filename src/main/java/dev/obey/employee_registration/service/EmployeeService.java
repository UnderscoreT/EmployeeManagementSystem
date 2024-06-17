package dev.obey.employee_registration.service;

import dev.obey.employee_registration.domain.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    void  saveEmployee(Employee employee);
}
