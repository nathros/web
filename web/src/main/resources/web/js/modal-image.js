function disableBodyScroll() {
	document.getElementsByTagName('BODY')[0].classList.add('no-scroll');
}

function enableBodyScroll() {
	if (history.length > 2) {
		history.go(-1);
	} else {
		location.hash = '';  // First visit of page cannot go back
	}
	document.getElementsByTagName('BODY')[0].classList.remove('no-scroll');
}