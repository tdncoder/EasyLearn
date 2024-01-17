package com.easy.learn.controller;

import com.easy.learn.callApi.StudentService;
import com.easy.learn.dto.Student.Student;
import com.easy.learn.dto.Student.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/add")
    public String showAddStudentPage(Model model) {
        model.addAttribute("studentDTO", new StudentDTO());
        return "pages/admin/member_managements/student_add";
    }
    @GetMapping("/list")
    public String getAllStudent(Model model) {
        model.addAttribute("studentList", studentService.getAllStudent());
        model.addAttribute("studentDTO", new StudentDTO());
        return "/pages/admin/member_managements/view_student";
    }
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("studentDTO") StudentDTO studentDTO ) {
        if (studentDTO.getId() == null) {

            studentService.create(studentDTO);
        } else {

            studentService.update(studentDTO);

        }
        return "redirect:/student/list";
    }
    @GetMapping("/edit/{id}")
    public String updateStudent(@PathVariable Long id, Model model) {
        Student student = studentService.getById(id);
        model.addAttribute("studentDTO", student);
        return "pages/admin/member_managements/edit_student";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
        return "redirect:/student/list";
    }
}
