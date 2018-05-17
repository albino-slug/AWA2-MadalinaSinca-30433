package awa.service;

import awa.model.Role;
import awa.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Boolean save(User user);

    Boolean deleteById(Integer id);

    Optional<User> findById(Integer id);

    Optional<User> findByEmail(String email);

    Optional<User> findByRole(Role role);

    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);

}
