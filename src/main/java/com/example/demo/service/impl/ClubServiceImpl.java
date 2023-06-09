package com.example.demo.service.impl;

import com.example.demo.dto.ClubDTO;
import com.example.demo.models.Club;
import com.example.demo.repository.ClubRepository;
import com.example.demo.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDTO> findAllClub() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }

    @Override
    public ClubDTO findAllClubByID(long clubId) {
        Club club = clubRepository.findById(clubId).get();
        return mapToClubDto(club);

    }

    @Override
    public void updateClub(ClubDTO clubDTO) {
        Club club = mapToClub(clubDTO);
        clubRepository.save(club);
    }

    @Override
    public void delete(Long clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public List<ClubDTO> searchClub(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }

    private Club mapToClub(ClubDTO club) {
        Club clubDTO = Club.builder().id(club.getId()).title(club.getTitle()).photoURL(club.getPhotoURL()).content(club.getContent()).createdOn(club.getCreatedOn()).updatedOn(club.getUpdatedOn()).build();
        return clubDTO;
    }

    private ClubDTO mapToClubDto(Club club) {
        ClubDTO clubDTO = ClubDTO.builder().id(club.getId()).title(club.getTitle()).photoURL(club.getPhotoURL()).content(club.getContent()).createdOn(club.getCreatedOn()).updatedOn(club.getUpdatedOn()).build();
        return clubDTO;
    }


}
