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
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
public class LaporanPagesController implements Initializable {

    @FXML
    private TableView<TabelLaporan> laporan;
    
    private ArrayList<Laporan> listLaporan;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        var dao = new LaporanDAO();
        ObservableList<TabelLaporan> data = FXCollections.observableArrayList();
        this.listLaporan = dao.get(App.member.getUsername());
        TableColumn firstCol = new TableColumn("No");
        firstCol.setCellValueFactory(new PropertyValueFactory("no"));
        TableColumn secondCol = new TableColumn("Id Status");
        secondCol.setCellValueFactory(new PropertyValueFactory("idStatus"));
        TableColumn thirdCol = new TableColumn("Waktu");
        thirdCol.setCellValueFactory(new PropertyValueFactory("waktu"));
        TableColumn fourCol = new TableColumn("Kronologi");
        fourCol.setCellValueFactory(new PropertyValueFactory("kronologi"));
        TableColumn fiveCol = new TableColumn("Status");
        fiveCol.setCellValueFactory(new PropertyValueFactory("status"));
        firstCol.setPrefWidth(24.6);
        secondCol.setPrefWidth(64.6);
        thirdCol.setPrefWidth(87.3);
        fourCol.setPrefWidth(257.6);
        fiveCol.setPrefWidth(80.6);
        laporan.setItems(data);
        laporan.getColumns().addAll(firstCol, secondCol, thirdCol, fourCol, fiveCol);
        for (int i = 0; i < this.listLaporan.size(); i++) {
            var lap = this.listLaporan.get(i);
            data.add(new TabelLaporan(i + 1 + "", lap.getIdNumber(), lap.getWaktu(), lap.getKronologis(), lap.getStatus()));
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
        App.setRoot("laporanPages");
    }

    @FXML
    private void home(MouseEvent event) throws IOException {
        App.setRoot("home");
    }

    @FXML
    private void newLapor(MouseEvent event) throws IOException {
        App.setRoot("formLapor");
    }
    
}
