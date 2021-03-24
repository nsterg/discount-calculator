package com.customer.discountcalculator.service;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.customer.discountcalculator.calculator.DiscountCalculator;
import com.customer.discountcalculator.customeradapter.Customer;
import com.customer.discountcalculator.customeradapter.FakeCustomerAdapter;
import com.customer.discountcalculator.customeradapter.CustomerDiscount;
import com.customer.discountcalculator.domain.Discount;
import com.customer.discountcalculator.domain.DiscountType;
import com.customer.discountcalculator.domain.Order;
import com.customer.discountcalculator.domain.OrderDiscount;

@Service
public class DiscountService {

	private FakeCustomerAdapter adapter;
	private Map<DiscountType, DiscountCalculator> map = new HashMap<>();

	public DiscountService(FakeCustomerAdapter adapter, List<DiscountCalculator> calculators) {
		this.adapter = adapter;
		this.map = calculators.stream().collect(toMap(DiscountCalculator::getDiscountType, c -> c));
	}

	public List<OrderDiscount> calculate(Order order) {
		List<OrderDiscount> discounts = new ArrayList<>();
		Customer customer = adapter.fetchCustomer(order.getCustomerNumber());
		BigDecimal total = order.getAmount();
		List<CustomerDiscount> orderedByPriority = customer.getDiscounts().stream().sorted(Comparator.comparingInt(CustomerDiscount::getPriority)).collect(toList());
		for (CustomerDiscount d : orderedByPriority) {
			OrderDiscount orderDiscount = toOrderDiscount(d, total);
			discounts.add(orderDiscount);
			total = total.subtract(orderDiscount.getDiscount().getAmount());
		}
		return discounts;
	}

	private OrderDiscount toOrderDiscount(CustomerDiscount d, BigDecimal total) {
		OrderDiscount orderDisc = new OrderDiscount();
		orderDisc.setName(d.getName());
		orderDisc.setDiscount(toDiscount(d, total));
		return orderDisc;
	}

	private Discount toDiscount(CustomerDiscount d, BigDecimal total) {
		Discount disc = new Discount();
		disc.setPercentage(d.getPercentage());
		DiscountCalculator calculator = map.get(DiscountType.valueOf(d.getDiscountType()));
		disc.setAmount(calculator.calculate(d, total));
		return disc;
	}

}
