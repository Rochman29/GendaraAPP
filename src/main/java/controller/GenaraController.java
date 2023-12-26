/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Model.TypeUser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import main.App;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class GenaraController implements Initializable {


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void education(MouseEvent event) throws IOException {
        App.setRoot("educationPages");
    }

    @FXML
    private void genara(MouseEvent event) throws IOException {
        App.setRoot("genara");
    }

    @FXML
    private void lapor(MouseEvent event) throws IOException {
        if (App.typeUser == TypeUser.Admin){
            App.setRoot("laporanAdmin");
        }else {
            App.setRoot("laporanPages");
        }
    }

    @FXML
    private void home(MouseEvent event) throws IOException {
        App.setRoot("home");
    }
    
}
