public class Main {
    public static void main(String[] args) {
        System.out.println("Login Admin");

        Admin admin1 = new Admin("rohman", "rohman@gmail.com", "Oman123", "Oman321");

        System.out.println("Nama: " + admin1.getNama());
        System.out.println("Email: " + admin1.getEmail());
        System.out.println("Username: " + admin1.getUsername());
        System.out.println("Password: " + admin1.getPassword());

        Member member1 = new Member("farel", "farel@gmail.com", "moker123", "moker321", 20);
        Member member2 = new Member("sayid", "sayid@gmail.com", "idul123", "idul321", 20);


        System.out.println("####################################################");
        System.out.println("Kasus Laporan");

        
        member1.lapor("Saya mengalami pelecehan seksual pada hari senin", "Jam 12 siang");
        System.out.println("Nama: " + member1.getNama());
        System.out.println("Umur: " + member1.getUmur());
        System.out.println("Kronologis: " + member1.getLaporan().getKronologis());
        System.out.println("Waktu: " + member1.getLaporan().getWaktu());
        System.out.println("Status Laporan: " + member1.getLaporan().getStatus());

        admin1.setLaporan(member1.getLaporan());
        admin1.getLaporan().setStatus("Verified");

        System.out.println("Status Laporan: " + member1.getLaporan().getStatus());

        Education edukasi = new Education();

        System.out.println("Materi Bela Diri");
        BelaDiri belaDiri1 = new BelaDiri("Tendang bagian bawah laki-laki");
        admin1.addBelaDiri(edukasi, belaDiri1);
        admin1.showBelaDiri(edukasi);

        System.out.println("Materi Tokoh Inpiratif");
        Perempi perempi1 = new Perempi("Maudy Ayunda", "Belajarlah hingga ke negeri China");
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

