package awa.service;

import awa.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> findAll();

    public void save(User user);

    public void deleteById(Integer id);

    public Optional<User> findById(Integer id);

    public Optional<User> findByEmail(String email);
}
