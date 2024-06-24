package dev.obey.employee_registration.controller;

import dev.obey.employee_registration.domain.Employee;
import dev.obey.employee_registration.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/" )
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees", employeeService.getEmployees());
//        return  "index";
        //return findPaginated(1, model);
        return "home";
    }
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }
   @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/saveEmployee")
   public String saveEmployee(@ModelAttribute ("employee") Employee employee){
                employeeService.saveEmployee(employee);
                return  "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value="id") long id,Model model){
           Employee employee= employeeService.getEmployeeById(id);
           model.addAttribute("employee", employee);
           return  "update_employee";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id){
        employeeService.deleteById(id);
        return "redirect:/";
     }


//     @GetMapping("/page/{pageNo}")
//     public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model){
//        int pageSize =5;
//
//        Page<Employee> page= employeeService.findPaginated(pageNo, pageSize);
//        List<Employee> listEmployees = page.getContent();
//
//        model.addAttribute("currentPage", pageNo);
//        model.addAttribute("totalPages", page.getTotalPages());
//        model.addAttribute("totalItems", page.getTotalElements());
//        model.addAttribute("listEmployees", listEmployees);
//        return "index";
//     }

}
