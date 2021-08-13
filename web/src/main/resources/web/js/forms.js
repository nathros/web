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

const InputError = "input-error";
const FormsParamError = "forms-param-error";
const InputIconError = "input-icon-error";
const ShakeAnimation = "input-shake";
const SpinAnimation = "captcha-spin";
const FlipAnimation = "captcha-image-flip"

function shakeInput(sender, start) {
	if (start) {
		sender.classList.add(ShakeAnimation);
		sender.addEventListener("animationend",  function() {
			sender.classList.remove(ShakeAnimation);
		});
	} else {
		sender.classList.remove(ShakeAnimation);
	}
}

function checkTextAreaEmpty(sender) {
	var error = (sender.value == null) || (sender.value.trim() == "");
	if (error == true) {
		sender.classList.add(InputError);
		sender.previousElementSibling.classList.add(FormsParamError);
		sender.previousElementSibling.getElementsByTagName("b")[0].style.display = "initial";
		shakeInput(sender, true);
	} else {
		sender.classList.remove(InputError);
		sender.previousElementSibling.classList.remove(FormsParamError);
		sender.previousElementSibling.getElementsByTagName("b")[0].style.display = "none";
	}
}

function setInputError(sender, error, shake) {
	if (error == true) {
		sender.classList.add(InputError);
		sender.nextElementSibling.classList.add(InputIconError);
		sender.parentElement.previousElementSibling.classList.add(FormsParamError);
		sender.parentElement.previousElementSibling.getElementsByTagName("b")[0].style.display = "initial";
		shakeInput(sender.parentElement, shake);
	} else {
		sender.classList.remove(InputError);
		sender.nextElementSibling.classList.remove(InputIconError);
		sender.parentElement.previousElementSibling.classList.remove(FormsParamError);
		sender.parentElement.previousElementSibling.getElementsByTagName("b")[0].style.display = "none";
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
		sender.parentElement.previousElementSibling.getElementsByTagName("b")[0].innerHTML = "SHOULD NOT BE EMPTY";
	} else {
		setInputError(sender, false, false);
	}
}

function loadNewCAPTCHAError(sender) {
	sender.classList.remove(SpinAnimation);
	sender.nextElementSibling.style.display = "initial";
}

var timeoutCAPTCHA = (function () {
    var timeout = null;
    return {
        getTimeout: function()  {
			return timeout;
		},
		setTimeout: function(obj)  {
			timeout = obj;
		},
		clearTimeout: function()  {
			timeout = null;
		}
    }
})();

function loadNewCAPTCHA(url, sender) {
	if (timeoutCAPTCHA.getTimeout() != null) return;
	var finished = false;
	var imageData = null;

	sender.classList.add(SpinAnimation);
	var xhttp = new XMLHttpRequest();

	var loop = setInterval(function(){
		if (finished) {
			sender.classList.remove(SpinAnimation);
			clearInterval(loop);
			sender.previousElementSibling.addEventListener("transitionend", () => {
				sender.previousElementSibling.src = imageData;
				sender.previousElementSibling.classList.remove(FlipAnimation);
			}, { once: true });
			sender.previousElementSibling.classList.add(FlipAnimation);
			timeoutCAPTCHA.clearTimeout();
		}
	 }, 500);

	timeoutCAPTCHA.setTimeout(setTimeout(function(){
		clearInterval(loop);
		loadNewCAPTCHAError(sender);
		xhttp.abort();
		timeoutCAPTCHA.clearTimeout();
	}, 5000));


	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			clearInterval(timeoutCAPTCHA.getTimeout());
			var index = this.responseText.indexOf("@");
			if (index > 0) {
				imageData = this.responseText.substring(0, index);
				finished = true;
				var newEncoded = this.responseText.substring(index + 1, this.responseText.length);
				document.getElementById("encoded").value = newEncoded;
				sender.nextElementSibling.style.display = "none";
			} else {
				loadNewCAPTCHAError(sender);
				clearInterval(loop);
				timeoutCAPTCHA.clearTimeout();
			}
		}
	};
	xhttp.open("GET", url, true);
	xhttp.send();
}
