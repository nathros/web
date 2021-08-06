var formsIsolate = new function() { // Isolates this code from other JavaScript

};

function sendEmail() {
	setTimeout(function() { document.getElementById("fullscreen-message").style.display = "flex"; }, 350);
	document.getElementById("email-form").submit();
}

function validateEmail(email) {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

const ErrorClass = "forms-input-error";
const ErrorParam = "forms-param-error";

function setInputError(sender, error) {
	if (error == true) {
		sender.classList.add(ErrorClass);
		sender.previousElementSibling.classList.add(ErrorParam);
		sender.previousElementSibling.getElementsByTagName("b")[0].style.display = "initial";
	} else {
		sender.classList.remove(ErrorClass);
		sender.previousElementSibling.classList.remove(ErrorParam);
		sender.previousElementSibling.getElementsByTagName("b")[0].style.display = "none";
	}
}

function checkInputEmpty(sender) {
	setInputError(sender, (sender.value == null) || (sender.value.trim() == ""));
}

function checkInputEmail(sender) {
	if (sender.getAttribute("error") == null) return;
	checkInputEmailLeave(sender);
}

function checkInputEmailLeave(sender) {
	if ((sender.value == null) || (sender.value.trim() == "")) {
		setInputError(sender, true);
		sender.setAttribute("error", "true");
	} else {
		var error = !validateEmail(sender.value);
		setInputError(sender, error);
		if (error) sender.setAttribute("error", "true");
	}
}

function checkInputCAPTCHA(sender) {
	if ((sender.value == null) || (sender.value.trim() == "")) {
		setInputError(sender, true);
		sender.previousElementSibling.getElementsByTagName("b")[0].innerHTML = "SHOULD NOT BE EMPTY";
	} else {
		setInputError(sender, false);
	}
}