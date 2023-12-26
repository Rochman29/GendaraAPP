/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author lenovo
 */
public class Admin extends User{

    public Admin(String nama, String email, String username, String password){
        super(nama, email, username, password);
    }
    public Admin(){}

    public Laporan verifLaporan (Laporan laporan){   
        this.laporan.add(laporan);
        laporan.setStatus("Verified");
        return laporan;
    }
    public void showLaporan (){
        for(Laporan lap: this.laporan) {
            System.out.println("Daftar Laporan");
            System.out.println("Nama Member: " + lap.getNama());
            System.out.println("Waktu: " + lap.getWaktu());
            System.out.println("Kronologis: " + lap.getKronologis());
            System.out.println("Status: " + lap.getStatus());
        }
    }
    //tambah method verifikasi laporan (mengubah status)
    //bisa melihat daftar keseluruhan daftar laporan member
    
    
    public void addBelaDiri (Education edu, BelaDiri belaDiri){
        edu.addBelaDiri(belaDiri);
    }
    public void addPerempi (Education edu, Perempi perempi){
        edu.addPerempi(perempi);
    }
    
}

