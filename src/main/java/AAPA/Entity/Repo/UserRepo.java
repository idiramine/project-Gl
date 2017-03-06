package AAPA.Entity.Repo;

import AAPA.Entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository person for the persistance
 * 
 * @author UJM's students
 */
public interface UserRepo extends CrudRepository<User, Long>{
    Optional<User> findOneByEmail(String email);
    List<User> findAll();
}
