package pp.spring_security.service;

import pp.spring_security.model.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {
    @Transactional
    List<User> findAllUsers();

    @Transactional
    User findUserById(Long id);

    @Transactional
    User findByUsername(String username);

    @Transactional
    void saveUser(User user);

    @Transactional
    void updateUser(Long id, User updatedUser);

    @Transactional
    void deleteUser(Long id);

}
