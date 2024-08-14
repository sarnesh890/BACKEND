package com.example.eventora.controller;

import com.example.eventora.model.Event;
import com.example.eventora.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "http://localhost:3000")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/add")
public ResponseEntity<Event> createEvent(@RequestBody Event event) {
    event.setStatus("pending"); // Ensure the status is set to pending
    Event savedEvent = eventService.saveEvent(event);
    return ResponseEntity.ok(savedEvent);
}


    @GetMapping("/admin/pending")
    public ResponseEntity<List<Event>> getPendingEvents() {
        List<Event> events = eventService.getPendingEvents();
        return ResponseEntity.ok(events);
    }

    @PostMapping("/admin/{id}/approve")
    public ResponseEntity<String> approveEvent(@PathVariable Long id) {
        try {
            Event event = eventService.getEventById(id);
            if (event != null) {
                event.setStatus("APPROVED");
                eventService.saveEvent(event);
                return ResponseEntity.ok("Event approved.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error approving event.");
        }
    }

    @PostMapping("/admin/{id}/reject")
    public ResponseEntity<String> rejectEvent(@PathVariable Long id) {
        try {
            eventService.rejectEvent(id);
            return ResponseEntity.ok("Event rejected.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error rejecting event.");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllApprovedEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<Event> getEventById(@PathVariable Long eventId) {
        try {
            Event event = eventService.getEventById(eventId);
            if (event != null) {
                return ResponseEntity.ok(event);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @DeleteMapping("/admin/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        try {
            eventService.deleteEvent(id);
            return ResponseEntity.ok("Event deleted.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting event.");
        }
    }
    
}