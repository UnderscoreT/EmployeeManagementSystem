package dev.obey.employee_registration.controller;

import dev.obey.employee_registration.domain.Employee;
import dev.obey.employee_registration.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }
   @PostMapping("/saveEmployee")
   public String saveEmployee(@ModelAttribute ("employee") Employee employee){
                employeeService.saveEmployee(employee);
                return  "redirect:/";
    }

}
