package main;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lenovo
 */

import Model.Admin;
import Model.Laporan;
import Model.Member;
import Model.TypeUser;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class App extends Application{
    private static Scene scene;
    public static TypeUser typeUser;
    public static Admin admin;
    public static Member member;
    public static Laporan laporan;
    public static String belaDiri;
    
    @Override
    public void start(Stage stage) throws IOException {
        setRoot("welcome");
        stage.setTitle("Gendara");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        
        
    }
    
    public static void setRoot(String fxml) throws IOException {
//        if (fxml.equals("genara")) {
//            var alert = new Alert(Alert.AlertType.INFORMATION, "Coming Soon!!");
//            alert.showAndWait();
//            return;
//        }
        if (scene == null) scene = new Scene(loadFXML(fxml), 610, 400);
        else scene.setRoot(loadFXML(fxml));
    }
    
    public static Parent loadFXML(String fxml) throws IOException {
        var url = new File("src/main/java/view/" + fxml + ".fxml").toURI().toURL();
        Parent result = FXMLLoader.load(url);
        return result;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
