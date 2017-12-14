package com.lmig.gfc.invoicify.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.invoicify.models.Company;
import com.lmig.gfc.invoicify.models.FlatFeeBillingRecord;
import com.lmig.gfc.invoicify.models.User;
import com.lmig.gfc.invoicify.services.BillingRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;
import com.lmig.gfc.invoicify.services.UserRepository;

@Controller
@RequestMapping("/billing-records/flat-fees")
public class FlatFeeBillingRecordController {

	private UserRepository ur;
	private CompanyRepository cr;
	private BillingRepository br;

	public FlatFeeBillingRecordController(UserRepository ur, CompanyRepository cr, BillingRepository br) {
		this.ur = ur;
		this.cr = cr;
		this.br = br;
	}

	@PostMapping("")
	public ModelAndView create(FlatFeeBillingRecord record, long clientId, Authentication auth) {
		// Get the user from the auth.getPrincipal() method
		User user = (User) auth.getPrincipal();
		// Find the client using the client id
		Company company = cr.findOne(clientId);
		// Set the client on the record
		record.setClient(company);
		// Set the user on the record for the created by property
		record.setCreatedBy(user);
		// Save the record
		br.save(record);
		return new ModelAndView("redirect:/billing-records");
	}

}
