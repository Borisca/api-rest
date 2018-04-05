$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/api/users",

	    // used to hack access-allow-same-origin errors
        // in a wonderful world, the webapp will use a proxy to be on the
        // same host:port :-)
        crossDomain: true,
	    dataType: 'jsonp'
    }).then(function(data) {
    	
    	$.each(data, function(i, item) {
    		console.log(item);
    		$('.greeting-content').append("<br>");
    		$('.greeting-content').append(item.id+" ");
    		$('.greeting-content').append(item.name+" ");
    		$('.greeting-content').append(item.age);
    		$('.greeting-content').append("<br>");
        });
      
    });
});


