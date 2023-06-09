package com.example.demo.service.impl;

import com.example.demo.dto.EventDTO;
import com.example.demo.models.Club;
import com.example.demo.models.Event;
import com.example.demo.repository.ClubRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDTO eventDTO) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDTO);
        event.setClub(club);
        eventRepository.save(event);

    }

    private Event mapToEvent(EventDTO eventDTO) {
        return Event.builder().id(eventDTO.getId()).name(eventDTO.getName()).startTime(eventDTO.getStartTime()).endTime(eventDTO.getEndTime()).type(eventDTO.getType()).photoURL(eventDTO.getPhotoURL()).createdOn(eventDTO.getCreatedOn()).updatedOn(eventDTO.getUpdatedOn()).build();
    }
}
