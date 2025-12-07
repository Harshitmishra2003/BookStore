package Entities;

public class OrderItem {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@ManyToOne
	private Order order;


	@ManyToOne
	private Book book;


	private int quantity;
	private double totalPrice;
}
