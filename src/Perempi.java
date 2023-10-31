public class Perempi extends BelaDiri {
    private String tokoh;

    public Perempi(String tokoh, String materi){
        super(materi);
        this.tokoh = tokoh;
    }

    public void setTokoh(String tokoh){
        this.tokoh = tokoh;
    }
    public String getTokoh(){
        return tokoh;
    }
}
