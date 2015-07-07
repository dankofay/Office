$('#show-salaries').click(show);

function show(){
	$.ajax({
		url : "salary/show",
		type : 'GET',
		success : function(data) {
			var content = "";
			for (var i in data) {
				content+="<tr><td>"
				+ data[i].userName+ "</td><td>"
				+ data[i].salaryValue + "</td><td>"
				+ data[i].roles +"</td><tr>";
			}
			$('#content').html(content);
}
	});
}

$('#create-salary').click(function(){
	var json={
			'userId' : $('#userId').val(),
			'dateFrom': $('#dateFrom').val(),
			'dateTo': $('#dateTo').val()}
	$ajax({
		url:"salaries/create",
		type: 'POST',
		data:JSON.stringify(json),
		contentType : "application/json",
		success : function() {
			console.log("OK");
		}
	});
});