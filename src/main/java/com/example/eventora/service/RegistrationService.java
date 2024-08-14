// 
package com.example.eventora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eventora.model.Registration;
import com.example.eventora.repository.RegistrationRepo;

import jakarta.validation.Valid;

@Service
public class RegistrationService {
    
    @Autowired
    private RegistrationRepo registerRepo;

    public Registration saveRegistration(@Valid Registration registration) {
        return registerRepo.save(registration);
    }
}