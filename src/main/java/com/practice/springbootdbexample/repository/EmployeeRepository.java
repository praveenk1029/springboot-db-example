package com.practice.springbootdbexample.repository;

import com.practice.springbootdbexample.model.Employee;
import com.practice.springbootdbexample.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByEmpId(Integer empId);
}
