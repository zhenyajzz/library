package io.web.library.dao;

import io.web.library.model.Author;
import io.web.library.model.User;

import java.util.List;

public interface AuthorDao {

    Author searchAuthor(Long id);

    List<Author> searchAuthors();

    Author createAuthor(Author author);

    Author updateAuthor(Long id);

    String deleteAuthor(Long id);


}
