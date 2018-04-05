$(document).ready(function() {
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
    		tr.append("<td>" + item.id + "</td>");
    		tr.append("<td>" + item.firstName + "</td>");
    		tr.append("<td>" + item.name + "</td>");
    		tr.append("<td>" + item.email + "</td>");
    		$('table').append(tr);

        });
      
    });
});


