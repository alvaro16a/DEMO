package com.javacurso.demo.services;

import com.javacurso.demo.model.Role;
import com.javacurso.demo.repository.IRoleJpaRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    IRoleJpaRepository roleRepository;


    public List<Role> getRoles(){
        return roleRepository.findAll();
    }

    public Optional<Role> getRolesById( Long id){
        return roleRepository.findById(id);
    }
    
    public Role createRole(Role role){
        return roleRepository.save(role);
    }
    
    public ResponseEntity<Role> updateRoleById(Long id,Role role){
        Optional<Role> roleData = roleRepository.findById(id);
        
        if(roleData.isPresent()){
            Role _role=roleData.get();
            _role.setName(role.getName());
            roleRepository.save(_role);
            return new ResponseEntity<>(roleRepository.save(_role), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }

    public String deleteById( Long id){
        try {
            roleRepository.deleteById(id);
            return "role " + id + " was removed" ;
        } catch (Exception e) {
            return "rool could not be removed";
        }
    }

    
    
}
