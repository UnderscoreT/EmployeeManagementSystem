package dev.obey.employee_registration.repositories;

import dev.obey.employee_registration.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
