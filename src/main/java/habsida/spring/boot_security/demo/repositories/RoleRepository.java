package habsida.spring.boot_security.demo.repositories;

import habsida.spring.boot_security.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
