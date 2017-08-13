package com.sample.javafx.views;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AbstractFxmlPane extends Pane implements Initializable{

    private static final String FXML_DIRECTORY = "/fxml";
    private static final String FXML_FILE_STRING_FORMATTER = "%s/%s.fxml";

    private ResourceBundle bundle;

    public AbstractFxmlPane(Class clazz) {
        this(clazz, null, FXML_DIRECTORY);
    }

    private AbstractFxmlPane(Class clazz, ResourceBundle resources, String fxmlDirectory) {
        super();

        String fxmlFilePath = String.format(FXML_FILE_STRING_FORMATTER, fxmlDirectory, clazz.getSimpleName());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFilePath));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        if (null != resources) {
            fxmlLoader.setResources(resources);
        }

        try {
            fxmlLoader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        bundle = resources;
    }
}
