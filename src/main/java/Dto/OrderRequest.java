@Data
package Dto;

public class OrderRequest {

	private Long userId;
	private List<OrderItemDto>items;
}
@Data
public class OrderItemDto {
	private Long bookId;
	private int quantity;
}
