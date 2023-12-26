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
import javafx.scene.input.MouseEvent;
import main.App;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class LoginPagesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logMember(MouseEvent event) throws IOException {
        App.typeUser = TypeUser.Member;
        App.setRoot("login");
    }

    @FXML
    private void logAdmin(MouseEvent event) throws IOException {
        App.typeUser = TypeUser.Admin;
        App.setRoot("login");
    }
    
}
