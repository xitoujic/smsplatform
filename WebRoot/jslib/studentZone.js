$(document).ready(function() {
			$("#notice tbody tr").hover(
					function() {$(this).addClass('highlight');},
					function() {$(this).removeClass('highlight');
			});
});

$(document).ready(function() {
	  $('table.paginated').each(function() {
	    var currentPage = 0;
	    var numPerPage = 10;

	    var $table = $('table.paginated');
	    $table.bind('repaginate', function() {
	      var value1 = $table.find('tbody tr').show();
	        value1.lt(currentPage * numPerPage)
	          .hide()
	        .end()
	        .gt((currentPage + 1) * numPerPage - 1)
	          .hide()
	        .end();
	    });

	    var numRows = $table.find('tbody tr').length;
	    var numPages = Math.ceil(numRows / numPerPage);

	    var $pager = $('<div class="pager"></div>');
	    for (var page = 0; page < numPages; page++) {
	      $('<span class="page-number">' + (page + 1) + '</span>')
	        .bind('click', {'newPage': page}, function(event) {
	          currentPage = event.data['newPage'];
	          $table.trigger('repaginate');
	          $(this).addClass('active').siblings().removeClass('active');
	        })
	        .appendTo($pager).addClass('clickable');
	    }
	    $pager.find('span.page-number:first').addClass('active');
	    $pager.insertBefore($table);
	    $('<br>').insertBefore($table);

	    $table.trigger('repaginate');
	  });
});

