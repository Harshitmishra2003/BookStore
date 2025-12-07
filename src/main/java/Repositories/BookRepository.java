@Entity
@Data
package Repositories;

public interface BookRepository extends JpaRepository<Book,Long> {
	Page<Book>findByTitleContainingIgnoreCase(String title, Pageable pageable);

}
