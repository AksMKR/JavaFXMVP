package com.sample.javafx.views;

import com.sample.javafx.controllers.LoginController;
import com.sample.javafx.dao.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.annotation.PostConstruct;
import org.controlsfx.control.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginView extends AbstractFxmlPane {

    @Autowired
    private LoginController loginController;

    @FXML
    private Button loginButton;
    @FXML
    private TextField userText;
    @FXML
    private TextField passwordText;

    public LoginView() {
        super(LoginView.class);
    }

    @PostConstruct
    private void init() {
        loginButton.setOnAction(event -> {
            if (loginController.isValidUser(getUser())) {
                Notifications.create().text("Login successful").showInformation();
            } else {
                Notifications.create().text("Username and/or password incorrect").showError();
            }
        });
    }

    private User getUser() {
        return new User(userText.getText(), passwordText.getText());
    }
}
