package dev.obey.employee_registration.service;

import dev.obey.employee_registration.domain.User;
import dev.obey.employee_registration.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
