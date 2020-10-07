var quoteIsolate = new function() { // Isolates this code from other JavaScript

};


function selectPrintService() {
	document.getElementById("radio-design-label").className = "btn btn-light-blue ripple";
	document.getElementById("radio-print-label").className = "btn btn-blue ripple";
	document.getElementById("radio-print").checked = true;
	//document.getElementById("print-extras").style.display = "block";
	// TODO height needs to match final size or animation will not work correctly in both directions, find better solution
	document.getElementById("print-extras").style.maxHeight = "275px";
	document.getElementById("print-extras").style.opacity = "1";
	//document.getElementById("print-extras").style.display = "block"
}

function selectDesignService() {
	document.getElementById("radio-print-label").className = "btn btn-light-blue ripple";
	document.getElementById("radio-design-label").className = "btn btn-blue ripple";
	document.getElementById("radio-design").checked = true;
	//document.getElementById("print-extras").style.display = "none";
	document.getElementById("print-extras").style.maxHeight = "0";
	document.getElementById("print-extras").style.opacity = "0";
	//document.getElementById("print-extras").style.display = "none"
}
