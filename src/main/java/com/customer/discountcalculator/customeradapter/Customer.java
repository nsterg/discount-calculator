package com.customer.discountcalculator.customeradapter;

import java.util.List;

public class Customer {

	private String customerNumber;
	private List<CustomerDiscount> discounts;

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public List<CustomerDiscount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<CustomerDiscount> discounts) {
		this.discounts = discounts;
	}

}
