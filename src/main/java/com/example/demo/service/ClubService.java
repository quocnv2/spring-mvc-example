package com.example.demo.service;

import com.example.demo.dto.ClubDTO;
import com.example.demo.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDTO> findAllClub();
    Club saveClub(Club club);
}
