$(document).ready(function() {
	$(function() {
		// Hide the ID input by default
		//$('#name').hide();

		// Listen for changes to the name/id toggle radio buttons
		$('input[name="name-id-toggle"]').change(function() {
			if ($(this).val() === 'name') {
				// If the "name" radio button is selected, show the display name input and hide the ID input
				$('#name').show();
				$('#customerId').hide();
			} else {
				// If the "id" radio button is selected, show the ID input and hide the display name input
				$('#customerId').show();
				$('#name').hide();
				
			}
		});
	});
});