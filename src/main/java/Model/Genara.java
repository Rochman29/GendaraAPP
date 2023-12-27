/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author lenovo
 */
import java.util.ArrayList;

public class Genara {
    private String pengirim;

    private String pesan;

    public Genara(String pengirim, String pesan) {
        this.pengirim = pengirim;
        this.pesan = pesan;
    }

    public String getPengirim() {
        return pengirim;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPengirim(String pengirim) {
        this.pengirim = pengirim;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
    
    
}
