package com.sample.javafx.controllers;


import com.sample.javafx.dao.User;
import com.sample.javafx.views.LoginView;
import javafx.scene.Parent;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginView loginView;

    private User defaultUser;

    @PostConstruct
    private void init() {
        defaultUser = new User("admin", "1234");
    }

    public boolean isValidUser(User user) {
        return defaultUser.equals(user);
    }

    public Parent getLoginView() {
        return loginView;
    }
}
