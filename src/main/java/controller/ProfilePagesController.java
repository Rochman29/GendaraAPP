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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.App;
import static main.App.member;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class ProfilePagesController implements Initializable {

    @FXML
    private TextField namaLengkap;
    @FXML
    private TextField email;
    @FXML
    private TextField username;
    @FXML
    private TextField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (App.typeUser == TypeUser.Admin){
            namaLengkap.setText(App.admin.getNama());
            email.setText(App.admin.getEmail());
            username.setText(App.admin.getUsername());
            password.setText(App.admin.getPassword());
        }else{
            namaLengkap.setText(App.member.getNama());
            email.setText(App.member.getEmail());
            username.setText(App.member.getUsername());
            password.setText(App.member.getPassword());
        }
    }    

    @FXML
    private void update(MouseEvent event) throws IOException {
        if (App.typeUser == TypeUser.Admin){
            var dao = new AdminDAO();
            App.admin = new Admin(namaLengkap.getText(), email.getText(), username.getText(), password.getText());
            dao.update(App.admin);
        } else{
            var dao = new MemberDAO();
            App.member = new Member(namaLengkap.getText(), email.getText(), username.getText(), password.getText());
            dao.update(App.member);
        }
        var alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Data berhasil di update");
            alert.show();
            App.setRoot("home");
    }

    @FXML
    private void logout(MouseEvent event) throws IOException {
        App.setRoot("loginPages");
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        App.setRoot("home");
    }
    
}
