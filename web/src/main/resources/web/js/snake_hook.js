var charArray = ['-','-','-','-','-'];
var loadSnakeJS = false;

window.addEventListener("keydown", snak);
function snak(e) {
	if (document.activeElement instanceof HTMLBodyElement) {
		charArray.push(e.key);
		charArray = charArray.slice(1, 6);
		if (charArray.join("").search("snake") != -1) {
			if (!loadSnakeJS) { // Load script, only once through.
				loadSnakeJS = true;
				document.head.appendChild(document.createElement("script")).src = "res/snake.js";
			} else {
				createSnake();
			}
		} else if (charArray.join("").search("admin") != -1) {
			window.location.href = "/admin";
		} else if (charArray.join("").search("sand") != -1) {
			window.location.href = "/sandpit";
		}
	}
}