package com.customer.discountcalculator.calculator;

import java.math.BigDecimal;

import com.customer.discountcalculator.customeradapter.CustomerDiscount;
import com.customer.discountcalculator.domain.DiscountType;

public interface DiscountCalculator {
	BigDecimal calculate(CustomerDiscount discount, BigDecimal total);

	DiscountType getDiscountType();
}
