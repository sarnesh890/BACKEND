
package com.example.eventora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.eventora.model.Registration;

@Repository
public interface RegistrationRepo extends JpaRepository<Registration,Long>{

    
} 
