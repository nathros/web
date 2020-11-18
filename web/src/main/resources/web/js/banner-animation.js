var bannerAnimationIsolate = new function() { // Isolates this code from other JavaScript

var stepFrame = 0;
var canvas = document.getElementById("banner-canvas");
var ctx = canvas.getContext("2d");
var mousePos = null;

canvas.style.width = "100%";
canvas.style.height = "100%";

var currentWidth = 0;
var lineWidth = 4;
var stepFPS = 60;
var stepSize = (0.25 / 3) * (60 / stepFPS);

var fadeDirection = true;
var fade = 0.1; // Start mid fade
var fadeMax = 0.2;
var fadeStep = 0.001 * (60 / stepFPS);

function debug() {
	ctx.save();
	ctx.font = "40px Arial";
	ctx.fillStyle = "white";
	ctx.strokeStyle = "black";
	ctx.lineWidth = 1;
	if (mousePos != null) {
		ctx.strokeText("X" + mousePos.x + " Y" + mousePos.y, 10, 48);
		ctx.fillText("X" + mousePos.x + " Y" + mousePos.y, 10, 48);
	} else {
		ctx.strokeText("MouseOut", 10, 48);
		ctx.fillText("MouseOut", 10, 48);
	}
	ctx.restore();
}

function getMousePos(evt) {
	var rect = canvas.getBoundingClientRect();
	return {
		x: (evt.clientX - rect.left) / (rect.right - rect.left) * canvas.width / window.devicePixelRatio,
		y: (evt.clientY - rect.top) / (rect.bottom - rect.top) * canvas.height / window.devicePixelRatio
	};
}

function drawLine(y) {
	// Clear where lines are not present
	ctx.strokeStyle = "black";
	ctx.globalCompositeOperation = "destination-out";
	ctx.beginPath();
	ctx.moveTo(0, y);
	ctx.lineTo(canvas.width, y);
	ctx.stroke();

	// Draw line
	ctx.strokeStyle = "rgba(0, 0, 0, " + fade + ")";
	ctx.globalCompositeOperation = "source-over";
	ctx.beginPath();
	ctx.moveTo(0, y - lineWidth);
	ctx.lineTo(canvas.width, y - lineWidth);
	ctx.stroke();
}

function bannerAnimate() {
	if (canvas.clientWidth != currentWidth) { // Only scale on vw change
		currentWidth = canvas.clientWidth;
		var scale = window.devicePixelRatio;
		canvas.width = canvas.clientWidth * scale;
		canvas.height = canvas.clientHeight * scale;
		ctx.scale(scale, scale);
	}

	ctx.clearRect(0, 0, canvas.width, canvas.height);
	ctx.lineWidth = lineWidth;

	// Draw mouse hover
	if (mousePos != null) {
		var gradient = ctx.createRadialGradient(mousePos.x, mousePos.y, 1, mousePos.x, mousePos.y, 70);
		gradient.addColorStop(0.2, "rgba(0, 0, 0, 0.4)");
		gradient.addColorStop(1, "transparent");
		ctx.fillStyle = gradient;
		ctx.globalCompositeOperation = "source-over";
		ctx.fillRect(mousePos.x - 80, mousePos.y - 80, 200, 200);
	}

	// Draw lines
	var start = stepFrame;
	var vHeight = canvas.height + (lineWidth * 2);
	while (start < vHeight) {
		drawLine(start);
		start += lineWidth * 2;
	}
	
	// Move scan line down
	stepFrame += stepSize;
	if (stepFrame >= (lineWidth * 2)) stepFrame = 0;
	
	// Scan line fade amount for pulse
	if (fadeDirection) {
		fade += fadeStep;
		if (fade > fadeMax) {
			fadeDirection = !fadeDirection;
		}
	} else {
		fade -= fadeStep;
		if (fade < 0.05) {
			fadeDirection = !fadeDirection;
		}
	}

	//debug();
}

function mouseMove(e) {
	mousePos = getMousePos(e);
}

function mouseOut() {
	mousePos = null;
}

window.setInterval(bannerAnimate, 1000 / stepFPS);
canvas.addEventListener('mousemove', mouseMove, false);
canvas.addEventListener('mouseout', mouseOut, false);

};
