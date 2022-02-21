package com.javacurso.demo.services;
import com.javacurso.demo.model.Project;
import com.javacurso.demo.repository.IProjectJpaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    IProjectJpaRepository projectRepository;

    public List<Project> getProjects(){
        return projectRepository.findAll();
    }
    
    public Optional<Project> getProjectById( Long id){
        return projectRepository.findById(id);
    }

    public Project createProject(Project project){
        return projectRepository.save(project);
    }

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
    }

}
