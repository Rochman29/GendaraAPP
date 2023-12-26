/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Model.TypeUser;
import Utilities.BelaDiriDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import main.App;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class TipsController implements Initializable {

    @FXML
    private Text definisi;
    @FXML
    private Text materi;
    @FXML
    private ScrollPane scrol;
    @FXML
    private AnchorPane ancorcontent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        var dao = new BelaDiriDAO();
        var edu = dao.getAll();
        
        definisi.setText("Menghindari kekerasan seksual adalah suatu kebutuhan penting untuk menjaga keamanan dan kesejahteraan diri. ");
        var text = "";
        var height = 0;
        for (var e: edu) {
            height += 80;
           text += String.format("%s. %s\n", e.getId(), e.getMateri());
        }
        ancorcontent.setMinHeight(height);
        materi.setText(text);
    }    

    @FXML
    private void back(MouseEvent event) throws IOException {
        App.setRoot("belaDiriPages");
    }

    @FXML
    private void tambahMateri(MouseEvent event) throws IOException {
        if (App.typeUser == TypeUser.Admin){
            App.belaDiri = "1";
            App.setRoot("tambahMateri");
        } else {
            var alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Anda bukan Admin");
            alert.show();
        }
    }

    @FXML
    private void hapusMateri(MouseEvent event) throws IOException {
        if (App.typeUser == TypeUser.Admin){
            App.belaDiri = "1";
            App.setRoot("hapusMateri");
        } else {
            var alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Anda bukan Admin");
            alert.show();
        }
    }
    
    
}
