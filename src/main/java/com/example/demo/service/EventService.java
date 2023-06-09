package com.example.demo.service;

import com.example.demo.dto.EventDTO;

public interface EventService {
    void createEvent(Long clubId, EventDTO eventDTO);
}
