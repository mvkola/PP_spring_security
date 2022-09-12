package pp.spring_security.service;

import pp.spring_security.model.Role;

public interface RoleService {
    Role findRoleByName(String name);
}
