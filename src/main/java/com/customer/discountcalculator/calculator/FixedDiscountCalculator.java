package com.customer.discountcalculator.calculator;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.customer.discountcalculator.customeradapter.CustomerDiscount;
import com.customer.discountcalculator.domain.DiscountType;

@Component
public class FixedDiscountCalculator implements DiscountCalculator{

	public BigDecimal calculate(CustomerDiscount discount, BigDecimal total) {
		return discount.getAmount();
	}

	public DiscountType getDiscountType() {
		return DiscountType.FIXED;
	}

}
