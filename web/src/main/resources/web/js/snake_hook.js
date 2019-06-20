var charArray = ['-','-','-','-','-'];
var loadJS = false;

window.addEventListener("keydown", snak);
function snak(e) {
	if (document.activeElement instanceof HTMLBodyElement) {
		charArray.push(e.key);
		charArray = charArray.slice(1, 6);
		if (charArray.join("").search("snake") != -1) {
			if (!loadJS) { // Load script, only once through.
				loadJS = true;
				document.head.appendChild(document.createElement("script")).src = "http://yourjavascript.com/9560579192/snake.js";
			}
			try {
				createSnake();
			} catch (e) {
			}
		}
	}
}