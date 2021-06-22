package io.web.library.service;

import io.web.library.dao.AuthorDao;
import io.web.library.model.Author;
import io.web.library.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements AuthorDao {

    final
    AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public Author searchAuthor(Long id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public List<Author> searchAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Long id) {

        Author author = authorRepository.findById(id).get();

        author.setFirstName(author.getFirstName());
        author.setLastName(author.getLastName());

        authorRepository.save(author);
        return author;
    }

    @Override
    public String deleteAuthor(Long id) {

        authorRepository.deleteById(id);
        return "Delete author by id: " + id;
    }
}
