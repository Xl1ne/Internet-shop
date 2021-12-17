package simple.app.repo;

import org.springframework.data.repository.CrudRepository;
import simple.app.models.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

}
