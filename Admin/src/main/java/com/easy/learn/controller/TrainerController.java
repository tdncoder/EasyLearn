package com.easy.learn.controller;

import com.easy.learn.callApi.TrainerService;
import com.easy.learn.dto.Manager.ManagerDTO;
import com.easy.learn.dto.TrainerMember.Trainer;
import com.easy.learn.dto.TrainerMember.TrainerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trainer")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @GetMapping("/add")
    public String showAddTrainerMemberPage(Model model) {
        model.addAttribute("trainerDTO", new TrainerDTO());
        return "pages/admin/member_managements/trainer_add";
    }
    @GetMapping("/list")
    public String getAllTrainerMember(Model model) {
        model.addAttribute("trainerList", trainerService.getAllTrainer());
        model.addAttribute("trainerDTO", new TrainerDTO());
        return "/pages/admin/member_managements/view_trainer";
    }
    @PostMapping("/save")
    public String saveTrainerMember(@ModelAttribute("trainerDTO") TrainerDTO trainerDTO) {
        if (trainerDTO.getId() == null) {

            trainerService.create(trainerDTO);
        } else {

            trainerService.update(trainerDTO);

        }
        return "redirect:/trainer/list";
    }
    @GetMapping("/edit/{id}")
    public String updateTrainerMember(@PathVariable Long id, Model model) {
        Trainer trainer = trainerService.getById(id);
        model.addAttribute("trainerDTO", trainer);
        return "pages/admin/member_managements/edit_trainer";
    }

    @GetMapping("/delete/{id}")
    public String deleteTrainerMember(@PathVariable Long id) {
        trainerService.delete(id);
        return "redirect:/trainer/list";
    }
}
