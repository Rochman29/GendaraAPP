/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author lenovo
 */
public class Perempi extends Education {
    private String tokoh;
    private String img;

    public Perempi(String idNumber, String img, String tokoh, String materi){
        super(idNumber, materi);
        this.tokoh = tokoh;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    

    public void setTokoh(String tokoh){
        this.tokoh = tokoh;
    }
    public String getTokoh(){
        return tokoh;
    }
}
