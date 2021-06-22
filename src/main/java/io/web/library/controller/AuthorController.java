package io.web.library.controller;

import io.web.library.model.Author;
import io.web.library.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    final
    AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/searchAuthors")
    public List<Author> searchAuthors(){

        return authorService.searchAuthors();
    }

    @GetMapping("/searchAuthor/{id}")
    public Author searchAuthor(@PathVariable Long id){
        return authorService.searchAuthor(id);
    }


}
