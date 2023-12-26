/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Utilities.AdminDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.App;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class VerifLaporanController implements Initializable {

    @FXML
    private TextField idNumber;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back(MouseEvent event) throws IOException {
        App.setRoot("laporanAdmin");
    }

    @FXML
    private void verifikasi(MouseEvent event) throws IOException {
        var dao = new AdminDAO();
        dao.updateStatus(idNumber.getText());
        var alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Status Laporan berhasil diupdate");
        alert.show();
        App.setRoot("laporanAdmin");
    }
    
}
