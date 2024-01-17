package com.easy.learn.controller;

import com.easy.learn.callApi.JasperReportService;
import com.easy.learn.callApi.TrainerSalaryPaidService;
import com.easy.learn.callApi.TrainerService;
import com.easy.learn.dto.TrainerMember.Trainer;
import com.easy.learn.dto.TrainerSalaryPaid.ResponseMessage;
import com.easy.learn.dto.TrainerSalaryPaid.TrainerSalaryPaid;
import com.easy.learn.dto.TrainerSalaryPaid.TrainerSalaryPaidDTO;
import com.easy.learn.dto.TrainerSalaryPaidSummary.TrainerSalaryPaidSummary;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/trainer-salary")
public class TrainerSalaryPaidController {

    @Autowired
    private TrainerSalaryPaidService trainerSalaryPaidService;

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private JasperReportService reportService;


    public TrainerSalaryPaidController(JasperReportService reportService, TrainerSalaryPaidService trainerSalaryPaidService) {
        this.reportService = reportService;
        this.trainerSalaryPaidService = trainerSalaryPaidService;
    }

    @GetMapping("/downloadReport")
    public ResponseEntity<Resource> downloadReport(@RequestParam String format) {
        try {
            List<TrainerSalaryPaid> trainerSalaries = trainerSalaryPaidService.getAllTrainerSalaryPaid();
            byte[] reportData = reportService.generateTrainerSalaryPaidReport(trainerSalaries, format);
            System.out.println(reportData);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=TrainerSalaryPaidReport." + format);

            MediaType mediaType = getMediaTypeForFormat(format);
            ByteArrayResource resource = new ByteArrayResource(reportData);
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(mediaType)
                    .body(resource);
        } catch (JRException | IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    private MediaType getMediaTypeForFormat(String format) {
        switch (format.toLowerCase()) {
            case "pdf":
                return MediaType.APPLICATION_PDF;
            case "excel":
                return MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            case "csv":
                return MediaType.parseMediaType("text/csv");
            default:
                throw new IllegalArgumentException("Invalid media type");
        }
    }

    @GetMapping("")
    public String listTrainerSalaries(Model model) {
        List<Trainer> listTrainer = trainerService.getAllTrainerotSalary();
        System.out.println("Trainers: " + listTrainer);
        model.addAttribute("trainerSalaries", trainerSalaryPaidService.getAllTrainerSalaryPaid());
        model.addAttribute("trainerSalary", new TrainerSalaryPaid());
        model.addAttribute("trainers", listTrainer);
        //return "/pages/admin/trainersalarypaid/list";
        return "/pages/admin/trainersalarypaid/trainersalarypaid";
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TrainerSalaryPaid> getTrainerSalary(@PathVariable Long id) {
        // Fetch the salary details from the service
        TrainerSalaryPaid trainerSalaryPaid = trainerSalaryPaidService.getTrainerSalaryPaidById(id);

        if (trainerSalaryPaid != null) {
            return ResponseEntity.ok(trainerSalaryPaid);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("edit/{id}")
    @ResponseBody
    public TrainerSalaryPaid getTrainerSalaryPaid(@PathVariable Long id) {
        return trainerSalaryPaidService.getTrainerSalaryPaidById(id); // Trả về null hoặc xử lý lỗi nếu không tìm thấy
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseMessage> saveTrainerSalary(@ModelAttribute TrainerSalaryPaidDTO trainerSalary) {
        ResponseMessage responseMessage;
        if (trainerSalary.getId() == null) {
            TrainerSalaryPaid savedSalary = trainerSalaryPaidService.createTrainerSalaryPaid(trainerSalary);
            if (savedSalary != null) {
                responseMessage = new ResponseMessage("success", "Trainer Salary Saved Successfully");
            } else {
                responseMessage = new ResponseMessage("error", "Error Saving Trainer Salary");
            }
        } else {
            trainerSalary.setTrainerId(trainerSalary.getTrainerId());
            TrainerSalaryPaid updateSalary = trainerSalaryPaidService.updateTrainerSalaryPaid(trainerSalary);

            if (updateSalary != null) {
                responseMessage = new ResponseMessage("success", "Trainer Salary Saved Successfully");
            } else {
                responseMessage = new ResponseMessage("error", "Error Saving Trainer Salary");
            }
        }
        return ResponseEntity.ok(responseMessage);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseMessage> deleteTrainerSalary(@PathVariable Long id) {
        try {
            trainerSalaryPaidService.deleteTrainerSalaryPaid(id);
            return ResponseEntity.ok(new ResponseMessage("success", "Trainer Salary Deleted Successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseMessage("error", "Error Deleting Trainer Salary"));
        }
    }


}