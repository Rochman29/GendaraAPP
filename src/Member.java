public class Member extends User{
    private Laporan laporan = new Laporan();

    private int umur;
    
    public Member(String nama, String email, String username, String password, int umur){
        super(nama, email, username, password);
        this.umur = umur;
    }
    public int getUmur(){
        return umur;
    }

    public Laporan lapor(String kronologis, String waktu){
        laporan.setKronologis(kronologis);
        laporan.setStatus("Unverified");
        laporan.setWaktu(waktu);
        return laporan;
    }
}
