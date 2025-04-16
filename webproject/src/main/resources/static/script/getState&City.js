$(document).ready(function () {
			// Function to populate the state select box
			function populateStates() {
				const stateSelect = $('#stateCode');
				stateSelect.empty(); // Clear existing options

				// Add a default "Select State" option
				stateSelect.append($('<option>', {
					value: '',
					text: 'Select State...'
				}));


				// Make an AJAX request to GeoNames API to retrieve Indian states
				$.ajax({
					url: `http://api.geonames.org/children?geonameId=1269750&username=swashrayeelocation&type=json`,
					method: 'GET',
					dataType: 'json',
					success: function (data) {
						console.log(data)
						// Populate the state select box with data from the GeoNames API
						data.geonames.forEach(function (state) {
							stateSelect.append($('<option>', {
								value: state.geonameId,
								text: state.name
							}));
						});
					},
					error: function (error) {
						console.error('Error fetching states:', error);
					}
				});
			}

			// Function to populate the city select box based on the selected state
			function populateCities(geonameId) {
				const citySelect = $('#cityCode');
				citySelect.empty(); // Clear existing options

				// Add a default "Select City" option
				citySelect.append($('<option>', {
					value: '',
					text: 'Select City'
				}));

				// Make an AJAX request to GeoNames API to retrieve cities in the selected state
				$.ajax({
					url: `http://api.geonames.org/children?geonameId=${geonameId}&username=swashrayeelocation&type=json`,
					method: 'GET',
					dataType: 'json',
					success: function (data) {
						// Populate the city select box with data from the GeoNames API
						data.geonames.forEach(function (city) {
							citySelect.append($('<option>', {
								value: city.geonameId,
								text: city.name
							}));
						});
					},
					error: function (error) {
						console.error('Error fetching cities:', error);
					}
				});
			}

			// Populate the state select box on page load
			populateStates();

			// Handle change event of the state select box
			$('#stateCode').on('change', function () {
				
				const selectedStateGeonameId = $(this).val();
				console.log("selectedStateGeonameId----"+selectedStateGeonameId)
				if (selectedStateGeonameId) {
					// Populate the city select box based on the selected state's Geoname ID
					populateCities(selectedStateGeonameId);
				} else {
					// Clear the city select box if no state is selected
					$('#cityCode').empty();
				}
			});


		});