var dynamicIsolate = new function() { // Isolates this code from other JavaScript
	// Load comment section after page load, AWS Lambda which uses database has long cold start. Warm is okay.
	var comment = document.getElementById("comment");
	if (comment != null) {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
				//location.reload();
				comment.innerHTML = this.responseText;
				//console.log(this.responseText)
			}
		};
		xhttp.open("POST", "/stage/ajax/new-comment", true);
		xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhttp.send("page=" + window.location +  "&action=refresh");
	}
};
