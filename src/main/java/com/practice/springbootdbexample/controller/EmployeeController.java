package com.practice.springbootdbexample.controller;

import com.practice.springbootdbexample.model.Employee;
import com.practice.springbootdbexample.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/employee")
@Api(value = "Employee Transactions", description = "Manage Employee")
public class EmployeeController {

    @Autowired
    protected EmployeeService employeeService;

    /*@GetMapping("/getEmployee1/{empId}")
    @ApiOperation(value = "Pulls Employee Info", notes = "Department Info too")
    public String getEmployee1(@PathVariable Integer empId) throws Exception {
        Employee emp = employeeService.findByEmpId(empId);
        return emp.getEmpFirstName()+" "+emp.getEmpLastName()+" "+emp.getDepartment().getDeptName();
    }*/

    @GetMapping("/rest/employee/getEmployee/{empId}")
    @ApiOperation(value = "Pulls Employee Info", notes = "Search Employee!")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Employee not found"),
            @ApiResponse(code = 200, message = "Success Message:200")
    })
    public Employee getEmployee(@PathVariable Integer empId) throws Exception {
        return employeeService.findByEmpId(empId);
    }

    @PostMapping(value = "/rest/employee/saveEmployee")
    public void saveEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
    }

    @PutMapping(value = "/rest/employee/updateEmployee")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
    }
}
