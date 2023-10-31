import java.util.ArrayList;

public class Genara {
    private ArrayList<String> pengirim = new ArrayList<String>();

    private ArrayList<String> pesan = new ArrayList<String>();

    public void addPesan(String pengirim, String pesan){
        this.pengirim.add(pengirim);
        this.pesan.add(pesan);
    }
    public void showPesan(){
        int n = pengirim.size();
        for(int i = 0; i<n; i++){
            System.out.println("Pengirim: " + pengirim.get(i));
            System.out.println("Pesan: " + pesan.get(i));
        }
    }

    public void showLastPesan() {
        System.out.println("Pengirim: " + pengirim.get(pengirim.size()-1));
        System.out.println("Pesan: " + pesan.get(pesan.size()-1));
    }
}
