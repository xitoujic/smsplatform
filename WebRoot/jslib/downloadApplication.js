$(document).ready(function() {

	$('#downloadApplication').click(function(event) {
		if (this == event.target) {
			$('#care').css('display', 'block');
		}
	});

	$('#close_IMG').click(function(event) {
		if (this == event.target) {
			$('#care').fadeOut("slow");
		}
	});

	$('#care_footer_yes').click(function() {
		$.ajax( {
			url : 'downloadApplyAction.action',
			type : 'GET',
			dataType : 'application/pdf',
			error : function() {
				alert('error');
			},
			success : function() {
				if (typeof (download_file.iframe) == "undefined") {
					var iframe = document.createElement("iframe");
					download_file.iframe = iframe;
					document.body.appendChild(download_file.iframe);
					download_file.iframe.height = '0';
					download_file.iframe.width = '0';
				}
				download_file.iframe.height = '0';
				download_file.iframe.width = '0';
				download_file.iframe.src = 'downloadApplyAction.action';
				download_file.iframe.style.display = "none";
			}

		});

	});

	$('#care_footer_no').click(function() {
		$('#care').fadeOut("slow");
	});
});
