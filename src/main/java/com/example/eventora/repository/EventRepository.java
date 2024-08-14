package com.example.eventora.repository;

import com.example.eventora.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByStatus(String status);
    List<Event> findByEventId(Long eventId); // Consider removing if not needed
}

