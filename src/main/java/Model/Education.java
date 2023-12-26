/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author lenovo
 */
public class Education {
    private String materi;
    private String idNumber;
    private BelaDiri[] belaDiri = new BelaDiri[10];
    private Perempi[] perempi = new Perempi[10];

    public Education() {}
    
    public Education (String materi) {
        this.materi = materi;
    }
    public Education(String idNumber, String materi) {
        this.idNumber = idNumber;
        this.materi = materi;
    }
    public void setMateri(String materi){
        this.materi = materi;
    }
    public String getMateri(){
        return materi;
    }
    public void setId (String id){
        this.idNumber = id;
    }
    public String getId (){
        return idNumber;
    }
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

    //show education

    public void addBelaDiri (BelaDiri belaDiri){
        this.belaDiri[jumlahBelaDiri] = belaDiri;
        jumlahBelaDiri++;
    }
    
    public void addPerempi (Perempi perempi){
        this.perempi[jumlahPerempi] = perempi;
        jumlahPerempi++;
    }
}
