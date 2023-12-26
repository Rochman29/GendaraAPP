/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Model.Admin;
import Model.Member;
import Model.TypeUser;
import Utilities.AdminDAO;
import Utilities.MemberDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.App;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField namaLengkap;
    @FXML
    private TextField email;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void signUp(MouseEvent event) throws IOException {
        var alert = new Alert(Alert.AlertType.INFORMATION);
        if (namaLengkap.getText().equals("")) {
            alert.setContentText("Nama Lengkap tidak boleh kosong");
            alert.show();
            return;
        }
        if (email.getText().equals("")) {
            alert.setContentText("email tidak boleh kosong");
            alert.show();
            return;
        }
        if (username.getText().equals("")) {
            alert.setContentText("username tidak boleh kosong");
            alert.show();
            return;
        }
        if (password.getText().equals("")) {
            alert.setContentText("password tidak boleh kosong");
            alert.show();
            return;
        }

        var dao = new MemberDAO();
        App.member = new Member(namaLengkap.getText(), email.getText(), username.getText(), password.getText());
        dao.save(App.member);
        alert.setContentText("data tersimpan di database");
        App.setRoot("loginPages");
        alert.show();
        
        
    }
    
}
