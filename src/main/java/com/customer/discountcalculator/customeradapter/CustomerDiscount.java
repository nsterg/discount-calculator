package com.customer.discountcalculator.customeradapter;

import java.math.BigDecimal;

public class CustomerDiscount {

	private String name;
	private BigDecimal percentage;
	private BigDecimal amount;
	private String discountType;
	private int priority;

	public static CustomerDiscount customerDiscountWithPerc(String name, BigDecimal percentage, String discountType, int priority) {
		CustomerDiscount disc = new CustomerDiscount();
		disc.percentage = percentage;
		disc.name = name;
		disc.discountType = discountType;
		disc.priority = priority;
		return disc;
	}

	public static CustomerDiscount customerDiscountFixed(String name, BigDecimal amount, String discountType, int priority) {
		CustomerDiscount disc = new CustomerDiscount();
		disc.amount = amount;
		disc.name = name;
		disc.discountType = discountType;
		disc.priority = priority;
		return disc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPercentage() {
		return percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
