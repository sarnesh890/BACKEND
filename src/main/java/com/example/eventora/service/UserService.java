package com.example.eventora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eventora.model.Event;
import com.example.eventora.model.Users;
import com.example.eventora.repository.EventRepository;
import com.example.eventora.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EventRepository eventRepository;

    public Users addUser(Users user) {
        return userRepo.save(user);
    }

    public String getUser(String userName, String password) {
        Users user = userRepo.findByUserNameAndPassword(userName, password);
        if (user != null) {
            return "User authenticated successfully";
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    public List<Event> getUserEvents(Long eventId) {
        // Assuming you have a way to fetch user events, e.g., through a join or a separate repository method
        return eventRepository.findByEventId(eventId);
    }
}
