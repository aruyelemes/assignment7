package kz.iitu.assignment7.controller;

import kz.iitu.assignment7.model.User;
import kz.iitu.assignment7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> getAllUsers() {
        return (List<User>) userService.getAllUsers();
    }


    @PostMapping("/register")
    public void createUser(@RequestParam(name = "id") Long id,
                           @RequestParam(name = "surname") String surname,
                           @RequestParam(name = "username") String username,
                           @RequestParam(name = "password") String password) {
        if(userService.findByUsername(username) == null){
            User user = new User(id, surname, username, password);
            userService.createUser(user);
        }else {
            System.out.println("Username already exists");
        }
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response, Authentication auth) {
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return null;
    }


}
