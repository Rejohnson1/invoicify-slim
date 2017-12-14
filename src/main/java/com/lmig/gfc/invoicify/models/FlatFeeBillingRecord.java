package com.lmig.gfc.invoicify.models;

import javax.persistence.Entity;

@Entity
public class FlatFeeBillingRecord extends BillingRecord {

	// This does NOT need an id because it inherits it from the BillingRecord class
	// - done
	// This needs a double field named amount - done
	// This needs to override the getTotal() method and return the amount
	// This needs getters and setters - done

	private double amount;

	public FlatFeeBillingRecord() {
	}

	public FlatFeeBillingRecord(double amount) {
		this.amount = amount;
	}

	@Override
	public double getTotal() {
		return amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
