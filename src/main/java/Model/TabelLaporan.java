/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author lenovo
 */
public class TabelLaporan {
    private StringProperty username;
    private StringProperty no;
    private StringProperty idStatus;
    private StringProperty waktu;
    private StringProperty kronologi;
    private StringProperty status;

    public TabelLaporan(String no, String username, String idStatus, String status) {
        this.username = new SimpleStringProperty(username);
        this.no = new SimpleStringProperty(no);
        this.idStatus = new SimpleStringProperty(idStatus);
        this.status = new SimpleStringProperty(status);
    }
    
    public TabelLaporan(String no, String idStatus, String waktu, String kronologi, String status) {
        this.no = new SimpleStringProperty(no);
        this.idStatus = new SimpleStringProperty(idStatus);
        this.waktu = new SimpleStringProperty(waktu);
        this.kronologi = new SimpleStringProperty(kronologi);
        this.status = new SimpleStringProperty(status);
    }
    
    public void setUsername(String value){
        username().set(value);
    }
    
    public void setNo(String value) {
        no().set(value);
    }
    
    public void setIdStatus(String value) {
        idStatus().set(value);
    }
    
    public void setWaktu(String value) {
        waktu().set(value);
    }
    
    public void setKronologi(String value) {
        kronologi().set(value);
    }
    
    public void setStatus(String value) {
        status().set(value);
    }
    
    public String getUsername(){
        return username().get();
    }
    
    public String getNo() {
        return no().get();
    }
    
    public String getIdStatus() {
        return idStatus().get();
    }
    
    public String getWaktu() {
        return waktu().get();
    }
    
    public String getKronologi() {
        return kronologi().get();
    }
    
    public String getStatus() {
        return status().get();
    }
    
    public StringProperty no() {
        if (no == null) no = new SimpleStringProperty(this, "No");
        return no;
    }
    public StringProperty idStatus() {
        if (idStatus == null) idStatus = new SimpleStringProperty(this, "Id Status");
        return idStatus;
    }
    public StringProperty waktu() {
        if (waktu == null) waktu = new SimpleStringProperty(this, "Waktu");
        return waktu;
    }
    public StringProperty kronologi() {
        if (kronologi == null) kronologi = new SimpleStringProperty(this, "Kronologi");
        return kronologi;
    }
    public StringProperty status() {
        if (status == null) status = new SimpleStringProperty(this, "Status");
        return status;
    }

    public StringProperty username(){
        if(username == null) username = new SimpleStringProperty(this, "Username");
        return username;
    }
}
