package com.customer.discountcalculator.calculator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.customer.discountcalculator.customeradapter.CustomerDiscount;

public class PercentageDiscountCalculatorTest {

	@Test
	public void shouldCalculate() {
		PercentageDiscountCalculator calculator = new PercentageDiscountCalculator();
		CustomerDiscount disc = new CustomerDiscount();
		disc.setPercentage(new BigDecimal("12.50"));
		BigDecimal actual = calculator.calculate(disc, new BigDecimal("300.00"));
		Assert.assertEquals(new BigDecimal("37.50"), actual);
	}

}
