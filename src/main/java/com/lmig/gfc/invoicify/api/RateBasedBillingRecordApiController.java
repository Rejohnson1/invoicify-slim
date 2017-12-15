package com.lmig.gfc.invoicify.api;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.invoicify.models.Company;
import com.lmig.gfc.invoicify.models.RateBasedBillingRecord;
import com.lmig.gfc.invoicify.models.User;
import com.lmig.gfc.invoicify.services.BillingRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;

@RestController
@RequestMapping("/api/billing-records/rate-fees")
public class RateBasedBillingRecordApiController {

	private BillingRepository billingRepository;
	private CompanyRepository companyRepository;

	public RateBasedBillingRecordApiController(BillingRepository billingRepository,
			CompanyRepository companyRepository) {
		this.billingRepository = billingRepository;
		this.companyRepository = companyRepository;
	}

	@PostMapping("")
	public RateBasedBillingRecord create(@RequestBody RateBasedBillingRecord record, Authentication auth) {
		User user = (User) auth.getPrincipal();
		record.setCreatedBy(user);
		Company client = companyRepository.findOne(record.getClient().getId());
		record.setClient(client);
		return billingRepository.save(record);
	}
}
