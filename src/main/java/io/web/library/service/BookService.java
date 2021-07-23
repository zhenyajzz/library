package io.web.library.service;

import io.web.library.dao.BookDao;
import io.web.library.model.Book;
import io.web.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService implements BookDao {

    final
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public Book searchBook(Long id) {
        return bookRepository.findById(id).get();

    }

    @Override
    @Transactional
    public List<Book> searchBooks() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public Book updateBook(Long id) {

        Book book = bookRepository.findById(id).get();

        book.setBookName(book.getBookName());
        book.setYear(book.getYear());
        book.setPrice(book.getPrice());

        return book;
    }

    @Override
    @Transactional
    public String deleteBook(Long id) {
        bookRepository.deleteById(id);

        return "Delete book by id: " + id;
    }
}
