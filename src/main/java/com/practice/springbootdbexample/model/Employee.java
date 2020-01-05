package com.practice.springbootdbexample.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    private int empId;
    private String empFirstName;
    private String empLastName;
    private Float salary;

}
