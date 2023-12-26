/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;
import Model.*;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */

public class Tester {
    public static void main(String[] args){
        LaporanDAO Ld = new LaporanDAO();
        var laporans = Ld.get("Oman");
        for(var l: laporans) {
            System.out.println(l.getIdNumber());
        }
        
//        AdminDAO ADM = new AdminDAO();
//        Admin ad = ADM.get("Oman");
        
//          MemberDAO md = new MemberDAO();
//          Member m1 = md.get("Ozan");
//          
//          Laporan lp = m1.lapor("Jam 02.00 WIB", "Ketika sedang tidur");
//          System.out.println(lp.getIdNumber());
          
//          md.saveLapor(lp);

          
          
          
        
        
//        Perempi m1 = new Perempi ("1", "Maudy Ayunda", "Belajar lah hingga ke negeri China");
//        public ArrayList<Member> member = new ArrayList<Member>();
//        MemberDAO dao = new MemberDAO();
//        dao.getAll();
//          MemberDAO dao = new MemberDAO();
//          ArrayList<Member> allMember = dao.getAll();
//          for(Member m : allMember){
//              System.out.println("Nama: " + m.getNama());
//              System.out.println("Email: " + m.getEmail());
//              System.out.println("Username: " + m.getUsername());
//              System.out.println("Umur: " + m.getUmur());
//              System.out.println("Password " + m.getPassword());
//              System.out.println("");
//          }

//            Laporan l1 = new Laporan();
//            Laporan l2 = new Laporan();
//            LaporanDAO LDAO = new LaporanDAO();
//            Admin a1 = new Admin();
//            AdminDAO ADAO = new AdminDAO();
//            
//            l1 = LDAO.get("Oman");
//            l2 = a1.verifLaporan(l1);
//            
//            LDAO.update(l2);

//          Member m = md.get("Oman");
//          l1 = m.lapor("12 Siang", "siang tadi di jembatan");
//          ld.save(l1);
          
          
//          m.setEmail("ozan123@gmail.com");
//          dao.update(m);
//            MemberDAO md = new MemberDAO();
//            Member m = md.get("Oman");
            
//            LaporanDAO l1 = new LaporanDAO();
//            
//            
//            Laporan la = new Laporan();
//            
//            la = l1.get("Oman");
//            
////            l1 = m.lapor("06.00 WIB", "Saya sedang berkendara motor");
//            AdminDAO ad = new AdminDAO();
////            ad.saveLapor(l1);
//            
//            
//            ad.updateStatus(la);

       // create a string of uppercase and lowercase characters and numbers
       
    }
}
