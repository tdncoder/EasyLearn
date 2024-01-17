package com.easy.learn.consts;

public interface ApiPath {
    String API = "/api/v1";

    //ping
    String PING = API + "/ping";

    //user
    String USER_SIGN_IN = API + "/sign-in";
    String USER_GET_ALL = API + "/user/get-all";
    String USER_GET_UUID = API + "/user/get-by-uuid";
    String USER_CREATE = API + "/user/create";
    String USER_UPDATE = API + "/user/update";
    String USER_DELETE = API + "/user/delete";

    //WebsiteVenue
    String WEBSITE_VENUE_GET_ALL = API + "/website-venue/get-all";
    String WEBSITE_VENUE_GET_ONE = API + "/website-venue/get-one";
    String WEBSITE_VENUE_CREATE = API + "/website-venue/create";
    String WEBSITE_VENUE_UPDATE = API + "/website-venue/update";
    String WEBSITE_VENUE_DELETE = API + "/website-venue/delete";
    //

    //WebsiteFinances
    String WEBSITE_FINANCES_GET_ALL = API + "/website-finances/get-all";
    String WEBSITE_FINANCES_GET_ONE = API + "/website-finances/get-one";
    String WEBSITE_FINANCES_CREATE = API + "/website-finances/create";
    String WEBSITE_FINANCES_UPDATE = API + "/website-finances/update";
    String WEBSITE_FINANCES_DELETE = API + "/website-finances/delete";
    //

    //WebsiteFinancesSummary
    String WEBSITE_FINANCES_SUMMARY_GET_ALL = API + "/website-finances-summary/get-all";
    String WEBSITE_FINANCES_SUMMARY_GET_ONE = API + "/website-finances-summary/get-one";
    String WEBSITE_FINANCES_SUMMARY_CREATE = API + "/website-finances-summary/create";
    String WEBSITE_FINANCES_SUMMARY_UPDATE = API + "/website-finances-summary/update";
    String WEBSITE_FINANCES_SUMMARY_DELETE = API + "/website-finances-summary/delete";
    //

    //FinalSalarySummary
    String FINAL_SALARY_SUMMARY_GET_ALL = API + "/final-salary-summary/get-all";
    String FINAL_SALARY_SUMMARY_GET_ONE = API + "/final-salary-summary/get-one";
    String FINAL_SALARY_SUMMARY_CREATE = API + "/final-salary-summary/create";
    String FINAL_SALARY_SUMMARY_UPDATE = API + "/final-salary-summary/update";
    String FINAL_SALARY_SUMMARY_DELETE = API + "/final-salary-summary/delete";
    //

    //StudentFinances
    String STUDENT_FINANCES_GET_ALL = API + "/student-finances/get-all";
    String STUDENT_FINANCES_GET_ONE = API + "/student-finances/get-one";
    String STUDENT_FINANCES_CREATE = API + "/student-finances/create";
    String STUDENT_FINANCES_UPDATE = API + "/student-finances/update";
    String STUDENT_FINANCES_DELETE = API + "/student-finances/delete";
    //

    //TrainerSalaryPaid
    String TRAINER_SALARY_PAID_GET_ALL = API + "/trainer-salary-paid/get-all";
    String TRAINER_SALARY_PAID_GET_ONE = API + "/trainer-salary-paid/get-one";
    String TRAINER_SALARY_PAID_CREATE = API + "/trainer-salary-paid/create";
    String TRAINER_SALARY_PAID_UPDATE = API + "/trainer-salary-paid/update";
    String TRAINER_SALARY_PAID_DELETE = API + "/trainer-salary-paid/delete";

    String TRAINER_SALARY_PAID_CHART = API + "/trainer-salary-paid/chart";
    //
    //trainersalarypaidSUMMARY
    String TRAINER_SALARY_SUMMARY_GET_ALL = API + "/trainer-salary-summary/get-all";
    String TRAINER_SALARY_SUMMARY_GET_ONE = API + "/trainer-salary-summary/get-one";
    String TRAINER_SALARY_SUMMARY_CREATE = API + "/trainer-salary-summary/create";
    String TRAINER_SALARY_SUMMARY_UPDATE = API + "/trainer-salary-summary/update";
    String TRAINER_SALARY_SUMMARY_DELETE = API + "/trainer-salary-summary/delete";
    //

