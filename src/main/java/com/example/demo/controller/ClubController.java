package com.example.demo.controller;

import com.example.demo.dto.ClubDTO;
import com.example.demo.models.Club;
import com.example.demo.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClubController {
    private ClubService clubService;

    @Autowired

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String listClubs(Model model) {
        List<ClubDTO> clubs = clubService.findAllClub();
        model.addAttribute("clubs", clubs);
        return "club-list";
    }

    @GetMapping("/clubs/new")
    public String createClubsForm(Model model) {
        Club clubs = new Club();
        model.addAttribute("clubs", clubs);
        return "club-create";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@ModelAttribute("club") Club club) {
        clubService.saveClub(club);
        return "redirect:/clubs";
    }

}
