/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Model.BelaDiri;
import Model.BelaDiri1;
import Utilities.BelaDiri1DAO;
import Utilities.BelaDiriDAO;
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
public class HapusMateriController implements Initializable {
    private static BelaDiriDAO dao = new BelaDiriDAO();
    private static BelaDiri1DAO dao1 = new BelaDiri1DAO();

    @FXML
    private TextField nomerMateri;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back(MouseEvent event) throws IOException {
        if ("1".equals(App.belaDiri)){
            App.setRoot("tips");
        } else if ("2".equals(App.belaDiri)){
            App.setRoot("tips1");
        }
    }

    @FXML
    private void hapus(MouseEvent event) throws IOException {
        var alert = new Alert(Alert.AlertType.INFORMATION);
        if (App.belaDiri.equals("1")){
            dao.delete(nomerMateri.getText());
            alert.setContentText("Berhasil menghapus data");
            alert.show();
            App.setRoot("tips");
       } else if (App.belaDiri.equals("2")){
           dao1.delete(  nomerMateri.getText());
           alert.setContentText("Berhasil menghapus data");
           alert.show();
           App.setRoot("tips1");
       }
    }
    
}
