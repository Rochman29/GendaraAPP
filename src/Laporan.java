public class Laporan {
    private Member nama;
    private String waktu;
    private String kronologis;
    private String status;

    public void setNama(Member nama){
        this.nama = nama;
    }
    public void setWaktu(String waktu){
        this.waktu = waktu;
    }
    public void setKronologis(String kronologis){
        this.kronologis = kronologis;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public Member getNama(){
        return nama;
    }
    public String getWaktu(){
        return waktu;
    }
    public String getKronologis(){
        return kronologis;
    }
    public String getStatus(){
        return status;
    }
}
