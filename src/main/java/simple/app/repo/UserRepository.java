package simple.app.repo;

import org.springframework.data.repository.CrudRepository;
import simple.app.models.Users;

public interface UserRepository extends CrudRepository<Users, Integer> {
 }
