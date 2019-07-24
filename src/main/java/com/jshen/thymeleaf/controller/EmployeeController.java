package com.jshen.thymeleaf.controller;

import com.jshen.thymeleaf.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    //load employees data
    List<Employee> employees;

    @PostConstruct
    private void loadData(){
        //create employee
        Employee employee1 = new Employee(1, "Lesila", "Andrew", "lesila.A@gmail.com");

        //create the list
        employees = new ArrayList<>();

        //add employee
        employees.add(employee1);
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        model.addAttribute("emplo yees", employees);
        return "list-employees";
    }
}
