
	//var nom =$('#name').val();
	//var age =$('#age').val();
    //     url: "http://localhost:8080/api/users", // the method we are
$(document).ready(function() {

    // process the form
    $('form').submit(function(event) {

        // get the form data
        // there are many ways to get this data using jQuery (you can use the class or id also)
        var formData = {
        	'id' : 0,
            'name' : $('#name').val(), //$('input[name=name]').val(),
            'age'  : $('#age').val() //$('input[name=email]').val()
        };

        // process the form
        $.ajax({
            type        : 'POST', // define the type of HTTP verb we want to use (POST for our form)
            url         : 'http://localhost:8080/api/users/add', // the url where we want to POST
            data        : formData, // our data object
            dataType    : 'jsonp', // what type of data do we expect back from the server
            encode      : true,
            crossDomain: true
        })
            // using the done promise callback
            .done(function(data) {

                // log data to the console so we can see
                console.log(data); 

                // here we will handle errors and validation messages
            });

        // stop the form from submitting the normal way and refreshing the page
        event.preventDefault();
    });

});
