package io.web.library.controller;

import io.web.library.model.Author;
import io.web.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/authors")
    public List<Author> searchAuthors(){

        return authorService.searchUsers();
    }

    @GetMapping("/author/{id}")
    public Author searchAuthor(@PathVariable Long id){
        return authorService.searchUser(id);
    }


}
