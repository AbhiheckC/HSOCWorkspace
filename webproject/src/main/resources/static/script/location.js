/*document.getElementById("saveBtn").addEventListener("click", function(event) {
  event.preventDefault(); // prevent the default form submission

  // get the user's current location
  navigator.geolocation.getCurrentPosition(function(position) {
	// assign the latitude and longitude values to the hidden input fields
	document.getElementById("latitude").value = position.coords.latitude;
	document.getElementById("longitude").value = position.coords.longitude;

	// submit the form
	document.getElementById("collectionForm").submit();
  }, function(error) {
	// handle errors
	console.log(error.message);
  });
});
console.log("map")*/


document.addEventListener('DOMContentLoaded', () => {
	// get the user's current location
	navigator.geolocation.getCurrentPosition(function(position) {
		// assign the latitude and longitude values to the hidden input fields
		const latitudeElements = document.querySelectorAll('#latitude');
		const longitudeElements = document.querySelectorAll('#longitude');

		const latitude =position.coords.latitude;
		latitudeElements.forEach((input) => {
			input.value = latitude;
		});
		
		const longitude =position.coords.longitude;
		longitudeElements.forEach((input) => {
			input.value = longitude;
		});
		
		console.log(latitude, longitude)
	}, function(error) {
		// handle errors
		console.log(error.message);
	});
});
console.log("map")

//document.getElementById("hehe").textContent="lat--"+position.coords.latitude+"lap--"+position.coords.longitude;
//function getData(){
	//return false;
//}


//document.getElementById("hehe").textContent="lat--"+position.coords.latitude+"lap--"+position.coords.longitude;
//function getData(){
	//return false;
//}
