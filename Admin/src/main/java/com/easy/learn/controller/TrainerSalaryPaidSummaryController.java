package com.easy.learn.controller;

import com.easy.learn.callApi.TrainerSalaryPaidSummaryService;
import com.easy.learn.dto.TrainerSalaryPaidSummary.TrainerSalaryPaidSummary;
import com.easy.learn.dto.TrainerSalaryPaidSummary.TrainerSalaryPaidSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trainersalarysummary")
public class TrainerSalaryPaidSummaryController {

    @Autowired
    private TrainerSalaryPaidSummaryService trainerSalaryService;

    @GetMapping("/list")
    public String getAllTrainerSalaryPaid(Model model) {
        model.addAttribute("trainerSalaryPaidList", trainerSalaryService.getAllTrainerSalaryPaid());
        model.addAttribute("trainerSalaryPaidDTO", new TrainerSalaryPaidSummaryDTO()); // For form binding
        return "pages/finance_management/list";
    }

    @PostMapping("/save")
    public String saveTrainerSalaryPaid(@ModelAttribute("trainerSalaryPaidDTO") TrainerSalaryPaidSummaryDTO trainerSalaryPaidDTO ) {

        if (trainerSalaryPaidDTO.getId() == null) {
            trainerSalaryService.createTrainerSalaryPaid(trainerSalaryPaidDTO);
        } else {

            trainerSalaryService.updateTrainerSalaryPaid(trainerSalaryPaidDTO);
        }

        return "redirect:/trainersalarysummary/list";
    }

    @GetMapping("/view/{id}")
    public String viewTrainerSalaryPaid(@PathVariable Long id, Model model) {
        TrainerSalaryPaidSummary trainerSalaryPaid = trainerSalaryService.getTrainerSalaryPaidById(id);
        model.addAttribute("trainerSalaryPaidDTO", trainerSalaryPaid);

        return "pages/finance_management/view";
    }

    @GetMapping("/edit/{id}")
    //@ResponseBody
    public String editTrainerSalaryPaid(@PathVariable Long id, Model model) {
        TrainerSalaryPaidSummary trainerSalaryPaid = trainerSalaryService.getTrainerSalaryPaidById(id);
        model.addAttribute("trainerSalaryPaidDTO", trainerSalaryPaid);
        return "/pages/finance_management/edit1";
        //return trainerSalaryService.getTrainerSalaryPaidById(id);

    }


    @GetMapping("/delete/{id}")
    public String deleteTrainerSalaryPaid(@PathVariable Long id) {
        trainerSalaryService.deleteTrainerSalaryPaid(id);
        return "redirect:/trainersalarysummary/list";
    }


}
