package com.javacurso.demo.services;
import com.javacurso.demo.model.Employee;
import com.javacurso.demo.model.Role;
import com.javacurso.demo.repository.IEmployeeJpaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeJpaRepository employeeRepository;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }
    
    public Optional<Employee> getEmployeeById( Long id){
        return employeeRepository.findById(id);
    }

    public String createEmployee(String firstName, String lastName, String employeeid, Role role){
        try {
			employeeRepository.save(new Employee(firstName,lastName, employeeid, role));
			return "Se Creo el usuario";
		}catch (Exception e) {
			return "No se pudo crear el usuario";
		}
    }


    /*public ResponseEntity<Employee> createEmployee(Employee employee){
        try {
			Employee _employee = employeeRepository.save(new Employee(employee.getFirstName(), employee.getLastName(), employee.getEmployeeid(),));
			return new ResponseEntity<>(_employee, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
    }

    /*
       
    public ResponseEntity<Project> updateProjectId(Long id,Project project){
        Optional<Project> projectData =projectRepository.findById(id);
        
        if(projectData.isPresent()){
            Project _project=projectData.get();
            _project.setName(project.getName());
            projectRepository.save(_project);
            return new ResponseEntity<>(projectRepository.save(_project), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }    
    }

    public String deleteById( Long id){
        try {
            projectRepository.deleteById(id);
            return "Project with id " + id + " was removed" ;
        } catch (Exception e) {
            return "project could not be removed";
        }
    }*/

}
