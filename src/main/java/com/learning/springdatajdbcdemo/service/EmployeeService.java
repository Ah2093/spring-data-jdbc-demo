package com.learning.springdatajdbcdemo.service;

import com.learning.springdatajdbcdemo.entity.Employee;
import com.learning.springdatajdbcdemo.repositroy.EmployeeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepos employeeRepos ;
    @Autowired
    public EmployeeService(EmployeeRepos employeeRepos) {
        this.employeeRepos = employeeRepos;
    }


    public long count()
    {
        return employeeRepos.count();
    }
    public Employee findById( Long id )
    {
        return employeeRepos.findById(id).get();
    }

    public Iterable<Employee> findAll()
    {
        return  employeeRepos.findAll();
    }

    public List<Employee> findByName(String name){
        return employeeRepos.findByName(name);
    }

    public Employee findByEmployeeId(long id)
    {
        return employeeRepos.findById(id).get();
    }
    public List<Employee> findByNameAndSalary(String name, double salary)
    {
        return employeeRepos.findByNameAndSalary(name , salary);
    }
    public List<Employee> findByNameStartingWithAndSalary(String name , double salary)
    {
        return employeeRepos.findByNameStartingWithAndSalary(name , salary);
    }

    public int  updateSalary(double salary , Long id)
    {
        return employeeRepos.updateSalary(salary,id);
    }
    public void insert( Employee employee)
    {
        employeeRepos.save(employee);
    }

    public void update( Employee employee)
    {
        employeeRepos.save(employee);
    }

    public void delete( long id)
    {
        employeeRepos.deleteById(id);
    }

}
