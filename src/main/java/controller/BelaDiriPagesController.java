/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.App;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class BelaDiriPagesController implements Initializable {


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void tips(MouseEvent event) throws IOException {
        App.belaDiri = "1";
        App.setRoot("tips");
    }

    @FXML
    private void health(MouseEvent event) throws IOException {
        App.belaDiri = "2";
        App.setRoot("tips1");
        
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        App.setRoot("educationPages");
    }
    
}
