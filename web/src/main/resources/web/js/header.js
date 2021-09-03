function btnSearchClick() {
	var input = document.getElementById("query");
	if ((input.value != null) && (input.value.trim() != "")) {

		if (input.getBoundingClientRect().width > 10) {
			setTimeout(function() { document.getElementById("fullscreen-message").style.display = "flex"; }, 350);
			document.forms["search-form"].submit();
		}
	}

	input.addEventListener("transitionend", () => {
		input.focus();
	}, { once: true });
}
