package dev.obey.employee_registration;

import dev.obey.employee_registration.repositories.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {EmployeeRepository.class})
public class EmployeeRegistrationAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRegistrationAppApplication.class, args);
	}

}
