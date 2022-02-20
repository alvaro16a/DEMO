package com.javacurso.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.javacurso.demo.model.Employee;
import com.javacurso.demo.repository.IEmployeeJpaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeejpaRepositoyTest {
    @Autowired
    private IEmployeeJpaRepository repo;

    @Test
    public void saveEmployee(){
        Employee jhon = new Employee("Jhon", "lasame", "employeeid");
        Employee claire = new Employee("Claire", "lastName", "employ");

        repo.save(jhon);
        repo.save(claire);
        

        repo.flush();

        assertEquals(2, repo.findAll().size());
    }
    
}
