// package com.example.eventora.controller;

// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.eventora.model.Registration;
// import com.example.eventora.service.EmailService;
// import com.example.eventora.service.RegistrationService;

// import com.example.eventora.dto.UserDto;

// import jakarta.validation.Valid;


// @RestController
// @RequestMapping("/register")
// @CrossOrigin(origins = "http://localhost:3000")
// public class RegistrationController {
    
//     @Autowired
//     private RegistrationService registerService;

//      @PostMapping("/add")
//     public ResponseEntity<?> register(@Valid @RequestBody Registration registration, BindingResult result) {
//         if (result.hasErrors()) {
//             return ResponseEntity.badRequest().body(result.getAllErrors());
//         }

//         try {
//             Registration savedRegistration = registerService.saveRegistration(registration);
//             return ResponseEntity.ok(savedRegistration);
//         } catch (Exception e) {
//             Map<String, String> errorResponse = new HashMap<>();
//             errorResponse.put("error", "An unexpected error occurred. Please try again later.");
//             return ResponseEntity.status(500).body(errorResponse);
//         }
//     }

//     @Autowired
//     private EmailService emailService;

//     @PostMapping("/add") // Maps to /register/add
//     public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
//         // Your existing logic to save the user in the database

//         // Send the email
//         emailService.sendRegistrationEmail(userDto.getEmail(), 
//             "Event Registration Successful", 
//             "Dear " + userDto.getName() + ",\n\n" +
//             "Thank you for registering for the event " + userDto.getEventName() + ".\n" +
//             "We look forward to your participation.\n\n" +
//             "Best regards,\nEvent Management Team");

//         return ResponseEntity.ok("Registration successful");
//     }
// }
package com.example.eventora.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eventora.model.Registration;
import com.example.eventora.service.EmailService;
import com.example.eventora.service.RegistrationService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "http://localhost:3000")
public class RegistrationController {
    
    @Autowired
    private RegistrationService registerService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/add")
    public ResponseEntity<?> register(@Valid @RequestBody Registration registration, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        try {
            // Save the registration in the database
            Registration savedRegistration = registerService.saveRegistration(registration);

            // Send a confirmation email
            emailService.sendRegistrationEmail(
                registration.getEmail(), 
                "Event Registration Successful", 
                "Dear " + registration.getName() + ",\n\n" +
                "Thank you for registering for the event " + registration.getEventName() + ".\n" +
                "We look forward to your participation.\n\n" +
                "Best regards,\nEvent Management Team");

            return ResponseEntity.ok(savedRegistration);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "An unexpected error occurred. Please try again later.");
            return ResponseEntity.status(500).body(errorResponse);
        }
    }
}
