package com.easy.learn.web.controller;


import com.easy.learn.web.callApi.QuizCallService;
import com.easy.learn.web.consts.UrlPath;
import com.easy.learn.web.dto.quiz.Question;
import com.easy.learn.web.dto.quiz.Quiz;
import com.easy.learn.web.dto.quiz_result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class QuizController {
    @Autowired
    QuizCallService service;

    @Autowired
    Result result;

    @GetMapping(UrlPath.GET_QUESTION_LIST_BY_LESSON)
    public String showQuizPage(@PathVariable Long id, Model model, RedirectAttributes ra) {
        try {
           Quiz quiz = service.getListQuestionByLessonID(id);

//         get list of lesson from db
            model.addAttribute("quiz", quiz);

            if (quiz.getQuestions().size() == 0) {
                ra.addFlashAttribute("message", "There is no quiz available for the lessson");
                return "redirect:/student-course/lesson/1" ;
            }
            return "student-take-quiz";
        } catch (Exception e) {
            ra.addFlashAttribute("message", "Course lessons not found");
            return "courses";
        }
    }

    @PostMapping(UrlPath.SUBMIT_QUIZ)
    public String submit(@ModelAttribute Quiz quiz, Model m) {
        result.setTotalCorrect(service.getResult(quiz));
        result.setTotalQuestion(quiz.getQuestions().size());


        Question question = quiz.getQuestions().get(0);
        result.setLessonEditId(question.getLessonEditId());
        m.addAttribute("result", result);
        return "result";
    }
}
