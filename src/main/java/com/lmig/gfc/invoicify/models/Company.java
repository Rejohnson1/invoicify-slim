package com.lmig.gfc.invoicify.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {

	// This needs an id - done
	// This needs a name - done
	// This needs a list of invoice objects named invoices as one-to-many - done
	// relationship mapped by "company" - done
	// Lots of getters and setters - done

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "company")
	private List<Invoice> invoices;

	public Company() {
	}

	public Company(Long id, String name, List<Invoice> invoices) {
		super();
		this.id = id;
		this.name = name;
		this.invoices = invoices;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}
}
