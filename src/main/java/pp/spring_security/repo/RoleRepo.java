package pp.spring_security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pp.spring_security.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);
}