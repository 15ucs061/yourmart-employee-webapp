function sortTable(index) {
	// alert("Cell index is: " + i);
	var table, rows, switching, i, x, y, shouldSwitch;
	table = document.getElementById("myTable");
	switching = true;
	while (switching) {
		switching = false;
		rows = table.rows;
		for (i = 0; i < (rows.length - 1); i++) {
			shouldSwitch = false;
			x = rows[i].getElementsByTagName("TD")[index];
			y = rows[i + 1].getElementsByTagName("TD")[index];
			if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
				shouldSwitch = true;
				break;
			}
		}
		if (shouldSwitch) {
			rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
			switching = true;
		}
	}
}

$(document).ready(function() {
	$("#myInput").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$("#myTable tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	});
});

function filterText() {
	var rex = new RegExp($('#filterText').val());
	if (rex == "/all/") {
		clearFilter()
	} else {
		$('.content').hide();
		$('.content').filter(function() {
			return rex.test($(this).text());
		}).show();
	}
}

function clearFilter() {
	$('.filterText').val('');
	$('.content').show();
}