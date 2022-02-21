package com.javacurso.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.javacurso.demo.model.Employee;
import com.javacurso.demo.model.Project;
import com.javacurso.demo.model.Role;
import com.javacurso.demo.repository.IEmployeeJpaRepository;
import com.javacurso.demo.repository.IProjectJpaRepository;
import com.javacurso.demo.repository.IRoleJpaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EmployeejpaRepositoyTest {
    @Autowired
    private IEmployeeJpaRepository repoEmpl;

    @Autowired
    private IRoleJpaRepository repoRole ;

    @Autowired
    private IProjectJpaRepository repoProj;

    @Test
    public void saveEmployee(){

        Role admin = new Role("ROLE_ADMIN");
        Role dev = new Role("ROLE_DEV");

        admin = repoRole.save(admin);
        dev   = repoRole.save(dev);

        Project proj1 = new Project("proj1");
        Project proj2 = new Project("proj2");
        Project proj3 = new Project("proj3");

        proj1 = repoProj.save(proj1);
        proj2 = repoProj.save(proj2);
        proj3 = repoProj.save(proj3);

        Employee jhon = new Employee("Jhon", "lasame", "empl123",dev);
        Employee claire = new Employee("Claire", "lastName", "empl124",admin);

        jhon.getProjects().add(proj1);
        jhon.getProjects().add(proj2);

        claire.getProjects().add(proj1);
        claire.getProjects().add(proj2);
        claire.getProjects().add(proj3);

       repoEmpl.save(jhon);
       repoEmpl.save(claire);

       repoEmpl.flush();

       Employee emp124 = repoEmpl.findByEmployeeid("empl124");
       assertEquals("Claire", emp124.getFirstName());
       assertEquals(2, repoEmpl.findAll().size());
       assertEquals(admin, emp124.getRole());
        
    }
    
}
