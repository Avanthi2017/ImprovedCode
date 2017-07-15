package com.tek.interview.question;



import java.util.Map;

class OrderUtil {

	public static double rounding(double value) {
		return (double)(Math.round(value * 100) / 100d);
	}

	/**
	 * receives a collection of orders. For each order, iterates on the order lines and calculate the total price which
	 * is the item's price * quantity * taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without taxes for this order
	 */
	public void calculatePrice(Map<String, Order> o) {

		double grandtotal = 0;
		// Iterate through the orders
		for (Map.Entry<String, Order> entry : o.entrySet()) {
			System.out.println("*******" + entry.getKey()+ "*******");

			Order order = entry.getValue();

			double totalTax = 0;
			double total = 0;

			// Iterate through the items in the order
			
			for (int i = 0; i < order.size(); i++) {

				// Calculate the taxes
				double tax = 0;
			

				if (order.get(i).getItem().getDescription().contains("imported")) {
					tax = rounding(order.get(i).getItem().getPrice() * 0.15);
					System.out.println("imported"+tax);// Extra 5% tax on
					// imported items
				} else {
					tax = rounding(order.get(i).getItem().getPrice() * 0.10);
				}

				// Calculate the total price
				 double totalprice = order.get(i).getItem().getPrice() + tax;

				// Print out the item's total price
				System.out.println(order.get(i).getItem().getDescription() + ": " + rounding(totalprice));

				// Keep a running total
				totalTax += tax;
				total += order.get(i).getItem().getPrice();
			}

			// Print out the total taxes
			System.out.println("Sales Tax: " + rounding(totalTax));

			total = total + totalTax;

			// Print out the total amount
			System.out.println("Total: " + rounding(total - totalTax));
			grandtotal += (total - totalTax);
		}

		System.out.println("Sum of orders: " + rounding(grandtotal));
	}
}

