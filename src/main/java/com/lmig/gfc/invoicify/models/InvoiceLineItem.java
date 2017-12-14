package com.lmig.gfc.invoicify.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class InvoiceLineItem {

	// This needs an id - done
	// This needs a one-to-one relationship to a billing record named
	// "billingRecord" - done
	// This needs a many-to-one relationship to a user named "createdBy" -done
	// This needs a many-to-one relationship to an invoice named "invoice" - done
	// Lots of getters and setters - done

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	private BillingRecord billingRecord;

	@ManyToOne
	private User createdBy;

	@ManyToOne
	private Invoice invoice;

	public InvoiceLineItem() {
	}

	public InvoiceLineItem(Long id, BillingRecord billingRecord, User createdBy, Invoice invoice) {
		this.id = id;
		this.billingRecord = billingRecord;
		this.createdBy = createdBy;
		this.invoice = invoice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BillingRecord getBillingRecord() {
		return billingRecord;
	}

	public void setBillingRecord(BillingRecord billingRecord) {
		this.billingRecord = billingRecord;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

}
