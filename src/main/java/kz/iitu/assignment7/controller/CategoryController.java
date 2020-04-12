package kz.iitu.assignment7.controller;

import kz.iitu.assignment7.model.Category;
import kz.iitu.assignment7.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("")
    public List<Category> getAllCategories(){
        return (List<Category>) categoryRepository.findAll();
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable("id") Long id){
        return categoryRepository.findById(id).get();
    }

    @PostMapping("/createCategory")
    public Category createCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }


    @DeleteMapping("/deleteCategory/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }
}
