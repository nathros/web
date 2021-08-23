
function btnSearchClick(sender) {
	if ((sender.nextElementSibling.value != null) && (sender.nextElementSibling.value.trim() != "")) {
		if (sender.nextElementSibling.getBoundingClientRect().width > 10) document.forms["search-form"].submit();
	}
	
	sender.nextElementSibling.addEventListener("transitionend", () => {
		sender.nextElementSibling.focus();
	}, { once: true });
}
