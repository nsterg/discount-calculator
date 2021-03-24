package com.customer.discountcalculator.domain;

import java.math.BigDecimal;

public class Order {

	private BigDecimal amount;
	private String customerNumber;

	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

}
