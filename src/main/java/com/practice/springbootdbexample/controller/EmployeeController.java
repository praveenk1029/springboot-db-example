package com.practice.springbootdbexample.controller;

import com.practice.springbootdbexample.model.Employee;
import com.practice.springbootdbexample.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/rest/employee")
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

    @GetMapping("/getEmployee/{empId}")
    @ApiOperation(value = "Pulls Employee Info", notes = "Search Employee by Employee Id!")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Employee not found"),
            @ApiResponse(code = 200, message = "Successfully retrieved Employee Info!!")
    })
    public Employee getEmployee(@PathVariable Integer empId) throws Exception {
        return employeeService.findByEmpId(empId);
    }

    @GetMapping("/")
    public String getEmployee() throws Exception {
        return "Employee service message";
    }

    @GetMapping("/getAllEmployees")
    @ApiOperation(value = "Gets all Employees Info", notes = "Retrieve all the Employees Info.")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Employee not found"),
            @ApiResponse(code = 200, message = "Successfully retrieved Employees Info!!")
    })
    public List<Employee> getAllEmployees() throws Exception {
        List<Employee> employeeList = employeeService.getAllEmployees();
        System.out.println("employeeList::MAIN:::"+employeeList);
        return employeeList;
    }

    @PostMapping(value = "/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @PutMapping(value = "/updateEmployee")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
    }

//    @DeleteMapping(value = "/deleteEmployee/{empId}")
//    public void deleteEmployee(@PathVariable Integer empId){
//        employeeService.deleteByEmpId(empId);
//    }
}
