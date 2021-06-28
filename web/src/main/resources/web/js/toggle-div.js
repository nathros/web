function toggleContentHeight(sender) {
	if (sender.checked) {
		sender.nextElementSibling.style.height = "0px";
	} else {
		sender.setAttribute("record", sender.nextElementSibling.clientHeight);
		sender.nextElementSibling.style.height = sender.getAttribute("record") + "px";
	}
}
