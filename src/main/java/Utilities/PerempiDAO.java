/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

/**
 *
 * @author lenovo
*/
import Model.Perempi;
import java.sql.*;
import java.util.ArrayList;

public class PerempiDAO {
    private Connection con;
    private String url;
    private String uname;
    private String pass;
    private Statement stmt;
    public String query;
    
    public PerempiDAO(){
        url = "jdbc:mysql://localhost/ db_gendara";
        uname = "root";
        pass = "";
        this.setConnectionAndStatement();
    }
    private void setConnectionAndStatement(){
        try {
            con = DriverManager.getConnection(url,uname,pass);
            stmt = con.createStatement();
        } catch (SQLException ex){
            System.err.print(ex.getMessage());
            System.exit(1);
        }
    }
    public void save (Perempi perempi){
        try {
            query = "INSERT INTO perempi VALUES ('%s','%s','%s')";
            query = String.format(
                    query,
                    perempi.getId(),
                    perempi.getTokoh(),
                    perempi.getMateri());
            stmt.executeUpdate(query);
            System.out.println("Berhasil menambahkan data!");
        } catch (SQLException ex){
            System.err.print("Error inserting data: " + ex.getMessage());
            System.exit(1);
        }
    }
    public Perempi get(String id){
        Perempi perempi = null;
        
        try{
            query = "SELECT * FROM perempi WHERE idNumber = '%s'";
            query = String.format(query,id);
            ResultSet rs = stmt.executeQuery(query);
            
            if(rs.next() != false){
                perempi = new Perempi (
                            rs.getString("idNumber"),
                        rs.getString("img"),
                            rs.getString("tokoh"),
                            rs.getString("materi"));
            }else{
                System.out.println("Data tidak ditemukan");
                System.exit(0);
            }
        } catch (SQLException ex){
            System.err.print("Error getting the data: " + ex.getMessage());
            System.exit(1);
        }
        return perempi;
    }
    public ArrayList<Perempi> getAll(){
        ArrayList<Perempi> allMateri = new ArrayList<>();
        
        try{
            query = "SELECT * FROM perempi ORDER BY CAST(idNumber AS UNSIGNED)";
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                allMateri.add(new Perempi(
                        rs.getString(1),
                       rs.getString(2),
                     rs.getString(3),
                rs.getString(4)));
            }
        } catch (SQLException ex){
            System.out.print("Error getting the data: " + ex.getMessage());
            System.exit(1);
        }
        return allMateri;       
    }
    public void update(Perempi perempi){
        try{
            query = "UPDATE perempi SET idNumber='%s', tokoh='%s', materi='%s'" 
                    + "WHERE idNumber= '%s'";
            query = String.format(query,
                    perempi.getId(),
                    perempi.getTokoh(),
                    perempi.getMateri());
            stmt.executeUpdate(query);
            System.out.println("Berhasil update Data");
        } catch (SQLException ex){
            System.err.print("Error updating data: " + ex.getMessage());
            System.exit(1);
        }
    }
    public void delete(Perempi perempi){
        try{
            query = "DELETE FROM perempi WHERE idNumber='%s'";
            query = String.format(query, perempi.getId());
            stmt.executeUpdate(query);
            System.out.println("Berhasil menghapus data!");
        } catch (SQLException ex){
            System.err.print("Error deleting data: " + ex.getMessage());
            System.exit(1);
        }
    }
}
