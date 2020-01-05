package com.practice.springbootdbexample.service;

import com.practice.springbootdbexample.model.Employee;
import com.practice.springbootdbexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    protected EmployeeRepository employeeRepository;

    public Employee findByEmpId(Integer empId){
        Optional<Employee> optionalEmployee = Optional.ofNullable(employeeRepository.findOne(empId));
        return optionalEmployee.get();
    }

    public void save(Employee employee){
        employeeRepository.save(employee);
    }


}
