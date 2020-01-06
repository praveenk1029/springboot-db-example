package com.practice.springbootdbexample.controller;

import com.practice.springbootdbexample.model.Employee;
import com.practice.springbootdbexample.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/employee")
@Api(value = "Employee Transactions", description = "Employee Transactions")
public class EmployeeController {

    @Autowired
    protected EmployeeService employeeService;

    @GetMapping("/getEmployee")
    @ApiOperation(value = "Pulls Employee Info", notes = "Department Info too")
    public String getEmployee(){
        Employee emp = employeeService.findByEmpId(2);
        return emp.getEmpFirstName()+" "+emp.getEmpLastName()+" "+emp.getDepartment().getDeptName();
    }

    @PostMapping(value = "/saveEmployee")
    public void saveEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
    }

    @PutMapping(value = "/updateEmployee")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
    }
}
