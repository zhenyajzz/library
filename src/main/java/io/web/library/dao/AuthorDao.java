package io.web.library.dao;

import io.web.library.model.Author;
import io.web.library.model.User;

import java.util.List;

public interface AuthorDao {

    Author searchUser(Long id);

    List<Author> searchUsers();

    Author createAuthor(Author user);

    Author updateAuthor(Long id );

    String deleteAuthor(Long id);


}
