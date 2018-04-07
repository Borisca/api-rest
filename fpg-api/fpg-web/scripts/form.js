//var nom =$('#name').val();
//var age =$('#age').val();
//     url: "http://localhost:8080/api/users", // the method we are
$(document).ready(function() {

	window.onload = updateField();
	// window.onload = alert(localStorage.getItem("idUpdate"));
	// process the form
	$('form').submit(function(event) {
		var id = localStorage.getItem("idUpdate");

		// get the form data
		// there are many ways to get this data using jQuery (you can use the
		// class or id also)
		var formData = {
			'id' : id,
			'name' : $('#name').val(), // $('input[name=name]').val(),
			'firstName' : $('#firstName').val(),
			'email' : $('#email').val(),
			'mDP' : $('#mDP').val(),
			'codePostal' : $('#codePostal').val()

		};

		// process the form
		$.ajax({
			type : 'POST', // define the type of HTTP verb we want to
			// use (POST for our form)
			url : 'http://localhost:8080/api/users/add', // the url
			// where we
			// want to
			// POST
			data : formData, // our data object
			dataType : 'jsonp', // what type of data do we expect back from
			// the server
			encode : true,
			crossDomain : true
		})
		// using the done promise callback
		.done(function(data) {

			// log data to the console so we can see
			console.log(data);
			window.location.href = 'index.html';
			// here we will handle errors and validation messages
		});

		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();

	});

});

function check(input) {
	if (input.value != document.getElementById('mDP').value) {
		input.setCustomValidity('Les mots de passes doivent etre identique');
	} else {
		// input is valid -- reset the error message
		input.setCustomValidity('');
	}
}
function updateField() {
	var id = localStorage.getItem("idUpdate");
	$.ajax({
		type : 'GET', // define the type of HTTP verb we want to use
		// (POST for our form)
		url : 'http://localhost:8080/api/users/' + id, // the url where
		// we want to
		// POST
		dataType : 'jsonp', // what type of data do we expect back from the
		// server
		encode : true,
		crossDomain : true
	}).done(function(data) {

		// log data to the console so we can see
		console.log(data.firstName);
		document.getElementById("firstName").value =data.firstName
		document.getElementById("name").value =data.name
		document.getElementById("email").value =data.email


		document.getElementById("codePostal").value =data.codePostal
		// here we will handle errors and validation messages
	});

	// stop the form from submitting the normal way and refreshing the page


}
