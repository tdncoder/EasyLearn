function checkNull1(){
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    if (username === ''|| password === '') {
        alert("Vui lòng điền đầy đủ thông tin");
        return false;
    }
}