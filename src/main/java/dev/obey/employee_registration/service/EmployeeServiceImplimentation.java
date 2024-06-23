package dev.obey.employee_registration.service;

import dev.obey.employee_registration.domain.Employee;
import dev.obey.employee_registration.repositories.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> emp = employeeRepository.findById(id);

        if(emp.isPresent()){
            return emp.get();
        }
              else {
                  throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found");
        }

    }

    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize) {
        Pageable pageable= PageRequest.of(pageNo - 1, pageSize);
        return  employeeRepository.findAll(pageable);
    }
}
