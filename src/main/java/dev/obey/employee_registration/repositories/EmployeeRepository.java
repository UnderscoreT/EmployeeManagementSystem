package dev.obey.employee_registration.repositories;

import dev.obey.employee_registration.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
