package com.example.eventora.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eventId;

    private String eventName;
    private String startDate;
    private String endDate;
    private String location;
    private String mapLink;


    
    @Lob
    @Column(name = "event_image", columnDefinition = "LONGTEXT")
    private String eventImage;

    @Lob
    @Column(name = "event_poster", columnDefinition = "LONGTEXT")
    private String eventPoster;

    private String activities;
    private String registrationDeadline;
    private String registrationFees;
    private String contactDetails;
    private String capacity;
    private String schedule;
    private String guest;
    private String specialRequirements;
    private String socialMediaLinks;
    private String eventCategory;
    private String organizers;
    private String sponsors;
    private String ticketingInformation;
    private String accessibilityInformation;
    private String parkingInformation;
    private String accommodationInformation;
    private String healthAndSafetyGuidelines;

    private String status; // Add this field to track the status of the event
}
