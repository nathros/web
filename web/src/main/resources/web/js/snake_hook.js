var charArray = ['-','-','-','-','-'];
var loadSnakeJS = false;

window.addEventListener("keydown", snak);
function snak(e) {
	if (document.activeElement instanceof HTMLBodyElement) {
		charArray.push(e.key);
		charArray = charArray.slice(1, 6);
		if (charArray.join("").search("snake") != -1) {
			if (!loadSnakeJS) { // Load script, only once through.
				loadJS = true;
				document.head.appendChild(document.createElement("script")).src = "res/snake.js";
			}
			try {
				createSnake();
			} catch (e) {
			}
		}
	}
}