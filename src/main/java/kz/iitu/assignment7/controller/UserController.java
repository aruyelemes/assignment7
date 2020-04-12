package kz.iitu.assignment7.controller;

import kz.iitu.assignment7.model.Book;
import kz.iitu.assignment7.model.Category;
import kz.iitu.assignment7.model.User;
import kz.iitu.assignment7.repository.CategoryRepository;
import kz.iitu.assignment7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }

    @PostMapping("/newUser")
    public User newUser(@RequestBody User user) {
        return userRepository.save(user);
    }


    @DeleteMapping("/deleteUser/{id}")
    public void deleteBook(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
