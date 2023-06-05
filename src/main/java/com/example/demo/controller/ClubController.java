package com.example.demo.controller;

import com.example.demo.dto.ClubDTO;
import com.example.demo.models.Club;
import com.example.demo.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/clubs/{clubId}/edit")
    public String editClub(@PathVariable("clubId") long clubId, Model model) {
        ClubDTO club = clubService.findAllClubByID(clubId);
        model.addAttribute("club", club);
        return "club-edit";
    }

    @PostMapping("/clubs/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") Long clubId, @ModelAttribute("club") ClubDTO clubDTO, BindingResult result, Model model) {
        clubDTO.setId(clubId);
        clubService.updateClub(clubDTO);
        return "redirect:/clubs";

    }


}
