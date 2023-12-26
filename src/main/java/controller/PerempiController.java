/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Model.Perempi;
import Utilities.PerempiDAO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class PerempiController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private Text paragraf;
    @FXML
    private Text tokoh;
    
    
    private ArrayList<Perempi> list;
    private int current = 0;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            var dao = new PerempiDAO();
            this.list = dao.getAll();
            this.setContent();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PerempiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setContent() throws FileNotFoundException {
        this.setImage(list.get(current).getImg());
        tokoh.setText(list.get(current).getTokoh());
        paragraf.setText(list.get(current).getMateri());
    }

    private void setImage(String image) throws FileNotFoundException {
        img.setImage(new Image(new FileInputStream("D:\\Pemrograman Berorientasi Objek\\ProjectGendaraAPP\\src\\main\\java\\image\\" + image)));
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        App.setRoot("educationPages");
    }

    @FXML
    private void next(MouseEvent event) throws FileNotFoundException {
        if (this.current == this.list.size() - 1) {
            this.current = 0;
        } else {
            this.current += 1;
        }
        this.setContent();
    }

    @FXML
    private void prev(MouseEvent event) throws FileNotFoundException {
        if (this.current == 0) {
            this.current = this.list.size() - 1;
        } else {
            this.current -= 1;
        }
        this.setContent();
    }
    
}
