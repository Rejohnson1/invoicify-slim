package com.lmig.gfc.invoicify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.invoicify.models.Company;
import com.lmig.gfc.invoicify.services.CompanyRepository;

@Controller
@RequestMapping("/admin/companies")
public class AdminCompaniesController {

	private CompanyRepository cr;

	public AdminCompaniesController(CompanyRepository cr) {
		this.cr = cr;
	}

	@GetMapping("")
	public ModelAndView showDefault() {
		ModelAndView mv = new ModelAndView("admin/companies/default");
		// add companies so you can view them on the HTML
		mv.addObject("companies", cr.findAll());
		return mv;
	}

	@PostMapping("")
	public ModelAndView createCompany(Company company) {
		ModelAndView mv = new ModelAndView("redirect:/admin/companies");
		// Save the company
		cr.save(company);
		return mv;
	}

}
