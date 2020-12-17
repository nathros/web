var quoteIsolate = new function() { // Isolates this code from other JavaScript

};

function selectPrintService() {
	document.getElementById("radio-design-label").className = "btn btn-light-blue ripple";
	document.getElementById("radio-print-label").className = "btn btn-blue ripple";
	document.getElementById("radio-print").checked = true;
	document.getElementById("print-extras").style.maxHeight = "275px";
	document.getElementById("print-extras").style.opacity = "1";
	document.getElementById("print-extras").style.pointerEvents = "auto";
}

function selectDesignService() {
	document.getElementById("radio-print-label").className = "btn btn-light-blue ripple";
	document.getElementById("radio-design-label").className = "btn btn-blue ripple";
	document.getElementById("radio-design").checked = true;
	document.getElementById("print-extras").style.maxHeight = "0";
	document.getElementById("print-extras").style.opacity = "0";
	document.getElementById("print-extras").style.pointerEvents = "none";
}

function sendEmail() {
	setTimeout(function() { document.getElementById("fullscreen-message").style.visibility = "visible"; }, 350);
	document.getElementById("3d-quote").submit();
}