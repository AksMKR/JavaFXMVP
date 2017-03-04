package com.sample.javafx.controllers;


import com.sample.javafx.dao.User;
import com.sample.javafx.views.LoginView;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginView loginView;

    private User defaultUser;

    @PostConstruct
    private void init() {
        defaultUser = new User("admin", "1234");
        setActionForLoginButton();
    }

    public void initialize(final Stage primaryStage) {

        Scene scene = new Scene(loginView);
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setActionForLoginButton() {
        loginView.onLoginButtonAction(eventHandler -> {
            String username = loginView.getUserName();
            String password = loginView.getPassword();

            if (username.equals(defaultUser.getUserName()) && password.equals(defaultUser.getPassword())) {
                LOG.info("Login success");
                Platform.exit();
            } else {
                LOG.info("Wrong username or password");
            }
        });
    }
}
