package com.sample.javafx;

import com.sample.javafx.controllers.LoginController;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaFXApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaFXAppConfiguration
                .class);
        LoginController loginController = (LoginController) context.getBean("loginController");
        loginController.initialize(primaryStage);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
