package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.userinterface.userinterface;
import sample.Controller;
import sample.Storage.StorageUserinterface;

import javax.imageio.IIOException;


public class application extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{

        userinterface ui= new userinterface(primaryStage);

    }







    public static void main(String[]args){

        launch(args);
    }
}

