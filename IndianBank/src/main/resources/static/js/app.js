setTimeout(function() {
	$("#userInfoDiv").fadeOut(1000, function() {
		$(this).remove();
	});
}, 8000);

$(document).ready(function() {
	$('.datepicker').datepicker({
		format: 'yyyy-mm-dd',
		autoclose: true,
		todayHighlight: true
	});
});

/*Fast cash js */
$(document).ready(function() {
	// Function to add Fast Cash buttons
	function addFastCashButtons() {
		const fastCashButtons = [1000, 2000, 5000, 10000];
		const buttonsContainer = $("#fast-cash-buttons");

		buttonsContainer.empty(); // Clear any existing buttons

		fastCashButtons.forEach(amount => {
			const button = $('<button type="submit" class="btn btn-primary"></button>');
			button.text(`${amount}`);
			button.click(function() {
				// When a Fast Cash button is clicked, set the input field value
				$("#withdrawal-amount").val(amount);
			});
			buttonsContainer.append(button);
		});
	}

	// Listen for changes in the dropdown
	$("#withdrawal-method").change(function() {
		if ($(this).val() === "Online") {
			// If "Fast Cash" is selected, add the Fast Cash buttons
			addFastCashButtons();
		} else {
			// If another option is selected, remove the Fast Cash buttons
			$("#fast-cash-buttons").empty();
		}
	});
});