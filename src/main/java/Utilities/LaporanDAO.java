/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

/**
 *
 * @author lenovo
 */
import Model.Laporan;
import java.sql.*;
import java.util.ArrayList;

public class LaporanDAO {
    private Connection con;
    private String url;
    private String uname;
    private String pass;
    private Statement stmt;
    public String query;
    
    public LaporanDAO(){
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
    public void saveLapor (Laporan laporan){
        try {
            query = "INSERT INTO laporan VALUES ('%s','%s','%s', '%s', '%s', '%s', '%s')";
            query = String.format(
                    query,
                    laporan.getUsername(),
                    laporan.getNama(),
                    laporan.getWaktu(),
                    laporan.getKronologis(),
                    laporan.getStatus(),
                    laporan.getUsername(),
                    "Admin");
            stmt.executeUpdate(query);
            System.out.println("Berhasil menambahkan data!");
        } catch (SQLException ex){
            System.err.print("Error inserting data: " + ex.getMessage());
            System.exit(1);
        }
    }
    public ArrayList<Laporan> get(String username){
        Laporan laporan = null;
        ArrayList<Laporan> res = new ArrayList<>();
        
        try{
            query = "SELECT * FROM laporan WHERE username = '%s'";
            query = String.format(query,username);
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next() != false){
                laporan = new Laporan (
                            rs.getString("idNumber"),
                            rs.getString("username"),
                            rs.getString("nama"),
                            rs.getString("waktu"),
                            rs.getString("kronologis"),
                            rs.getString("status"));
                res.add(laporan);
            }
        } catch (SQLException ex){
            System.err.print("Error getting the data: " + ex.getMessage());
            System.exit(1);
        }
        
        return res;
    }
    public ArrayList<Laporan> getAll(){
        ArrayList<Laporan> allLaporan = new ArrayList<>();
        
        try{
            query = "SELECT * FROM laporan";
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                allLaporan.add(new Laporan(
                        rs.getString(1),
                       rs.getString(2),
                     rs.getString(3),
                    rs.getString(4),
                rs.getString(5),
                rs.getString(6)));
            }
        } catch (SQLException ex){
            System.out.print("Error getting the data: " + ex.getMessage());
            System.exit(1);
        }
        return allLaporan;       
    }
    public void update(Laporan laporan){
        try{
            query = "UPDATE laporan SET status='%s'" 
                    + "WHERE username= '%s'";
            query = String.format(query,
                    laporan.getStatus(),
                    laporan.getUsername());
            stmt.executeUpdate(query);
            System.out.println("Berhasil update Data");
        } catch (SQLException ex){
            System.err.print("Error updating data: " + ex.getMessage());
            System.exit(1);
        }
    }
    public void delete(Laporan laporan){
        try{
            query = "DELETE FROM laporan WHERE username='%s'";
            query = String.format(query, laporan.getUsername());
            stmt.executeUpdate(query);
            System.out.println("Berhasil menghapus data!");
        } catch (SQLException ex){
            System.err.print("Error deleting data: " + ex.getMessage());
            System.exit(1);
        }
    }
}
