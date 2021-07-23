package io.web.library.service;

import io.web.library.dto.BooksAuthorsDTO;
import io.web.library.model.Author;
import io.web.library.model.Book;
import io.web.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookAuthorService {

    @Autowired
    BookRepository bookRepository;

    public List<BooksAuthorsDTO> searchBooksAuthors(){
        return ((List<Book>) bookRepository
                .findAll())
                .stream()
                .map(this::convertToBookAuthorDTO)
                .collect(Collectors.toList());
    }

    private BooksAuthorsDTO convertToBookAuthorDTO(Book book){
        BooksAuthorsDTO bookAuthorDTO = new BooksAuthorsDTO();
        bookAuthorDTO.setBookId(book.getId());
        bookAuthorDTO.setBookName(book.getBookName());
        bookAuthorDTO.setYear(book.getYear());
        bookAuthorDTO.setPrice(book.getPrice());
        Author author = book.getAuthor();
        bookAuthorDTO.setLastName(author.getLastName());
        return bookAuthorDTO;
    }
}
