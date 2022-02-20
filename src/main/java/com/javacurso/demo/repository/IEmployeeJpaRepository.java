package com.javacurso.demo.repository;

import com.javacurso.demo.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeJpaRepository extends JpaRepository<Employee,Long>{
    //select fields from employee where employeid='[param]'
    Employee findByEmployeeid(String employeeid);
}
