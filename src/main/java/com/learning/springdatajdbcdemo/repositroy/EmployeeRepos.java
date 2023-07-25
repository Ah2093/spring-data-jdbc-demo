package com.learning.springdatajdbcdemo.repositroy;

import com.learning.springdatajdbcdemo.entity.Employee;
import com.learning.springdatajdbcdemo.mapper.EmployeeMapper;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepos extends CrudRepository<Employee , Long> {

    List<Employee> findByName(String name);

    @Query(value = "select  * from employees where name= :passedName and salary =  :passedSalary",rowMapperClass = EmployeeMapper.class)
    List<Employee> findByNameAndSalary(@Param("passedName") String name , @Param("passedSalary")double salary);


    List<Employee> findByNameStartingWithAndSalary(String name, double salary);


    @Modifying
    @Query(value = "update employees set salary = :salary where id= :id")
    int  updateSalary(double salary , Long id);
}
