function tooltipHover(sender) {
	let tip = sender.getElementsByClassName("tooltip-inner")[0];
	if (tip == null) throw "Tooltip enter not found";
	if (tip.style.left != "") return;
	let xPos = sender.getBoundingClientRect().left;
	const vw = document.body.clientWidth;
	let width = tip.offsetWidth;
	if ((xPos + width) > vw) {
		tip.style.left = Math.floor(vw - xPos - width - 10) + "px";
	}
}

function tooltipHoverLeave(sender) {
	let tip = sender.getElementsByClassName("tooltip-inner")[0];
	if (tip == null) throw "Tooltip leave not found";
	tip.style.left = "";
}