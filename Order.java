package com.tek.interview.question;



import java.util.ArrayList;
import java.util.List;
class Order {

	private List<OrderLine> orderLines;

	
	public Order() {
		this.orderLines =  new ArrayList<>();
	}

	public void add(OrderLine o) throws Exception {
		if (o == null) {
			System.err.println("ERROR - Order is NULL");
			throw new IllegalArgumentException("Order is NULL");
		}
		orderLines.add(o);
	}

	public int size() {
		return orderLines.size();
	}

	public OrderLine get(int i) {
		return orderLines.get(i);
	}

	public void clear() {
		this.orderLines.clear();
	}
}