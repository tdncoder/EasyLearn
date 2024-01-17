package com.easy.learn.web.controller;


import com.easy.learn.web.callApi.TrainerCallService;
import com.easy.learn.web.consts.UrlPath;
import com.easy.learn.web.dto.trainer.Trainer;
import com.easy.learn.web.dto.trainer.TrainerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
//@RequestMapping("/trainer")
public class TrainerController {
    @Autowired
    TrainerCallService service;


    @GetMapping(UrlPath.GET_ALL_TRAINER)
    public String showAllTrainer(Model model) {
        List<Trainer> trainers = service.getAll();
        model.addAttribute("listTrainer", trainers);
        return "trainer";
    }

    @GetMapping("/trainer/new")
    public String showForm(Model model) {
        model.addAttribute("trainerDTO", new TrainerDTO());
        model.addAttribute("pageTitle", "Add new trainer");
        return "add_form";}


    @PostMapping("/trainer/save")
    public String saveTrainerSalaryPaid( @ModelAttribute("trainerDTO") TrainerDTO trainerDTO) {
        service.createTrainer(trainerDTO);
        return "redirect:/trainer";
    }

    @GetMapping("/trainer/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
            Trainer trainer = service.getTrainerById(id);
            model.addAttribute("trainerDTO", trainer);
            model.addAttribute("pageTitle", "Edit Trainer (ID: "+ id +")");
            return "add_form";
        } catch (Exception e) {
            ra.addFlashAttribute("message", "The trainer not found");
            return "redirect:/trainer";
        }
    }

    @GetMapping("/trainer/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,  RedirectAttributes ra) {
        try {
            service.deleteTrainer(id);
            ra.addFlashAttribute("message", "The trainer ID " + id + " has been deleted");
        } catch (Exception e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/trainer";
    }
}
