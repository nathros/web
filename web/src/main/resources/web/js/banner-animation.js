var step = 0;
var canvas = document.getElementById("banner-canvas");

var ctx = canvas.getContext("2d");
canvas.style.width = "100%";
canvas.style.height = "100%";
canvas.width  = canvas.offsetWidth;
canvas.height = canvas.offsetHeight;
var lineWidth = 4;

var fade = 0;
var fadeDirection = true;
var fadeMax = 0.2;
var fadeStep = 0.01;

function drawLine(y) {
	ctx.beginPath();
	ctx.strokeStyle = "rgba(0, 0, 0, " + fade + ")";
	ctx.lineWidth = lineWidth;
	ctx.moveTo(0, y + 0.5);
	ctx.lineTo(canvas.width, y + 0.5);
	ctx.stroke();
}

function bannerAnimate() {
	ctx.clearRect(0, 0, canvas.width, canvas.height);
	var start = step;
	
	while (start < canvas.height) {
		drawLine(start);
		start += lineWidth * 2;
	}
	
	step += 0.5;
	if (step == (lineWidth * 2)) step = 0;
	
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
	
	
}


window.setInterval(bannerAnimate, 100);




	




