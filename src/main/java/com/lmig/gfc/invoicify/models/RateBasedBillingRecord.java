package com.lmig.gfc.invoicify.models;

import javax.persistence.Entity;

@Entity
public class RateBasedBillingRecord extends BillingRecord {
	// This does NOT need an id because it inherits it from the BillingRecord class
	// This needs a double field named rate - done
	// This needs a double field named quantity - done
	// This needs to override the getTotal() method and return the product of the
	// rate and quantity - done
	// This needs getters and setters - done

	private double rate;
	private double quantity;

	public RateBasedBillingRecord() {
	}

	public RateBasedBillingRecord(double rate, double quantity) {
		this.rate = rate;
		this.quantity = quantity;
	}

	@Override
	public double getTotal() {
		return rate * quantity;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

}
