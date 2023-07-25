package com.learning.springdatajdbcdemo.controller;

import com.learning.springdatajdbcdemo.entity.Employee;
import com.learning.springdatajdbcdemo.repositroy.EmployeeRepos;
import com.learning.springdatajdbcdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService ;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired


    @GetMapping("/count")
    public long countEmp()
    {
        return employeeService.count();
    }
    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id )
    {
        return employeeService.findById(id);
    }

    @GetMapping("")
    public Iterable<Employee> findAll()
    {
        return  employeeService.findAll();
    }
    @PostMapping("/insert")
    public void insert(@RequestBody Employee employee)
    {
        employeeService.insert(employee);
    }

    @PutMapping("")
    public void updateEmp(@RequestBody Employee employee)
    {
        employeeService.update(employee);
    }

    @DeleteMapping("")
    public void deleteEmp(@RequestParam long id)
    {
        employeeService.delete(id);
    }



    @GetMapping("/filter/{name}")
    public List<Employee> findByName(@PathVariable String name)
    {
        return employeeService.findByName(name);
    }



    @GetMapping("/filter")
    public List<Employee> findByNameAndSalary(@RequestParam String name ,  @RequestParam double salary)
    {
        return employeeService.findByNameAndSalary(name, salary);
    }

    @PutMapping("/salary")
    public int editEmployeeSalary(@RequestParam("salary") double sal , @RequestParam("id") long id)
    {
        return employeeService.updateSalary(sal , id );
    }

}
