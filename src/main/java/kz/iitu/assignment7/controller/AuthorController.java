package kz.iitu.assignment7.controller;

import kz.iitu.assignment7.model.Author;
import kz.iitu.assignment7.model.Category;
import kz.iitu.assignment7.repository.AuthorRepository;
import kz.iitu.assignment7.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("")
    public List<Author> getAllAuthors() {
        return (List<Author>) authorRepository.findAll();
    }

    @GetMapping("/authors/{id}")
    public Author getAuthorById(@PathVariable("id") Long id) {
        return authorRepository.findById(id).get();
    }

    @PostMapping("/createAuthor")
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @PutMapping("/updateAuthor/{id}")
    public Author updateAuthor(@PathVariable Long id,
                               @RequestBody Author author) {
        author.setId(id);
        return authorRepository.save(author);
    }

    @DeleteMapping("/deleteAuthor/{id}")
    public void deleteAuthor(@PathVariable Long id){
         authorRepository.deleteById(id);
    }
}
