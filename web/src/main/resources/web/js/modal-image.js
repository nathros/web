function disableBodyScroll() {
	document.getElementsByTagName('BODY')[0].classList.add('no-scroll');
}

function enableBodyScroll() {
	history.go(-1);
	document.getElementsByTagName('BODY')[0].classList.remove('no-scroll');
}