package io.web.library.dao;

import io.web.library.model.User;

import java.util.List;

public interface UserDao {

    User searchUser(Long id);

    List<User> searchUsers();

    User createUser(User user);

    User updateUser(Long id );

    String deleteUser(Long id);


}
