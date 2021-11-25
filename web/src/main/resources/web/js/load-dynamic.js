var dynamicIsolate = new function() { // Isolates this code from other JavaScript
	// Load comment section after page load, AWS Lambda which uses database has long cold start. Warm is okay.
	var comment = document.getElementById("comment");
	if (comment != null) {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
				comment.innerHTML = this.responseText;
			}
		};

		xhttp.timeout = 1000 * 19; // 19 seconds
		xhttp.ontimeout = function () {
			var element = document.getElementsByClassName("comments-placeholder")[0];
			if (element != null) {
				element.classList.add("comments-placeholder-clear-animation");
				element.innerHTML = "Timeout error";
			} else {
				throw "Unable to find comments-placeholder element and report timout error";
			}
		};

		xhttp.open("POST", "/stage/ajax/comment", true);
		xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhttp.send("page=" + window.location +  "&action=refresh");
	}
};
