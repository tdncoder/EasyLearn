function checkNull2(){
    let firstname = document.getElementById("firstname").value;
    let lastname = document.getElementById("lastname").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let datecreated = document.getElementById("datecreated").value;
    let status = document.getElementById("status").value;
    if (firstname === '' || lastname === '' || email === '' || phone === ''|| datecreated === '' || status === '') {
        alert("Vui lòng điền đầy đủ thông tin");
        return false;
    }
    if(phone.length !== 10){
        alert("Số điện thoại chưa đúng định dạng 10 số");
        return false;
    }
    if(status === "-1"){
        alert("Vui lòng chọn Status")
        return false;
    }
}