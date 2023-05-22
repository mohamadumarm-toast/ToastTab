
function validateUsername() {
    var uname = document.getElementById("username");
    if (uname.value.length < 5) {
        document.getElementById("errormsg1").textContent = "Username should have atleast 5 characters.";
        return false;
    }
    else {
        document.getElementById("errormsg1").textContent = "";
        return true;
    }
}
function validatePass() {
    var pass = document.getElementById("password");
    if (pass.value.length < 8) {
        document.getElementById("errormsg2").textContent = "Password should have a minimum length of 8.";
        return false;
    }
    else {
        document.getElementById("errormsg2").textContent = "";
        return true;
    }
}

function validateForm() {
    if (validateUsername() && validatePass()) {
        return true;
    }
    else {
        alert('Fill the required fields with suitable value!');
        return false;
    }
}