package pp.spring_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pp.spring_security.model.Role;
import pp.spring_security.repo.RoleRepo;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;

    @Autowired
    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepo.findRoleByName(name);
    }

}
