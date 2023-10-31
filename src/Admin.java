public class Admin extends User{

    public Admin(String nama, String email, String username, String password){
        super(nama, email, username, password);
    }

    public void setLaporan (Laporan laporan){   
        this.laporan = laporan;
    }
    
    public void addBelaDiri (Education edu, BelaDiri belaDiri){
        edu.addBelaDiri(belaDiri);
    }
    public void addPerempi (Education edu, Perempi perempi){
        edu.addPerempi(perempi);
    }
    
}
