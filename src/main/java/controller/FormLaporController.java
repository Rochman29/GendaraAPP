/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Model.Laporan;
import Utilities.LaporanDAO;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.App;
import static main.App.laporan;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class FormLaporController implements Initializable {

   
    @FXML
    private TextField kronologi;
    
    @FXML
    private DatePicker myDatePicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void kirimLaporan(MouseEvent event) throws IOException {
        var alert = new Alert(Alert.AlertType.INFORMATION);
        if (myDatePicker.getValue().equals("")) {
            alert.setContentText("waktu tidak boleh kosong");
            alert.show();
            return;
        } 
        if (kronologi.getText().equals("")) {
            alert.setContentText("Kronologi tidak boleh kosong");
            alert.show();
            return;
        }
        
        var dao = new LaporanDAO();
        App.member.lapor(myDatePicker.getValue().toString(), kronologi.getText());
        alert.setContentText("Laporan berhasil dibuat");
        alert.show();
        App.setRoot("laporanPages");
        
        
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        App.setRoot("laporanPages");
    }

    @FXML
    private void showDate(MouseEvent event) {
        myDatePicker.show();
        myDatePicker.getValue().toString();
    }

}
