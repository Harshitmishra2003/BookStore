@Entity
@Data
package Entities;

public class Book {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String author;
	private String genre;
	private String isbn;
	private double price;
	private String description;
	private int stock;
	private String imageUrl;
}
