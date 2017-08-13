package com.sample.javafx.controllers;

import com.sample.javafx.views.LoginView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppController {

    @Autowired
    private LoginView loginView;

    public void initialize(final Stage primaryStage) {
        Scene scene = new Scene(loginView);
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
