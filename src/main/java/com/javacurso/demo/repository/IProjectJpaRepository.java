package com.javacurso.demo.repository;
import java.util.List;
import java.util.Optional;
import com.javacurso.demo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectJpaRepository extends JpaRepository<Project,Long> {
    
    Optional<Project> findById(Long id);
    List<Project> findByName(String name);
    List<Project> findAll();

}
