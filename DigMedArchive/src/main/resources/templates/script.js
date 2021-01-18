function mouseoverPass(obj) {
  var obj = document.getElementById('password');
  obj.type = "text";
}
function mouseoutPass(obj) {
  var obj = document.getElementById('password');
  obj.type = "password";
}

$(document).ready(function() {
	$('[data-toggle="tooltip"]').tooltip();
});