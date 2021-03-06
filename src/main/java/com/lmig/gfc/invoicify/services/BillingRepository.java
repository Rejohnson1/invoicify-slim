package com.lmig.gfc.invoicify.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lmig.gfc.invoicify.models.BillingRecord;

@Repository
public interface BillingRepository extends JpaRepository<BillingRecord, Long> {

	List<BillingRecord> findByClientIdAndInvoiceLineItemIsNull(Long clientId);
}
