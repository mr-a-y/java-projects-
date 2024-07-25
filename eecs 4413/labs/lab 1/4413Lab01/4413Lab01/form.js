// put your JS functions here


window.onload = function () {
    // Set default selection for the dropdown
    document.getElementsByName("program")[0].value = "EECS";

    // Set default selection for the radio button
    document.querySelector('input[name="year"][value="1"]').checked = true;
};




let lg = true;
let bg = true;

var dropdown = document.getElementsByTagName("program");

// for changing the other text field when other is chosen 
function getValue(program){
    if(program=="OTHER"){
        document.getElementById("other").style.display="inline"
    }else{
        document.getElementById("other").style.display="none"

    }
}
// for changing the logo
function changeLogo(){   
    if(lg){
        document.getElementById("im").src="images/logo/LAS.png"
        lg=!lg
    }else{
        document.getElementById("im").src="images/logo/york.png"
        lg=!lg
    }
}
// for changing the background
function changeBackground(){  
 
    if(bg){
        document.getElementById("box").style.backgroundColor = "lightblue";
        bg=!bg

    }else{
       document.getElementById("box").style.backgroundColor="rgb(220,220,220)";
        bg=!bg
    }
}


function validateForm(){
var firstName = document.getElementById("firstName").value;
var lastName = document.getElementById("lastName").value;
var password = document.getElementById("password").value;

//checks first name 
if (firstName === "") {
    alert("First name should be filled out");
    document.getElementById("firstName").focus();
    return false;
}
//checks last  name 

if (lastName === "") {
    alert("Last name should be filled out");
    document.getElementById("lastName").focus();
    return false;
}
//checks password

if (password === "") {
    alert("Password should be filled out");
    document.getElementById("password").focus();
    return false;
}

// checks if email is empty 
var email = document.getElementById("email").value;
if (email === "") {
    alert("Email should be filled out");
    document.getElementById("email").focus();
    return false;
}

// Check if email is in a valid format
var emailRegex = /^[a-zA-Z0-9!#$%&'*+\/=?^_`{|}~-]+(?:\.[a-zA-Z0-9]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\.)+[a-zA-Z]{2,3}$/;
if (!email.match(emailRegex)) {
    alert("Please enter a valid email address");
    document.getElementById("email").focus();
    return false;
}

// checks if atleast 1 hobbie is selected
var hobbies = document.getElementsByName("hobby[]");

var hobbySelected = false;
    for (var i = 0; i < hobbies.length; i++) {
        if (hobbies[i].checked) {
            hobbySelected = true;
            break;
        }
    }

    if (!hobbySelected) {
        alert("At least one hobby should be selected");
        return false;
    }



        // Check if course code is entered and validate its format
    var courseCode = document.getElementById("courseCode").value;
    if (courseCode !== "") {
        // Check if the format is EECSxxxx where xxxx are digits
        var courseRegex = /^EECS\d{4}$/;
        if (!courseCode.match(courseRegex)) {
            alert("Invalid course code format. Please enter a valid course code (e.g., EECSxxxx).");
            document.getElementById("courseCode").focus();
            return false;
        }
    }



    // Check if course code is entered and validate its format
    var courseCode = document.getElementById("courseCode").value;
    if (courseCode !== "") {
        // Check if the format is EECSxxxx where xxxx are digits
        var courseRegex = /^EECS\d{4}$/;
        if (!courseCode.match(courseRegex)) {
            alert("Invalid course code format. Please enter a valid course code (e.g., EECSxxxx).");
            document.getElementById("courseCode").focus();
            return false;
        }
    }    
return true;


}
document.getElementById("Myform").addEventListener("submit", function(event) {  if (!validateForm()) {event.preventDefault();}})
document.getElementById("Myform").addEventListener("reset", function(event) {  
    // Set default selection for the dropdown
    document.getElementsByName("program")[0].value = "EECS";

    // Use setTimeout to delay the default reset behavior
    setTimeout(function() {
        // Set default selection for the radio button
        document.querySelector('input[name="year"][value="1"]').checked = true;

        // Optional: You can hide the "other" textbox when resetting the form
        document.getElementById("other").style.display = "none";
    }, 0);
});

