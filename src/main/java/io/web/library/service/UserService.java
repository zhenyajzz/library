package io.web.library.service;

import io.web.library.dao.UserDao;
import io.web.library.model.User;
import io.web.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDao {

    final
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User searchUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> searchUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(Long id) {

        User user = userRepository.findById(id).get();

        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        user.setRoles(user.getRoles());

        return user;
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "Delete user by id: " + id;
    }
}
