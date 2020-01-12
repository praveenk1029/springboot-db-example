package com.practice.springbootdbexample.service;

import com.practice.springbootdbexample.model.Employee;
import com.practice.springbootdbexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    protected EmployeeRepository employeeRepository;

    public Employee findByEmpId(Integer empId) throws Exception {
        Optional<Employee> optionalEmployee //= Optional.ofNullable(employeeRepository.findOne(empId));
            = employeeRepository.findByEmpId(empId);
        optionalEmployee.orElseThrow(()->new Exception("Employee not found!!!"));
        return optionalEmployee.get();
    }

    public List<Employee> getAllEmployees() throws Exception{
       return employeeRepository.findAll();
    }

    public void save(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteByEmpId(Integer empId){
        employeeRepository.delete(empId);
    }
}
