package dev.obey.employee_registration.controller;

import dev.obey.employee_registration.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/" )
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees", employeeService.getEmployees());
        return  "index";
    }
}
