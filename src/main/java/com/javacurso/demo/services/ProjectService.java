package com.javacurso.demo.services;

import com.javacurso.demo.repository.IProjectJpaRepository;

import org.springframework.stereotype.Service;
import com.javacurso.demo.model.Project;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    IProjectJpaRepository projectRepository;

    public List<Project> getProjects(){
        return projectRepository.findAll();
    }
    
    public Optional<Project> getProjectById( Long id){
        return projectRepository.findById(id);
    }
}
