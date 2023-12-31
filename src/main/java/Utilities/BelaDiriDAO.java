/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

/**
 *
 * @author lenovo
 */
import Model.BelaDiri;
import java.sql.*;
import java.util.ArrayList;

public class BelaDiriDAO {
    private Connection con;
    private String url;
    private String uname;
    private String pass;
    private Statement stmt;
    public String query;
    
    public BelaDiriDAO(){
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
    
    public void save (BelaDiri belaDiri){
        try {
            query = "INSERT INTO beladiri VALUES ('%d','%s', 'Admin')";
            query = String.format(
                    query,
                    this.getCount() + 1,
                    belaDiri.getMateri());
            stmt.executeUpdate(query);
            System.out.println("Berhasil menambahkan data!");
        } catch (SQLException ex){
            System.err.print("Error inserting data: " + ex.getMessage());
            System.exit(1);
        }
    }
    public BelaDiri get(String id){
        BelaDiri belaDiri = null;
        
        try{
            query = "SELECT * FROM beladiri WHERE idNumber = '%s'";
            query = String.format(query,id);
            ResultSet rs = stmt.executeQuery(query);
            
            if(rs.next() != false){
                belaDiri = new BelaDiri (
                            rs.getString("idNumber"),
                            rs.getString("materi"));
            }else{
                System.out.println("Data tidak ditemukan");
                System.exit(0);
            }
        } catch (SQLException ex){
            System.err.print("Error getting the data: " + ex.getMessage());
            System.exit(1);
        }
        return belaDiri;
    }
    
    public Integer getCount(){
        
        try{
            query = "SELECT COUNT(*) FROM beladiri";
            ResultSet rs = stmt.executeQuery(query);
            
            if(rs.next() != false){
                return rs.getInt(1);
            }else{
                return 0;
            }
        } catch (SQLException ex){
            System.err.print("Error getting the data: " + ex.getMessage());
            return 0;
        }
    }
    public ArrayList<BelaDiri> getAll(){
        ArrayList<BelaDiri> allMateri = new ArrayList<>();
        
        try{
            query = "SELECT * FROM beladiri ORDER BY CAST(idNumber AS UNSIGNED)";
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                allMateri.add(new BelaDiri(
                        rs.getString(1),
                       rs.getString(2)));
            }
        } catch (SQLException ex){
            System.out.print("Error getting the data: " + ex.getMessage());
            System.exit(1);
        }
        return allMateri;       
    }
    public void update(BelaDiri belaDiri){
        try{
            query = "UPDATE beladiri SET idNumber='%s', materi='%s'" 
                    + "WHERE idNumber= '%s'";
            query = String.format(query,
                    belaDiri.getId(),
                    belaDiri.getMateri());
            stmt.executeUpdate(query);
            System.out.println("Berhasil update Data");
        } catch (SQLException ex){
            System.err.print("Error updating data: " + ex.getMessage());
            System.exit(1);
        }
    }
    public void delete(BelaDiri belaDiri){
        try{
            query = "DELETE FROM beladiri WHERE idNumber='%s'";
            query = String.format(query, belaDiri.getId());
            stmt.executeUpdate(query);
            System.out.println("Berhasil menghapus data!");
        } catch (SQLException ex){
            System.err.print("Error deleting data: " + ex.getMessage());
            System.exit(1);
        }
    }
    public void delete(String belaDiri){
        try{
            query = "DELETE FROM beladiri WHERE idNumber='%s'";
            query = String.format(query, belaDiri);
            stmt.executeUpdate(query);
            System.out.println("Berhasil menghapus data!");
        } catch (SQLException ex){
            System.err.print("Error deleting data: " + ex.getMessage());
            System.exit(1);
        }
    }
}
