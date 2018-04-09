$(document).ready(function() {
	window.onload = localStorage.setItem("idUpdate",0);

    $.ajax({
        url: "http://localhost:8080/api/users",

	    // used to hack access-allow-same-origin errors
        // in a wonderful world, the webapp will use a proxy to be on the
        // same host:port :-)
        crossDomain: true,
	    dataType: 'jsonp'
    }).then(function(data) {
    	 var tr;
    	
    	
    	$.each(data, function(i, item) {
    		console.log(item);
    		tr = $('<tr/>');
//    		tr.append("<td>" + item.id + "</td>");
    		tr.append("<td>" + item.firstName + "</td>");
    		tr.append("<td>" + item.name + "</td>");
    		tr.append("<td>" + item.email + "</td>");
    		tr.append("<td>" + "********" + "</td>");  		
    		tr.append("<td>"+"<button  id='boutonUpdateRemove' onclick='update( "+item.id+")' value='update' ><img src='ressources/images/icon-edit.png' /></button>"+"<button id='boutonUpdateRemove' onclick='remove( "+item.id+")' value='remove' ><img src='ressources/images/icon-delete.png' /></button>"+"</td>");
    		$('table').append(tr);

        });
      
    });
});

function update(id){
	localStorage.setItem("idUpdate",id)
	window.location.href="form.html"
}

function remove(id){
    


        // get the form data
        // there are many ways to get this data using jQuery (you can use the class or id also)
        var formData = {'id' : id};

        // process the form
        $.ajax({
            type        : 'POST', // define the type of HTTP verb we want to use (POST for our form)
            url         : 'http://localhost:8080/api/users/remove', // the url where we want to POST
            data        : formData, // our data object
            dataType    : 'jsonp', // what type of data do we expect back from the server
            encode      : true,
            crossDomain: true
        }).done(function(data) {

                // log data to the console so we can see
                console.log(data); 
                location.reload();
                // here we will handle errors and validation messages
            });

        // stop the form from submitting the normal way and refreshing the page

}

function rechercheById() {
	var id = localStorage.getItem("idRecherche");
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
//		document.getElementById("firstName").value =data.firstName
//		document.getElementById("name").value =data.name
//		document.getElementById("email").value =data.email
//
//
//		document.getElementById("codePostal").value =data.codePostal
		// here we will handle errors and validation messages
	});

	// stop the form from submitting the normal way and refreshing the page


}
