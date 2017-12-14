package com.lmig.gfc.invoicify.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public abstract class BillingRecord {
	// This needs an id - done
	// This needs a user named createdBy - done
	// This needs a string named description - done
	// This needs an invoice line item named lineItem. It should be a one-to-one
	// relationship mapped by billingRecord - done
	// This needs a company named client that is a many-to-one relationship - done
	// This needs an abstract method that returns a double named getTotal() - done
	// All the getters and setters - done

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private User createdBy;
	private String description;

	@OneToOne(mappedBy = "billingRecord")
	private InvoiceLineItem invoiceLineItem;

	@ManyToOne
	private Company client;

	public BillingRecord() {
	}

	public BillingRecord(Long id, User createdBy, String description, InvoiceLineItem invoiceLineItem, Company client) {
		this.id = id;
		this.createdBy = createdBy;
		this.description = description;
		this.invoiceLineItem = invoiceLineItem;
		this.client = client;
	}

	public abstract double getTotal();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public InvoiceLineItem getInvoiceLineItem() {
		return invoiceLineItem;
	}

	public void setInvoiceLineItem(InvoiceLineItem invoiceLineItem) {
		this.invoiceLineItem = invoiceLineItem;
	}

	public Company getClient() {
		return client;
	}

	public void setClient(Company client) {
		this.client = client;
	}

}
