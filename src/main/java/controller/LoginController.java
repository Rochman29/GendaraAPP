/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Model.TypeUser;
import Utilities.AdminDAO;
import Utilities.MemberDAO;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
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
public class LoginController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submit(MouseEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (username.getText().equals("") || password.getText().equals("")) {
            alert.setContentText("Username dan Password tidak boleh kosong!");
            alert.show();
            return;
        }
        if (App.typeUser == TypeUser.Admin) {
            var dao = new AdminDAO();
            App.admin = dao.get(username.getText(), password.getText());
        } else {
            var dao = new MemberDAO();
            App.member = dao.get(username.getText(), password.getText());
        }
        if (App.admin == null && App.member == null){
            alert.setContentText("Username atau Password salah");
            alert.show();
            return;
        } else {
            alert.setContentText("Login berhasil");
            alert.show();
            App.setRoot("home");
        }
    }

    @FXML
    private void register(MouseEvent event) throws IOException {
        if (App.typeUser == TypeUser.Admin) {
            var alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Anda tidak bisa mendaftar sebagai admin!!");
            alert.show();
            App.setRoot("loginPages");
        } else App.setRoot("register");
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        App.setRoot("loginPages");
    }
}
