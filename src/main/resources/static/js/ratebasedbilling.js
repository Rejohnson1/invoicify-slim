$(function () {
	
	$('#create-ratebased-billing-form').submit(function (e) {
		e.preventDefault();
		
		let ratebasedbilling = {
				rate: $('#rate-dollar-rate').val(),
				quantity: $('#rate-quantity').val(),
				client: { 
					id: $('#rate-client').val() 
				},
				description: $('#rate-description').val()				
		};
				
		let headers = {
				'X-CSRF-TOKEN': $('#rate-csrf').val()	
			};
		
		let settings = {
					url: '/api/billing-records/rate-fees',
					data: JSON.stringify(ratebasedbilling),
					contentType: 'application/json',
					headers: headers	
				};
	
		$.post(settings) 
		.done(function (data) {
			$('#billing-record-list tbody')
				.append(`
						<tr>	
								<td>${ data.createdBy.username }</td>
						        <td>${ data.description }</td>
								<td>${ data.client.name }</td>
								<td>${ data.amount }</td>
								<td>${ data.rate} </td>
								<td>${ data.quantity  }</td>
								<td>${ data.total }  </td>
						  </tr>
                        `);
                        $('#flat-amount').val('');
						$('#flat-client').val('');
						$('#flat-description').val('');
						$('#rate-dollar-rate').val('');
						$('#rate-quantity').val('');
						$('#rate-client').val('');
						$('#rate-description').val('');
					});				
			});
});