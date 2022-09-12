package pp.spring_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pp.spring_security.exception.NotFoundException;
import pp.spring_security.model.User;
import pp.spring_security.repo.UserRepo;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepo userRepo;
    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, RoleService roleService) {
        this.userRepo = userRepo;
        this.roleService = roleService;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepo.findById(id).orElseThrow(() ->
                new NotFoundException("User not found"));
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }
        return user;
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Transactional
    @Override
    public void updateUser(Long id, User updatedUser) {
        User user = findUserById(id);
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());

        user.getRoles().clear();
        updatedUser.getRoles().forEach(role ->
                user.getRoles().add(roleService.findRoleByName(role.getName())));
        userRepo.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepo.delete(findUserById(id));
    }

}
