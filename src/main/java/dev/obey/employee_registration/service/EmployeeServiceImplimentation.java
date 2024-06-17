package dev.obey.employee_registration.service;

import dev.obey.employee_registration.domain.Employee;
import dev.obey.employee_registration.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplimentation implements EmployeeService{

    EmployeeRepository employeeRepository;

    public EmployeeServiceImplimentation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
       return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);

    }
}