    String MANAGER_SIGN_IN = API + "/manager/sign-in";
    String MANAGER_GET_ALL = API + "/manager/get-all";
    String MANAGER_GET_UUID = API + "/manager/get-uuid";
    String MANAGER_CREATE = API + "/manager/create";
    String MANAGER_UPDATE = API + "/manager/update";
    String MANAGER_DELETE = API + "/manager/delete";
    String MANAGER_GET_BY_USERNAME = API+"/manager/get-by-user-name";
    String MANAGER_GET_BY_ID = API + "/manager/get-by-id";




    // student
    String STUDENT_GET_ALL = API + "/student/get-all";
    String STUDENT_GET_ID = API + "/student/get-by-id";
    String STUDENT_CREATE = API + "/student/create";
    String STUDENT_UPDATE = API + "/student/update";
    String STUDENT_DELETE = API + "/student/delete";

// feedback
String FEEDBACK_GET_ALL = API + "/feedback/get-all";
    String FEEDBACK_GET_UUID = API + "/feedback/get-by-uuid";
    String FEEDBACK_CREATE = API + "/feedback/create";
    String FEEDBACK_UPDATE = API + "/feedback/update";
    String FEEDBACK_DELETE = API + "/feedback/delete";

    //ADMIN_TRAINER_COURSE_EDIT by LOC
    String COURSE_EDIT_GET_ALL = API + "/course-edit/get-all";
    String COURSE_EDIT_GET_ONE = API + "/course-edit/get-one";
    String COURSE_EDIT_CREATE = API + "/course-edit/create";
    String COURSE_EDIT_UPDATE = API + "/course-edit/update";
    String COURSE_EDIT_DELETE = API + "/course-edit/delete";
    String COURSE_EDIT_SAVE_OR_UPDATE = API + "/course-edit/save-or-update";


//END ADMIN_TRAINER_COURSE_EDIT

    //ADMIN_TRAINER_LESSON_EDIT by LOC
    String LESSON_EDIT_GET_ALL = API + "/lesson-edit/get-all";
    String LESSON_EDIT_GET_ONE = API + "/lesson-edit/get-one";
    String LESSON_EDIT_CREATE = API + "/lesson-edit/create";
    String LESSON_EDIT_UPDATE = API + "/lesson-edit/update";
    String LESSON_EDIT_DELETE = API + "/lesson-edit/delete";
    String LESSON_EDIT_SAVE_OR_UPDATE = API+ "/lesson-edit/save-or-update";
    String LESSON_EDIT_GET_LIST_BY_COURSE_ID = API + "/lesson-edit/get-all-by-courseId";
    String LESSON_EDIT_DELETE_LIST_BY_COURSE_ID = API + "/lesson-edit/delete-all-by-courseId";

//END ADMIN_TRAINER_LESSON_EDIT
    //START ADMIN_TRAINER_TEST_EDIT by LOC
    String TEST_EDIT_GET_ALL = API + "/test-edit/get-all";
    String TEST_EDIT_GET_ONE = API + "/test-edit/get-one";
    String TEST_EDIT_CREATE = API + "/test-edit/create";
    String TEST_EDIT_UPDATE = API + "/test-edit/update";
    String TEST_EDIT_DELETE = API + "/test-edit/delete";
    String TEST_EDIT_SAVE_OR_UPDATE = API+ "/test-edit/save-or-update";
    String TEST_EDIT_GET_LIST_BY_LESSON_ID = API + "/test-edit/get-all-by-lessonId";
    String TEST_EDIT_DELETE_LIST_BY_LESSON_ID = API + "/test-edit/delete-all-by-lessonId";
    String TEST_EDIT_SAVE_FILE_ALL = API + "/test-edit/save-all";
    String TEST_EDIT_GET_LIST_BY_COURSE_ID = API + "/test-edit/get-all-by-courseId";
    String TEST_EDIT_DELETE_LIST_BY_COURSE_ID = API + "/test-edit/delete-all-by-courseId";


    //END ADMIN_TRAINER_TEST_EDIT by LOC


    // end
    // trainer
    String TRAINER_GET_ALL = API + "/trainer/get-all";
    String TRAINER_GET_ID = API + "/trainer/get-id";
    String TRAINER_CREATE = API + "/trainer/create";
    String TRAINER_UPDATE = API + "/trainer/update";
    String TRAINER_DELETE = API + "/trainer/delete";
    String TRAINER_GET_ALL_NOT_HAVE_SALARY = API + "/trainer/get-all-not-salary";

    String ADMIN_GET_INDEX = API+"/admin";

//    lesson
    String LESSON_GET_BY_COURSE_ID = API + "/lesson/get";
//    end
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

}
