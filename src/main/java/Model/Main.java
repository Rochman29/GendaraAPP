/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author lenovo
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Login Admin");

        Admin admin1 = new Admin("rohman", "rohman@gmail.com", "Oman123", "Oman321");

        System.out.println("Nama: " + admin1.getNama());
        System.out.println("Email: " + admin1.getEmail());
        System.out.println("Username: " + admin1.getUsername());
        System.out.println("Password: " + admin1.getPassword());

        Member member1 = new Member("farel", "farel@gmail.com", "moker123", "moker321");
        Member member2 = new Member("sayid", "sayid@gmail.com", "idul123", "idul321");


        System.out.println("####################################################");
        System.out.println("Kasus Laporan");

        
        member1.lapor("Jam 12 siang", "Saya mengalami pelecehan seksual pada hari senin");
        System.out.println("idNumber");
        System.out.println("Nama: " + member1.getNama());
        System.out.println("Umur: " + member1.getUmur());
        var laporan  = member1.getLaporan();
        System.out.println("Kronologis: " + laporan.get(laporan.size() - 1).getKronologis());
        System.out.println("Waktu: " + laporan.get(laporan.size() - 1).getWaktu());
        System.out.println("Status Laporan: " + laporan.get(laporan.size() - 1).getStatus());

        admin1.verifLaporan(laporan.get(laporan.size() - 1));

        System.out.println("Status Laporan: " + laporan.get(laporan.size() - 1).getStatus());

        Education edukasi = new Education();

        System.out.println("Materi Bela Diri");
        BelaDiri belaDiri1 = new BelaDiri("1","Tendang bagian bawah laki-laki");
        admin1.addBelaDiri(edukasi, belaDiri1);
        admin1.showBelaDiri(edukasi);

        System.out.println("Materi Tokoh Inpiratif");
        Perempi perempi1 = new Perempi("1", "p", "Maudy Ayunda", "Belajarlah hingga ke negeri China");
        admin1.addPerempi(edukasi, perempi1);
        admin1.showPerempi(edukasi);
        

        System.out.println("Ruang Chat");
        Genara ruangChat1 = new Genara();

        member1.chatting(ruangChat1, "Halo Bang");
        member2.chatting(ruangChat1, "Halo juga ker");
        admin1.chatting(ruangChat1, "Yoo");

        member1.showBelaDiri(edukasi);

    }
}

