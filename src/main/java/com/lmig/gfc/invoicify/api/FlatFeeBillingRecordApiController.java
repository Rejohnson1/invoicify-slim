package com.lmig.gfc.invoicify.api;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.invoicify.models.Company;
import com.lmig.gfc.invoicify.models.FlatFeeBillingRecord;
import com.lmig.gfc.invoicify.models.User;
import com.lmig.gfc.invoicify.services.BillingRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;

@RestController
@RequestMapping("/api/billing-records/flat-fees")
public class FlatFeeBillingRecordApiController {

	private BillingRepository billingRepository;
	private CompanyRepository companyRepository;

	public FlatFeeBillingRecordApiController(BillingRepository billingRepository, CompanyRepository companyRepository) {
		this.billingRepository = billingRepository;
		this.companyRepository = companyRepository;
	}

	@PostMapping("")
	public FlatFeeBillingRecord create(@RequestBody FlatFeeBillingRecord record, Authentication auth) {
		User user = (User) auth.getPrincipal();
		record.setCreatedBy(user);
		Company client = companyRepository.findOne(record.getClient().getId());
		record.setClient(client);
		return billingRepository.save(record);
	}
}