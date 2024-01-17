
function checkNull2() {
    let arrInput = document.getElementsByClassName("input-element");
    let arrMessageError = document.getElementsByClassName("e-wrong");
    let isValid = true;

    for (let i = 0; i < arrInput.length; i++) {
        if (arrInput[i].value.trim() === "") {
            showError(arrMessageError[i], "Please fill in the information, this element can't be NULL");
            isValid = false;
        } else if (i === 0 && arrInput[i].value.length > 50) {
            showError(arrMessageError[i], "Title must be less than 50 characters");
            isValid = false;
        } else if (i === 1 && arrInput[i].value.length > 250) {
            showError(arrMessageError[i], "Description must be less than 250 characters");
            isValid = false;
        } else {
            hideError(arrMessageError[i]);
        }
    }
    return isValid;
}

function showError(element, message) {
    element.classList.remove("d-none");
    element.classList.add("d-block");
    element.innerHTML = message;
}

function hideError(element) {
    element.classList.remove("d-block");
    element.classList.add("d-none");
}

//====================================lesson create validator

function checkNullLessonCreate(){
let arrInput = document.getElementsByClassName("input-element");
let arrMessageError = document.getElementsByClassName("e-wrong");
let isValid = true;

    for (let i = 0; i < arrInput.length; i++) {
        if (arrInput[i].value.trim() === "") {
            showError(arrMessageError[i], "Please fill in the information, this element can't be NULL");
            isValid = false;
        } else if (i === 0){
            if(!/^\d+$/.test(arrInput[i].value.trim())){
                showError(arrMessageError[i], "Number lesson must be a number");
                isValid = false;
            }else if(arrInput[i].value.length > 2){
                showError(arrMessageError[i], "Title must be less than 2 number");
                isValid = false;
            }else{
                hideError(arrMessageError[i]);
            }
        } else if (i === 1 && arrInput[i].value.length > 50) {
            showError(arrMessageError[i], "Title must be less than 50 characters");
            isValid = false;
        } else {
            hideError(arrMessageError[i]);
        }
    }
    return isValid;
}

function showError(element, message) {
    element.classList.remove("d-none");
    element.classList.add("d-block");
    element.innerHTML = message;
}

function hideError(element) {
        element.classList.remove("d-block");
        element.classList.add("d-none");
}

//====================================check file quiz validator

function checkFile(){
    let x = document.getElementById("fileQuiz");
    if(x.value === ''){
        alert("You must import file excel quiz");
        return false
    }
    return true;

}