if (window.self !== window.top) parent.postMessage(window.location.pathname + window.location.search, "https://nathros.github.io/"); // So domain know which page is active

function btnSearchClick() {
	var input = document.getElementById("query");
	if ((input.value != null) && (input.value.trim() != "")) {
		if (input.getBoundingClientRect().width >= 290) {
			setTimeout(function() { document.getElementById("fullscreen-message").style.display = "flex"; }, 350);
			window.onunload = function(){}; // Fixes FireFox behaviour: do search then go back a page, fullscreen-message is visiable
			document.forms["search-form"].submit();
		}
	}

	if (input.getBoundingClientRect().width <= 290) {
		input.addEventListener("transitionend", () => {
			input.focus();
		}, { once: true });
	} else {
		input.focus();
	}
}

// https://www.quirksmode.org/js/cookies.html
function createCookie(name,value,days) {
	if (days) {
		var date = new Date();
		date.setTime(date.getTime()+(days*24*60*60*1000));
		var expires = "; expires="+date.toGMTString();
	}
	else var expires = "";
	document.cookie = name+"="+value+expires+";SameSite=None; Secure; path=/";
}

function readCookie(name) {
	var nameEQ = name + "=";
	var ca = document.cookie.split(';');
	for(var i=0;i < ca.length;i++) {
		var c = ca[i];
		while (c.charAt(0)==' ') c = c.substring(1,c.length);
		if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
	}
	return null;
}

function eraseCookie(name) {
	createCookie(name,"",-1);
}

function btnSearchDebug(event) {
	if (event.which == 3) { // Right click
		var debug = readCookie("debug");
		if (debug == null) {
			createCookie("debug", "true", 0);
		} else if ("true" == debug) {
			createCookie("debug", "false", 0);
		} else if ("false" == debug) {
			createCookie("debug", "true", 0);
		}
		location.reload();
	}
}
