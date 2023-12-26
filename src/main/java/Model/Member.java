/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author lenovo
 */
import Utilities.MemberDAO;
import java.util.Random;
public class Member extends User{




    
    
    //hanya bisa melihat laporan dia sendiri

    private int umur;
    private String idNumber;
    
    public Member(String nama, String email, String username, String password){
        super(nama, email, username, password);
    }
    public int getUmur(){
        return umur;
    }



    public Laporan lapor(String waktu, String kronologis){
        Laporan laporan = new Laporan();
        laporan.setIdNumber();
        laporan.setUsername(this.getUsername());
        laporan.setNama(this.getNama());
        laporan.setKronologis(kronologis);
        laporan.setWaktu(waktu);
        laporan.setStatus("Unverified");
        this.laporan.add(laporan);
//        admin.verifLaporan(laporan);
         MemberDAO md = new MemberDAO();
         md.saveLapor(laporan);
        return laporan;
    }
}
