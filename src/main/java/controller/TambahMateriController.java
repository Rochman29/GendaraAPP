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
import javafx.scene.text.Text;
import main.App;
import static main.App.belaDiri;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class TambahMateriController implements Initializable {
    private static BelaDiriDAO dao = new BelaDiriDAO();
    private static BelaDiri1DAO dao1 = new BelaDiri1DAO();

    @FXML
    private Text nomer;
    @FXML
    private TextField materi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        if (App.belaDiri.equals("1")){
            nomer.setText(1 + dao.getCount() + "");
        } else if (App.belaDiri.equals("2")){
            nomer.setText(1 + dao1.getCount() + "");
        }
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
    private void submit(MouseEvent event) throws IOException {
       var alert = new Alert(Alert.AlertType.INFORMATION);
       
       if (App.belaDiri.equals("1")){
            materi.getText();
            var belaDiri = new BelaDiri(materi.getText());
            dao.save(belaDiri);
            alert.setContentText("Berhasil menambahkan data");
            alert.show();
            App.setRoot("tips");
       } else if (App.belaDiri.equals("2")){
           materi.getText();
           var belaDiri1 = new BelaDiri1(materi.getText());
           dao1.save(belaDiri1);
           alert.setContentText("Berhasil menambahkan data");
           alert.show();
           App.setRoot("tips1");
       }
       
    }

    
}
