package com.lmig.gfc.invoicify.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Invoice {
	// This needs an id - done
	// This needs a many-to-one relationship to a company named "company" - done
	// This needs a many-to-one relationship to a user named "createdBy" - done
	// This needs a string named "invoiceNumber" - done
	// This needs a one-to-many relationship for a list of invoice line items mapped
	// by "invoice" with a cascade type of ALL - done
	// This needs getters and setters - done

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String invoiceNumber;

	@ManyToOne
	private Company company;

	@ManyToOne
	private User createdBy;

	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
	private List<InvoiceLineItem> invoiceItems;

	public Invoice() {
	}

	public Invoice(Long id, String invoiceNumber, Company company, User createdBy, List<InvoiceLineItem> invoiceItems) {
		super();
		this.id = id;
		this.invoiceNumber = invoiceNumber;
		this.company = company;
		this.createdBy = createdBy;
		this.invoiceItems = invoiceItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public List<InvoiceLineItem> getInvoiceItems() {
		return invoiceItems;
	}

	public void setInvoiceItems(List<InvoiceLineItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}

}
