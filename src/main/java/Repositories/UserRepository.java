package Repositories;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> FindByEmail(String email);

}
