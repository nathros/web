const resizeObserver = new ResizeObserver(entries =>
	entries.forEach(function(element) {
		element.target.style.minHeight = element.target.clientHeight + "px";
	})
)

function toggleContentHeight(sender) {
	if (sender.checked) {
		sender.nextElementSibling.style.minHeight = "0px";
		resizeObserver.unobserve(sender.nextElementSibling)
	} else {
		sender.nextElementSibling.style.minHeight = sender.nextElementSibling.clientHeight;
		resizeObserver.observe(sender.nextElementSibling)
	}
}
