package com.lmig.gfc.invoicify.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.invoicify.models.BillingRecord;
import com.lmig.gfc.invoicify.models.Company;
import com.lmig.gfc.invoicify.services.BillingRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;

@Controller
@RequestMapping("/billing-records")
public class BillingRecordController {

	private BillingRepository br;
	private CompanyRepository cr;

	public BillingRecordController(BillingRepository br, CompanyRepository cr) {
		this.br = br;
		this.cr = cr;
	}

	@GetMapping("")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("billing-records/list");
		// Get all the billing records and add them to the model and view with the key
		// "records"
		List<BillingRecord> bills = br.findAll();
		mv.addObject("records", bills);
		// Get all the companies and add them to the model and view with the key
		// "companies"
		List<Company> companies = cr.findAll();
		mv.addObject("companies", companies);
		return mv;
	}

}
