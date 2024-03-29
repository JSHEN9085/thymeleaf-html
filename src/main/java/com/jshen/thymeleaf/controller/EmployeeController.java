package com.jshen.thymeleaf.controller;

import com.jshen.thymeleaf.entity.Employee;
import com.jshen.thymeleaf.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        List<Employee> employees = employeeService.findAll();

        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employees/employee-form"; //return is followed by the file location(repository)
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){
        //get the employee from the service
        Employee employee = employeeService.findById(id);

        // set employee as model attribute to the form
        model.addAttribute("employee", employee);

        // send over to our form
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        //save the employee
        employeeService.save(employee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list"; //redirect to the specific web address, return is followed by the file location(repository)
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id){
        //delete the employee
        employeeService.deleteById(id);

        //redirect
        return "redirect:/employees/list";
    }

}
