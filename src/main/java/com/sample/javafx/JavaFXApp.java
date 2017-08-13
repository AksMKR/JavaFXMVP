package com.sample.javafx;

import com.sample.javafx.controllers.AppController;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaFXApp extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaFXAppConfiguration.class);
        AppController appController = (AppController) context.getBean("appController");
        appController.initialize(primaryStage);
    }
}
