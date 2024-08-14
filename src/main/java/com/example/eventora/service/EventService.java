
package com.example.eventora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eventora.model.Event;
import com.example.eventora.repository.EventRepository;



@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getPendingEvents() {
        return eventRepository.findByStatus("PENDING");
    }

    public void approveEvent(Long id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        event.setStatus("APPROVED");
        eventRepository.save(event);
    }
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public void rejectEvent(Long id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        event.setStatus("REJECTED");
        eventRepository.save(event);
    }
    public void updateEventStatus(Long eventId, String status) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            event.setStatus(status);
            eventRepository.save(event);
        }
    }

    public List<Event> getAllApprovedEvents() {
        return eventRepository.findByStatus("approved");
    }

    public Event getById(Long eventId)
    {
        return eventRepository.findById(eventId).orElse(null);
    }
    public void deleteEvent(Long id) {
        Event event = getEventById(id);
        if (event != null) {
            eventRepository.delete(event);
        }
    }      
   }