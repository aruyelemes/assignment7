package kz.iitu.assignment7.controller;

import kz.iitu.assignment7.model.Book;
import kz.iitu.assignment7.model.Category;
import kz.iitu.assignment7.model.Genre;
import kz.iitu.assignment7.repository.CategoryRepository;
import kz.iitu.assignment7.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/genres/{id}")
    public Genre getGenreById(@PathVariable("id") Long id) {
        return genreRepository.findById(id).get();
    }

    @PostMapping("/newGenre")
    public Genre newGenre(@RequestBody Genre genre) {
        return genreRepository.save(genre);
    }


    @DeleteMapping("/deleteGenre/{id}")
    public void deleteGenre(@PathVariable Long id) {
        genreRepository.deleteById(id);
    }

}
