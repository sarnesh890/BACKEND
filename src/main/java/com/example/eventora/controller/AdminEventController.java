// package com.example.eventora.controller;

// import java.util.List;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.beans.factory.annotation.Autowired;

// import com.example.eventora.model.Event;
// import com.example.eventora.service.EventService;

// @RestController
// @RequestMapping("/api/admin/events")
// public class AdminEventController {

//     @Autowired
//     private EventService eventService;

//     @GetMapping
//     public List<Event> getPendingEvents() {
//         return eventService.getPendingEvents();
//     }

//     @PostMapping("/{id}/approve")
//     public ResponseEntity<String> approveEvent(@PathVariable Long id) {
//         eventService.approveEvent(id);
//         return ResponseEntity.ok("Event approved.");
//     }

//     @PostMapping("/{id}/reject")
//     public ResponseEntity<String> rejectEvent(@PathVariable Long id) {
//         eventService.rejectEvent(id);
//         return ResponseEntity.ok("Event rejected.");
//     }
// }

