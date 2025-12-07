@Entity
@Data
package Entities;

public class Order {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@ManyToOne
	private User user;


	private String status;
	private String paymentStatus;


	@OneToMany(mappedBy="order", cascade = CascadeType.ALL)
	private List<OrderItem> items;

}
