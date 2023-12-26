/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
/**
 *
 * @author lenovo
 */
import java.util.Random;
public class Laporan {
    class randomString{
    public static String generateRandomString() {
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for(int i = 0; i < 5; i++) {
            int index = random.nextInt(alphaNumeric.length());
            char randomChar = alphaNumeric.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
        }
    }
    
    private String idNumber;
    private String username;
    private String nama;
    private String waktu;
    private String kronologis;
    private String status;

    public Laporan(String idNumber, String username, String nama, String waktu, String kronologis, String status) {
        this.idNumber = idNumber;
        this.username = username;
        this.nama = nama;
        this.waktu = waktu;
        this.kronologis = kronologis;
        this.status = status;
    }
    public Laporan(){}
    
    public void setUsername (String username){
        this.username = username;
    }

    public void setNama(String nama){
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
    public void setIdNumber(){
        String idNumber = randomString.generateRandomString();
        System.out.println(idNumber);
        this.idNumber = idNumber;
    }
    public String getUsername(){
        return username;
    }
    public String getNama(){
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
    public String getIdNumber(){
        return idNumber;
    }
}
