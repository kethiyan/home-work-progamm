package com.webproject.fibernet.Repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.webproject.fibernet.Models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByUsername(String username);
}
