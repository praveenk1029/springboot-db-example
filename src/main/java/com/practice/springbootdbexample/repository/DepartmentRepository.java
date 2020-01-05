package com.practice.springbootdbexample.repository;

import com.practice.springbootdbexample.model.Department;
import com.practice.springbootdbexample.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
