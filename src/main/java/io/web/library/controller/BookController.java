package io.web.library.controller;

import io.web.library.model.Book;
import io.web.library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    final
    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String searchBooks(Model model) {
        List<Book> listBooks = bookService.searchBooks();
        model.addAttribute("listBooks", listBooks);
        return "books";
    }

    @GetMapping("/book/{id}")
    public String searchBookById(@PathVariable Long id, Model model) {

        Book book = bookService.searchBook(id);
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/book-create")
    public String createBookForm(Book book){
        return "book-create";
    }

    @PostMapping("/book-create")
    public String createBook(Book book){
        bookService.createBook(book);

        return "redirect:/books";
    }

    @GetMapping("/book-update/{id}")
    public String updateBookForm(@PathVariable Long id , Model model){

        Book book = bookService.updateBook(id);
        model.addAttribute("book",book);

        return "book-update";
    }

    @PostMapping("/book-update")
    public String updateBook(Book book){

        bookService.createBook(book);

        return "redirect:/books";
    }

    @GetMapping("/book-delete/{id}")
    public String removeBookById(@PathVariable Long id){

        bookService.deleteBook(id);

        return "redirect:/books";
    }
}
