package io.web.library.controller;

import io.web.library.model.Author;
import io.web.library.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthorController {

    final
    AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public String searchAuthors(Model model){
        List<Author> listAuthors = authorService.searchAuthors();
        model.addAttribute("listAuthors", listAuthors);

        return "authors";
    }


    @GetMapping("/author/{id}")
    public String searchAuthor(@PathVariable Long id, Model model) {

        Author author = authorService.searchAuthor(id);
        model.addAttribute("author",author);
        return "author";
    }

    @GetMapping("/author-create")
    public String createAuthorForm(Author author){
        return "author-create";
    }

    @PostMapping("/author-create")
    public String createAuthor(Author author){
        authorService.createAuthor(author);

        return "redirect:/authors";
    }

    @GetMapping("/author-update/{id}")
    public String updateAuthorForm(@PathVariable Long id , Model model){

        Author author = authorService.searchAuthor(id);
        model.addAttribute("author",author);

        return "author-update";
    }

    @PostMapping("/author-update")
    public String updateAuthor(Author author){

        authorService.createAuthor(author);

        return "redirect:/authors";
    }

    @GetMapping("/author-delete/{id}")
    public String removeAuthorById(@PathVariable Long id){

        authorService.deleteAuthor(id);

        return "redirect:/authors";
    }
}
