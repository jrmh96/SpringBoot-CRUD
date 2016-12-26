$(function(){
	$('#table').Datatable({
		'ajax':{
			'url':'/getAll',
			'dataSrc':''
		},
		"columns": [
			{"data":"firstName"},
			{"data":"lastName"},
			{"data":"jobTitle"},
			{"data":"departmentID"},
			{"data":"updateLink"},
			{"data":"deleteLink"}
		]
	});
});