package io.web.library.service;

import io.web.library.dao.BookDao;
import io.web.library.model.Book;
import io.web.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookDao {

    final
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book searchBook(Long id) {
        return bookRepository.findById(id).get();

    }

    @Override
    public List<Book> searchBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id) {

        Book book = bookRepository.findById(id).get();

        book.setBookName(book.getBookName());
        book.setYear(book.getYear());
        book.setPrice(book.getPrice());

        return book;
    }

    @Override
    public String deleteBook(Long id) {
        bookRepository.deleteById(id);

        return "Delete book by id: " + id;
    }
}
