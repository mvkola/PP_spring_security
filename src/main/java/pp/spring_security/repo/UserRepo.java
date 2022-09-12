package pp.spring_security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pp.spring_security.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}