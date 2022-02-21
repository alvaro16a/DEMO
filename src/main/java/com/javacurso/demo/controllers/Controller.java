package com.javacurso.demo.controllers;

import java.util.*;

import com.javacurso.demo.model.Employee;
import com.javacurso.demo.model.Project;
import com.javacurso.demo.model.Role;
import com.javacurso.demo.services.EmployeeService;
import com.javacurso.demo.services.ProjectService;
import com.javacurso.demo.services.RoleService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")

public class Controller {

    @Autowired
    RoleService roleService;

    @Autowired
    ProjectService projectService;

    @Autowired
    EmployeeService employeeService;

    //////////////////////////////////////////////////////////////////////////////////////
    //Role////
    //////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/role")//permite ver los roles existentes
    public List<Role> getRoles(){
        return roleService.getRoles();
    }

    @GetMapping("/role/{id}")//se obtiene un rol por su id
    public Optional<Role> getRolesById(@PathVariable("id") Long id){
        return this.roleService.getRolesById(id);
    }

    @PostMapping("/role")//Crea un nuevo rol
    public Role createRole(@RequestBody Role role){
        return this.roleService.createRole(role);
    }

    @PutMapping("/role/{id}")
    public ResponseEntity<Role> updateRoleById(@PathVariable("id") long id, @RequestBody Role role){
        return this.roleService.updateRoleById(id,role);
    }

    @DeleteMapping(path = "/role/{id}" )//al recibir una solicitud delete elimina el usuario con una determinada id
    public String deleteRoleById(@PathVariable("id") Long id){
        return roleService.deleteById(id);
    }


    //////////////////////////////////////////////////////////////////////////////////////
    //Project////
    //////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/project")//permite ver los proyectos existentes
    public List<Project> getProjects(){
        return projectService.getProjects();
    }

    @GetMapping("/project/{id}")//se obtiene un proyecto por su id
    public Optional<Project> getProjectById(@PathVariable("id") Long id){
        return this.projectService.getProjectById(id);
    }

    @PostMapping("/project")//Crea un nuevo rol
    public Project createProject(@RequestBody Project project){
        return this.projectService.createProject(project);
    }

    @PutMapping("/project/{id}")
    public ResponseEntity<Project> updateProjectById(@PathVariable("id") long id, @RequestBody Project project){
        return this.projectService.updateProjectId(id, project);
    }

    @DeleteMapping(path = "/project/{id}" )//al recibir una solicitud delete elimina el projecto con una determinada id
    public String deleteProjectById(@PathVariable("id") Long id){
        return projectService.deleteById(id);
    }

    //////////////////////////////////////////////////////////////////////////////////////
    //Employee////
    /////////////////////////////////////////////////////////////////////////////////////


    @GetMapping("/employee")//permite ver los proyectos existentes
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employee/{id}")//se obtiene un proyecto por su id
    public Optional<Employee> getEmployeeById(@PathVariable("id") Long id){
        return this.employeeService.getEmployeeById(id);
    }

    @PostMapping("/employee")//Crea un nuevo employee
    public String createEmployee(@RequestBody Employee employee){
        if(roleService.finRoleByName(employee.getRole().getName())== null){
            return "No existe el rool";
        }else{
            return employeeService.createEmployee(employee.getFirstName(),employee.getLastName(),employee.getEmployeeid(),roleService.finRoleByName(employee.getRole().getName()));
            
        }

    }

}
