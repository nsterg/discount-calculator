package com.customer.discountcalculator.service;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.customer.discountcalculator.StartApplication;
import com.customer.discountcalculator.domain.Discount;
import com.customer.discountcalculator.domain.Order;
import com.customer.discountcalculator.domain.OrderDiscount;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { StartApplication.class })
public class DiscountServiceTest {

	@Autowired
	private DiscountService service;

	@Test
	public void shouldCalculateDiscounts() {
		Order order = new Order();
		order.setCustomerNumber("cust-123456");
		order.setAmount(new BigDecimal("340.00"));

		List<OrderDiscount> actual = service.calculate(order);

		List<OrderDiscount> expected = asList(
				anOrderDiscount("PriceList Disc", "17.00" ,"5.00"),
				anOrderDiscount("Promotion X", "32.30" ,"10.00"),
				anOrderDiscount("Coupon 10EUROS", "10.00" ,null)
				);

		assertEquals(expected, actual);
	}

	private OrderDiscount anOrderDiscount(String name, String discAmount, String discPerc) {
		Discount d = new Discount();
		d.setAmount(new BigDecimal(discAmount));
		if (discPerc!=null) {
			d.setPercentage(new BigDecimal(discPerc));
		}

		OrderDiscount od = new OrderDiscount();
		od.setName(name);
		od.setDiscount(d);
		return od;
	}

}
