function handleResponse(response) {
	var messageContainer = document.getElementById('messageContainer');
	if (response.status === 'success') {
		messageContainer.innerHTML = '<p class="success-message">' + response.message + '</p>';
	} else {
		messageContainer.innerHTML = '<p class="error-message">' + response.message + '</p>';
	}
	messageContainer.style.display = 'block'; // Show the message container
}


///// TO GIVE RECEIPT NUMBER TO ALL OF THE INPUTS IN TABLE ROW THAT ARE HIDDEN FROM THE INPUT ABOVE THE TABLE
const input1 = document.getElementById('receiptNoInput');
const input1value = input1.value;
localStorage.setItem('inputValue1', input1value);
const inputElements = document.querySelectorAll('#receiptNo');

function updateInputValues(value) {
	input1.value = value;
	inputElements.forEach((input) => {
		input.value = value;
	});
}

document.addEventListener('DOMContentLoaded', () => {
	const storedValue = localStorage.getItem('inputValue1');
	if (storedValue) {
		updateInputValues(storedValue);
		localStorage.removeItem('inputValue1');
	}
});

//input1.addEventListener('input', () => {
//	updateInputValues(input1.value);
//});

///// HIDE THE BUTTON IF THE SAVE BUTTON IS CLICKED
// Get all buttons with the specified class
const buttons = document.querySelectorAll('#saveBtn');

// Add event listeners to each button
buttons.forEach(button => {
	button.addEventListener('click', function() {
		// this.style.background = "#FF0000";
		this.style.display = 'none';
	});
});



///// TO MAKE THE TOTAL OF THE COLLECION AMOUNT FROM THE TABLE INPUT
const collectionamount = document.querySelectorAll('#collectionAmount');
//document.getElementById('total').style.display = "none"
var total;
function totalAmount() {
	total = 0
	collectionamount.forEach((input) => {
		if (input.value == "") {
			input.value = 0;
		}
		var no = parseInt(input.value);
		console.log("fhsdklfjsdlkfjflk;", no)
		total += no;
	});
	console.log("total =====total;", total)
	document.getElementById('total').style.display = "block"
	//document.getElementById('total').textContent = total;
	document.getElementById('total').value = total;
}


///// TO GET THE VALUE FROM SEND SMS CHECKBOX SWITCH TO INPUT TEXT IN FORM
document.addEventListener('DOMContentLoaded', function() {
	var switchElement = document.getElementById('switch');
	const sendSMSInput = document.querySelectorAll('#sendSMSInput');
	for (var i = 0; i < sendSMSInput.length; i++) {
		sendSMSInput[i].value = 'N';
	}
	switchElement.addEventListener('change', function() {
		var isChecked = switchElement.checked;
		var selectedValue = isChecked ? 'Y' : 'N';
		for (var i = 0; i < sendSMSInput.length; i++) {
			sendSMSInput[i].value = selectedValue;
		}
		//sendSMSInput.value = selectedValue;
	});
});



///// TO GET THE VALUE FROM ONLINE PAYMENT CHECKBOX SWITCH TO INPUT TEXT IN FORM
/*document.addEventListener('DOMContentLoaded', function() {
	var switchElement = document.getElementById('online');
	const onlinePaymentInput = document.getElementById('onlinePaymentInput');
	for (var i = 0; i < onlinePaymentInput.length; i++) {
		onlinePaymentInput[i].value = 'Offline';
	}
	switchElement.addEventListener('change', function() {
		var isChecked = switchElement.checked;
		var selectedValue = isChecked ? 'Online' : 'Offline';
		for (var i = 0; i < onlinePaymentInput.length; i++) {
			onlinePaymentInput[i].value = selectedValue;
		}
		//sendSMSInput.value = selectedValue;
	});
});*/



// Get all the checkboxes
var onlinecheckboxes = document.querySelectorAll('#online');

const onlinePaymentInput = document.querySelectorAll('#onlinePaymentInput');
for (var i = 0; i < onlinePaymentInput.length; i++) {
	onlinePaymentInput[i].value = 'Offline';
}
// Add event listener to each checkbox
onlinecheckboxes.forEach(function(checkbox) {
	checkbox.addEventListener('change', function() {
		// Get the parent row of the checkbox
		var row = this.closest('tr');

		// Get the corresponding onlinePaymentInput field in the row
		var onlinePaymentInput = row.querySelector('#onlinePaymentInput');

		// Update the value based on checkbox checked state
		if (this.checked) {
			onlinePaymentInput.value = 'Online';
		} else {
			onlinePaymentInput.value = 'Offline';
		}
	});
});




