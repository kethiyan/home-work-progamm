package com.webproject.fibernet.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.webproject.fibernet.Models.Employee;
import com.webproject.fibernet.Repositories.EmployeeRepository;

@Service
public class EmployeeService implements UserDetailsService {

    @Autowired
    private EmployeeRepository repo;

    @Autowired
    @Lazy
    private PasswordEncoder encoder;

    public Employee register(Employee employee) {
        employee.setPassword(encoder.encode(employee.getPassword()));
        return repo.save(employee);
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        System.out.println("Searching user : " + username);

        Employee emp = repo.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Employee not found"));

        System.out.println("DB Username : " + emp.getUsername());
        System.out.println("DB Password : " + emp.getPassword());

        return User.builder()
                .username(emp.getUsername())
                .password(emp.getPassword())
                .roles(emp.getRole() != null ? emp.getRole() : "TECHNICIAN")
                .build();
    }
}