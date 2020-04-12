package kz.iitu.assignment7.controller;

import kz.iitu.assignment7.model.Author;
import kz.iitu.assignment7.model.Book;
import kz.iitu.assignment7.model.Category;
import kz.iitu.assignment7.repository.AuthorRepository;
import kz.iitu.assignment7.repository.BookRepository;
import kz.iitu.assignment7.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getBooksById(@PathVariable("id") Long id) {
        return bookRepository.findById(id).get();
    }

    @PostMapping("/createBook")
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/updateBook/{id}")
    public Book updateBook(@PathVariable Long id,
                           @RequestBody Book book) {
        book.setId(id);
        return bookRepository.save(book);
    }

    @DeleteMapping("/deleteBook/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}
