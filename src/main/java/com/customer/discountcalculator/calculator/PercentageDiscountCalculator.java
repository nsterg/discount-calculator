package com.customer.discountcalculator.calculator;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.customer.discountcalculator.customeradapter.CustomerDiscount;
import com.customer.discountcalculator.domain.DiscountType;

@Component
public class PercentageDiscountCalculator implements DiscountCalculator{

	private static final BigDecimal HUNDRED = new BigDecimal("100.00");

	public BigDecimal calculate(CustomerDiscount discount, BigDecimal total) {
		return total.multiply(discount.getPercentage()).divide(HUNDRED);
	}

	public DiscountType getDiscountType() {
		return DiscountType.PERCENTAGE;
	}

}
