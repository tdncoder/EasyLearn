function checkNull(){
    let firstname = document.getElementById("firstname").value;
    let lastname = document.getElementById("lastname").value;
    let email = document.getElementById("email").value;
    let address = document.getElementById("address").value;
    let phone = document.getElementById("phone").value;
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let managementtype = document.getElementById("managementtype").value;
    if (firstname === '' || lastname === '' || email === '' || address === ''|| phone === '' || username === ''|| password === '' || managementtype ==='') {
        alert("Vui lòng điền đầy đủ thông tin");
        return false;

    // } else if (firstName === '' && lastname === '' && email === '' && address === ''&& phone === '' && username === '' && password === '' && managementType ==='' ){
    //     alert("Vui lòng điền đầy đủ thông tin");
    //     return false;
    }
    if(phone.length !== 10){
        alert("Số điện thoại chưa đúng định dạng 10 số");
        return false;
    }
    if(managementtype === "-1"){
        alert("Vui lòng chọn Management Type")
        return false;
    }
}