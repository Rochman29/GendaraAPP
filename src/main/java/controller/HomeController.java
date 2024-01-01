/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Model.TypeUser;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import main.App;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class HomeController implements Initializable {

   
    @FXML
    private Text paragraf1;
    @FXML
    private Text paragraf2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        paragraf1.setText("Kesetaraan gender adalah landasan bagi masyarakat yang adil dan berkelanjutan. Kami percaya bahwa setiap individu, tanpa memandang jenis kelamin, memiliki hak yang sama untuk memperoleh pendidikan, pekerjaan, dan kesempatan sepanjang hidup mereka.");
        paragraf2.setText("Temukan cerita inspiratif dari individu yang telah memimpin perubahan dalam mewujudkan kesetaraan gender. Mereka adalah contoh bagaimana tindakan kecil dapat menciptakan dampak besar. Bersama-sama, kita dapat menciptakan dunia yang menghargai dan memanfaatkan kontribusi semua individu, tanpa memandang jenis kelamin. Mari bergerak bersama menuju kesetaraan gender!");

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

    @FXML
    private void profile(MouseEvent event) throws IOException {
        App.setRoot("profilePages");
    }
}
