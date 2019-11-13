package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entitiesEnum.OrderStatus;

public class Order {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	private List <OrderItem> item = new ArrayList<>();
	private Client client;
	
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItem() {
		return item;
	}
	
	public void addItem(OrderItem item) {
		this.item.add(item);
	}
	
	public void removeItem(OrderItem item) {
		this.item.remove(item);
	}
	
	public double total() {

		double sum = 0.0;

		for (OrderItem item : item) {

			sum += item.subTotal();

		}

		return sum;

	}
	
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("\nOrder summary: \n");
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client + "\n");
		sb.append("Order items: \n" );
		
		for (OrderItem item : item) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
	
}
