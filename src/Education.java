public class Education {
    private BelaDiri[] belaDiri = new BelaDiri[10];
    private Perempi[] perempi = new Perempi[10];

    public void showBelaDiri(){
        for (int i=0; i<jumlahBelaDiri; i++){
            System.out.println(i+1 + ". " + belaDiri[i].getMateri());
        }
    }
    public void showPerempi(){
        for (int i=0; i<jumlahPerempi; i++){
            System.out.println(i+1 + ". " + perempi[i].getTokoh());
            System.out.println(perempi[i].getMateri()); 
        }
    }
    private int jumlahBelaDiri;
    private int jumlahPerempi;

    public void addBelaDiri (BelaDiri belaDiri){
        this.belaDiri[jumlahBelaDiri] = belaDiri;
        jumlahBelaDiri++;
    }
    public void addPerempi (Perempi perempi){
        this.perempi[jumlahPerempi] = perempi;
        jumlahPerempi++;
    }
}
