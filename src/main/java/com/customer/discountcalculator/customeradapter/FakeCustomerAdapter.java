package com.customer.discountcalculator.customeradapter;

import static java.util.Arrays.asList;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class FakeCustomerAdapter {

	public Customer fetchCustomer(String customerNumber) {
		//mock customer data coming from an external system
		CustomerDiscount priceListDisc = CustomerDiscount.customerDiscountWithPerc("PriceList Disc", new BigDecimal("5.00"),"PERCENTAGE", 1);
		CustomerDiscount promotionDisc = CustomerDiscount.customerDiscountWithPerc("Promotion X", new BigDecimal("10.00"),"PERCENTAGE", 2);
		CustomerDiscount couponDisc = CustomerDiscount.customerDiscountFixed("Coupon 10EUROS", new BigDecimal("10.00"),"FIXED", 3);
		Customer customer = new Customer();
		customer.setCustomerNumber(customerNumber);
		customer.setDiscounts(asList(priceListDisc, promotionDisc, couponDisc));
		return customer;
	}
}
