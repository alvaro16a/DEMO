package com.javacurso.demo.repository;
import java.util.List;
import java.util.Optional;
import com.javacurso.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleJpaRepository extends JpaRepository<Role,Long>{

    Optional<Role> findById(Long id);
    List<Role> findByName(String name);
    List<Role> findAll();

}
