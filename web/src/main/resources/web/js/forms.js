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
const ShakeAnimation = "input-shake";
const SpinAnimation = "captcha-spin";

function setInputError(sender, error, shake) {
	if (error == true) {
		sender.classList.add(ErrorClass);
		sender.previousElementSibling.classList.add(ErrorParam);
		if (shake == true) {
			sender.classList.add(ShakeAnimation);
			sender.addEventListener("animationend",  function() {
				sender.classList.remove(ShakeAnimation);
			});
			sender.previousElementSibling.classList.add(ShakeAnimation);
			sender.previousElementSibling.addEventListener("animationend",  function() {
				sender.previousElementSibling.classList.remove(ShakeAnimation);
			});
		}
		sender.previousElementSibling.getElementsByTagName("b")[0].style.display = "initial";
	} else {
		sender.classList.remove(ErrorClass);
		sender.classList.remove(ShakeAnimation);
		sender.previousElementSibling.classList.remove(ErrorParam);
		sender.previousElementSibling.classList.remove(ShakeAnimation);
		sender.previousElementSibling.getElementsByTagName("b")[0].style.display = "none";
	}
}

function checkInputEmpty(sender) {
	setInputError(sender, (sender.value == null) || (sender.value.trim() == ""), true);
}

function checkInputEmail(sender) {
	if (sender.getAttribute("error") == null) return;
	if ((sender.value == null) || (sender.value.trim() == "")) {
		setInputError(sender, true, false);
		sender.setAttribute("error", "true");
	} else {
		var error = !validateEmail(sender.value);
		setInputError(sender, error, false);
		if (error) sender.setAttribute("error", "true");
	}
}

function checkInputEmailLeave(sender) {
	if ((sender.value == null) || (sender.value.trim() == "")) {
		setInputError(sender, true, true);
		sender.setAttribute("error", "true");
	} else {
		var error = !validateEmail(sender.value);
		setInputError(sender, error, error);
		if (error) sender.setAttribute("error", "true");
	}
}

function checkInputCAPTCHA(sender) {
	if ((sender.value == null) || (sender.value.trim() == "")) {
		setInputError(sender, true, true);
		sender.previousElementSibling.getElementsByTagName("b")[0].innerHTML = "SHOULD NOT BE EMPTY";
	} else {
		setInputError(sender, false, false);
	}
}

function loadNewCAPTCHAError(sender) {
	sender.classList.remove(SpinAnimation);
	sender.nextElementSibling.style.display = "initial";
}

function loadNewCAPTCHA(url, sender) {
	sender.classList.add(SpinAnimation);
	var timeout = setInterval(function(){ loadNewCAPTCHAError(sender) }, 5000);
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			clearInterval(timeout);
			var index = this.responseText.indexOf("@");
			if (index > 0) {
				sender.classList.remove(SpinAnimation);
				sender.previousElementSibling.src = this.responseText.substring(0, index);
				var newEncoded = this.responseText.substring(index + 1, this.responseText.length);
				document.getElementById("encoded").value = newEncoded;
				sender.nextElementSibling.style.display = "none";
			} else {
				loadNewCAPTCHAError(sender);
			}
		}
	};
	xhttp.ontimeout = function () { loadNewCAPTCHAError(sender); }
	xhttp.open("GET", url, true);
	xhttp.send();
}
