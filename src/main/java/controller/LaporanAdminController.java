/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Model.Laporan;
import Model.TabelLaporan;
import Utilities.LaporanDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import main.App;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class LaporanAdminController implements Initializable {

    @FXML
    private TableView<TabelLaporan> laporan;
    
    private ArrayList<Laporan> listLaporan;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        var dao = new LaporanDAO();
        ObservableList<TabelLaporan> data = FXCollections.observableArrayList();
        this.listLaporan = dao.getAll();
        TableColumn firstCol = new TableColumn("No");
        firstCol.setCellValueFactory(new PropertyValueFactory("no"));
        TableColumn secondCol = new TableColumn("Id Status");
        secondCol.setCellValueFactory(new PropertyValueFactory("idStatus"));
        TableColumn thirdCol = new TableColumn("Username");
        thirdCol.setCellValueFactory(new PropertyValueFactory("username"));
        TableColumn fourCol = new TableColumn("Status");
        fourCol.setCellValueFactory(new PropertyValueFactory("status"));
        
        laporan.setItems(data);
        laporan.getColumns().addAll(firstCol, secondCol, thirdCol, fourCol);
        for (int i = 0; i < this.listLaporan.size(); i++){
            var lap = this.listLaporan.get(i);
            data.add(new TabelLaporan(i+1 + "", lap.getUsername(), lap.getIdNumber(), lap.getStatus()));
        }
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
        App.setRoot("laporanAdmin");
    }

    @FXML
    private void verif(MouseEvent event) throws IOException {
        App.setRoot("verifLaporan");
    }

    @FXML
    private void home(MouseEvent event) throws IOException {
        App.setRoot("home");
    }
    
}
