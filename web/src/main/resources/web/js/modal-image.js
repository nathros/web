function disableBodyScroll() {
	document.getElementsByTagName('BODY')[0].classList.add('no-scroll');
}

function enableBodyScroll() {
	document.getElementsByTagName('BODY')[0].classList.remove('no-scroll');
}