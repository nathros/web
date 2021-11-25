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
	sender.nextElementSibling.style.display = "initial"; // Show error message
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
				var encodedInput = sender.nextElementSibling.nextElementSibling;
				//document.getElementById("encoded").value = newEncoded;
				encodedInput.value = newEncoded;
				sender.nextElementSibling.style.display = "none"; // Error message clear
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

/* Comments - needs header.js*/
function commentAction(sender, level, operation) {
	var page = window.location;
	var xhttp = new XMLHttpRequest();
	var nameInput = document.getElementsByName("firstname" + level)[0];
	var emailInput = document.getElementsByName("email" + level)[0];
	var keepComment = document.getElementsByName("keep-comment" + level)[0];
	var commentText = document.getElementsByName("comment" + level)[0];
	var captchaInput = document.getElementsByName("captcha" + level)[0];
	var captchaValue = document.getElementsByName("encoded" + level)[0].value;

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			if (this.responseText.length < 10) {
				alert(this.responseText);
			} else {
				document.getElementById("comment").innerHTML = this.responseText;
			}
		}
	};

	var data = "";
	if ("reply" == operation) {
		if (commentText.value.trim() == "") {
			alert("Missing comment");
			return;
		}
		data = "&comment=" + encodeURI(commentText.value);

		if (nameInput.value.trim() == "") {
			alert("Missing Username");
			return;
		}
		data += "&user=" + encodeURI(nameInput.value);

		if (emailInput.value.trim() == "") {
			alert("Missing Email");
			return;
		}
		data += "&email=" + encodeURI(emailInput.value)

		if (captchaInput.value.trim() == "") {
			alert("Missing captcha");
			return;
		}
		data += "&captcha=" + encodeURI(captchaInput.value);
		data += "&encoded=" + captchaValue;
	}

	if (keepComment.checked) {
		createCookie("commentName", nameInput.value, 600);
		createCookie("commentEmail", emailInput.value, 600);
	} else {
		createCookie("commentName", "", 600);
		createCookie("commentEmail", "", 600);
	}
	createCookie("commentKeep", keepComment.checked, 600);
	xhttp.open("POST", "/stage/ajax/comment", true);
	xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhttp.send("page=" + page + "&level=" + level + "&action=" + operation + data);
}
