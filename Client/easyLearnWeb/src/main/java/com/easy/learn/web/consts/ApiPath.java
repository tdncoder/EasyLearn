package com.easy.learn.web.consts;

public interface ApiPath {
    String API = "/api/v1";

    //ping
    String PING = API + "/ping";

//    security
    String AUTHENTICATE = API + "/auth/authenticate";
    String REGISTER = API + "/auth/register";

    //user
    String USER_SIGN_IN = API + "/user/sign-in";
    String USER_GET_ALL = API + "/user/get-all";
    String USER_GET_BY_USERNAME = API + "/user/get-by-user-name";
    String USER_GET_UUID = API + "/user/get-by-uuid";
    String USER_CREATE = API + "/user/create";
    String USER_UPDATE = API + "/user/update";
    String USER_DELETE = API + "/user/delete";

    //    trainer
    String TRAINER_GET_ALL = API + "/trainer/get-all";
    String TRAINER_GET_ID = API + "/trainer/get-by-id";
    String TRAINER_CREATE = API + "/trainer/create";
    String TRAINER_UPDATE = API + "/trainer/get-update";
    String TRAINER_DELETE = API + "/trainer/delete";
    //    lesson
    String LESSON_GET_BY_COURSE_ID = API + "/lesson/get";

    // course
    String STUDENT_COURSE_GET_ALL = API + "/student-course/get-all";
    String STUDENT_COURSE_GET_ID = API + "/student-course/get-by-id";
    String COURSE_GET_ALL = API + "/course/get-all";
    String COURSE_GET_ID = API + "/course/get-by-id";
    String COURSE_CREATE = API + "/course/create";
    String COURSE_UPDATE = API + "/course/update";
    String COURSE_DELETE = API + "/course/delete";

    //Payment
    String PAYMENT_PROCESS = API + "/payment/process";
    String PAYMENT_METHODS = API + "/payment/methods";

    // end
//    quiz
    String TEST_EDIT_GET_LIST_BY_LESSON_ID = API + "/test-edit/get-all-by-lessonId";
//    end quiz

    //ADMIN_TRAINER_COURSE_EDIT by LOC
    String COURSE_EDIT_GET_ALL = API + "/course-edit/get-all";
    String COURSE_EDIT_GET_ONE = API + "/course-edit/get-one";
    String COURSE_EDIT_CREATE = API + "/course-edit/create";
    String COURSE_EDIT_UPDATE = API + "/course-edit/update";
    String COURSE_EDIT_DELETE = API + "/course-edit/delete";

//END ADMIN_TRAINER_COURSE_EDIT

}
