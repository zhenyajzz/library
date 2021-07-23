package io.web.library.controller;


import io.web.library.dto.BooksAuthorsDTO;
import io.web.library.service.BookAuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookAuthorController {

    final
    BookAuthorService bookAuthorService;

    public BookAuthorController(BookAuthorService bookAuthorService) {
        this.bookAuthorService = bookAuthorService;
    }

    @GetMapping("/booksDtoAuthors")
    public String searchBooksAndAuthors(Model model){
        List<BooksAuthorsDTO> bookAuthorDTO = bookAuthorService.searchBooksAuthors();

        model.addAttribute("bookAuthorDTO", bookAuthorDTO);

        return "books-authors";
    }
}
