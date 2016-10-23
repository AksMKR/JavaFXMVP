package com.sample.javafx.views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

@Component
public class LoginView extends AbstractFxmlPane {

    @FXML
    private Button loginButton;
    @FXML
    private TextField userText;
    @FXML
    private TextField passwordText;

    public LoginView() {
        super(LoginView.class);
    }

    public void onLoginButtonAction(final EventHandler<ActionEvent> eventHandler) {
        loginButton.setOnAction(eventHandler);
    }

    public String getUserName() {
        return userText.getText();
    }

    public String getPassword() {
        return passwordText.getText();
    }
}
