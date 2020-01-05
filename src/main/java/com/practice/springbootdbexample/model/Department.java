package com.practice.springbootdbexample.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

    private int deptId;
    private String deptName;
}
