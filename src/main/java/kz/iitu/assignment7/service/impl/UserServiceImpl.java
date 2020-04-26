package kz.iitu.assignment7.service.impl;

import kz.iitu.assignment7.model.User;
import kz.iitu.assignment7.repository.UserRepository;
import kz.iitu.assignment7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    @Override
    public void createUser(User user) {
        user.setName(user.getName());
        user.setSurname(user.getSurname());
        user.setUsername(user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.saveAndFlush(user);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);

        if(user == null){
            throw new UsernameNotFoundException("Username not found");
        }
        return (UserDetails) user;
    }
}
