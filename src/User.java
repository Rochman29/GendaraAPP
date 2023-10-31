public class User {
    private String nama;
    private String email;
    private String username;
    private String password;
    protected Laporan laporan = new Laporan();

    public User(String nama, String email, String username, String password){
        this.nama = nama;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getNama(){
        return nama;
    }
    public String getEmail(){
        return email;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public Laporan getLaporan(){
        return laporan;
    }
    public void showBelaDiri (Education edu){
        edu.showBelaDiri();
    }
    public void showPerempi (Education edu){
        edu.showPerempi();
    }
    public void chatting(Genara genara, String chat){
        genara.addPesan(this.getNama(), chat);
        genara.showLastPesan();
    }
}
