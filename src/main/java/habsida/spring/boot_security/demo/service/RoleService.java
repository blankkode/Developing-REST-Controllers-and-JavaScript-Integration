package habsida.spring.boot_security.demo.service;

import habsida.spring.boot_security.demo.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    public List<Role> getAllRoles();

    public Role getRoleById(Long id);

    public void saveRole(Role role);
}
