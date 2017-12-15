$(function () {
//submit is a function. Generally either submit or a click. 
//submit is broader than click. Submit covers using a button or the enter button.	
//e = event
//preventDefault - stops the submission from happening. Nothing will get submitted if this.	
	$('#create-companies-form').submit(function (e) {
		e.preventDefault();
		
		//{} = create an object.
		//taking the id from the html and putting it in the js
		//.val = value
		//csrf = cross-site request forgery
		
		let company = {
			name: $('#company-name').val()				
			};
		let headers = {
			'X-CSRF-TOKEN': $('#company-csrf').val()	
		};
		
		let settings = {
				url: '/api/admin/companies',
				data: JSON.stringify(company),
				contentType: 'application/json',
				headers: headers	
			};
		
		//get the company and add it to the list in the html
		//append it to the end of the list
		//blank out the company name on the html		
		$.post(settings) 
		.done(function (data) {
			$('#company-list')
				.append(`<li>${data.name}</li>`);
			$('#company-name').val('');
		});
	});
});