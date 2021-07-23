package io.web.library.dao;

import io.web.library.model.Book;

import java.util.List;

public interface BookDao {

    Book searchBook(Long id);

    List<Book> searchBooks();

    Book createBook(Book book);

    Book updateBook(Long id);

    String deleteBook(Long id);
}
