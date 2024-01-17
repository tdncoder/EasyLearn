package com.easy.learn.web.consts;

public interface UrlPath {
    String GET_INDEX = "";
    String GET_ALL_TRAINER = "/trainer";
    String STUDENT_GET_ALL_COURSE = "/student-course";
    String STUDENT_COURSE_GET_ID = "/student-course/{id}";
    String PAYMENT = "/student-course/payment/{id}";
    String GET_LESSON_BY_COURSE_ID = "/student-course/lesson/{id}";
    String GET_REGISTERED_COURSE_ID = "/student-course/registered/{id}";

    String GET_REGISTERED_COURSE_BY_ID = "/reg-course/{id}";

    String GET_QUESTION_LIST_BY_LESSON = "/quiz/{id}";


    String SUBMIT_QUIZ = "/quiz/submit";
}
