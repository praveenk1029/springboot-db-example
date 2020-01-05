package com.practice.springbootdbexample.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
@Api(value = "Spring Database Authentication Resource", description = "Initiates the DB Authentication & Authorization")
public class HelloController {

    @ApiOperation(value = "Displays secured message")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/secured/display")
    public String display(){
        return "Database Secured resource....";
    }

    @ApiOperation(value = "Shows unsecured messsage")
    @GetMapping("/unsecured/show")
    public String show(){
        return "Unsecured message....";
    }

    @ApiOperation(value = "Populates some data")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "This is 100 Message"),
            @ApiResponse(code = 200, message = "Success Message:200")
    })
    @GetMapping("/populate")
    public String populate(){
        return "Populate Data....";
    }
}
