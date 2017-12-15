$(function () {
	
	$('#create-flatfee-billing-form').submit(function (e) {
		e.preventDefault();
		
		let flatfeebilling = {
				amount: $('#flat-amount').val(),			
				client: { id: $('#flat-client').val() },
				description: $('#flat-description').val()				
				};
				
		let headers = {
				'X-CSRF-TOKEN': $('#flatfee-csrf').val()	
			};
		
		let settings = {
					url: '/api/billing-records/flat-fees',
					data: JSON.stringify(flatfeebilling),
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
								<td>${ data.amount || ''}</td>
								<td>${ data.rate || '' }</td>
								<td>${ data.quantity || ''}</td>
								<td>${ data.total || '' }</td>
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