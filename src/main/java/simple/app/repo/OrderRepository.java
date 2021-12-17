package simple.app.repo;

import org.springframework.data.repository.CrudRepository;
import simple.app.models.OrderAdd;

public interface OrderRepository extends CrudRepository<OrderAdd, Long> {
}
