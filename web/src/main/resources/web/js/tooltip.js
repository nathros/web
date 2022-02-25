function tooltipHover(sender) {
	let tip = sender.getElementsByClassName("tooltip-inner")[0];
	if (tip == null) throw "Tooltip enter not found";
	if (tip.style.left != "") return;
	let pos = sender.childNodes[3].getBoundingClientRect();
	let xPos = pos.left;
	const vw = document.body.clientWidth;
	let width = tip.offsetWidth;
	if ((xPos + width) > vw) {
		tip.style.left = Math.floor(vw - xPos - width - 10) + "px";
	}

	const vh = window.innerHeight;
	let yBottom = (pos.top + pos.height);
	if (yBottom > vh) {
		tip.style.top = (vh - yBottom) + "px";
	}
}

function tooltipHoverLeave(sender) {
	let tip = sender.getElementsByClassName("tooltip-inner")[0];
	if (tip == null) throw "Tooltip leave not found";
	tip.style.left = "";
	tip.style.top = "";
}