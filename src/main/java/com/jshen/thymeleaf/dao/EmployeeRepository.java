package com.jshen.thymeleaf.dao;

import com.jshen.thymeleaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // method to sort employee by last name
    public List<Employee> findAllByOrderByLastNameAsc(); //JPA will parse the method name
}
