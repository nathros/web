var formsIsolate = new function() { // Isolates this code from other JavaScript

};

function sendEmail() {
	setTimeout(function() { document.getElementById("fullscreen-message").style.visibility = "visible"; }, 350);
	document.getElementById("email-form").submit();
}