package com.example.demo.Service;

import com.example.demo.DAO.UserDAO;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Optional<User> getUserById(Long userId) {
        return Optional.ofNullable(userDAO.findById(userId).orElse(null));
    }
}
