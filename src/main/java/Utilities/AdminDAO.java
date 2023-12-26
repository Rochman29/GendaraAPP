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
import Model.Admin;
import java.sql.*;
import java.util.ArrayList;

public class AdminDAO {
    private Connection con;
    private String url;
    private String uname;
    private String pass;
    private Statement stmt;
    public String query;
    
    public AdminDAO(){
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
    public void save (Admin admin){
        try {
            query = "INSERT INTO user VALUES ('%s','%s','%s','%s', 'Admin')";
            query = String.format(
                    query,
                    admin.getNama(),
                    admin.getEmail(),
                    admin.getUsername(),
                    admin.getPassword());
            stmt.executeUpdate(query);
            System.out.println("Berhasil menambahkan data!");
        } catch (SQLException ex){
            System.err.print("Error inserting data: " + ex.getMessage());
            System.exit(1);
        }
    }
    public void saveLapor (Laporan laporan){
        try {
            query = "INSERT INTO laporan VALUES ('%s', %s','%s','%s', '%s', '%s')";
            query = String.format(
                    query,
                    laporan.getIdNumber(),
                    laporan.getUsername(),
                    laporan.getNama(),
                    laporan.getWaktu(),
                    laporan.getKronologis(),
                    laporan.getStatus());
            stmt.executeUpdate(query);
            System.out.println("Berhasil menambahkan data!");
        } catch (SQLException ex){
            System.err.print("Error inserting data: " + ex.getMessage());
            System.exit(1);
        }
    }
    
    public Admin get(String username, String password){
        Admin admin = null;
        
        try{
            query = "SELECT * FROM user WHERE username = '%s' AND password = '%s' AND role = 'Admin'";
            query = String.format(query,username, password);
            ResultSet rs = stmt.executeQuery(query);
            
            if(rs.next() != false){
                    admin = new Admin (
                            rs.getString("nama"),
                            rs.getString("email"),
                            rs.getString("username"),
                            rs.getString("password"));
            }else{
                System.out.println("username atau password salah");
                return null;
            }
        } catch (SQLException ex){
            System.err.print("Error getting the data: " + ex.getMessage());
            System.exit(1);
        }
        
        return admin;
    }
    public ArrayList<Laporan> getLaporan(String username){
        LaporanDAO Ld = new LaporanDAO();
        var laporans = Ld.get("Oman");
        
        return laporans;
    }
    public ArrayList<Admin> getAll(){
        ArrayList<Admin> allAdmin = new ArrayList<>();
        
        try{
            query = "SELECT * FROM user WHERE role = 'Admin'";
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                allAdmin.add(new Admin(
                        rs.getString(1),
                       rs.getString(2),
                     rs.getString(3),
                     rs.getString(4)));
            }
        } catch (SQLException ex){
            System.out.print("Error getting the data: " + ex.getMessage());
            System.exit(1);
        }
        return allAdmin;
    }
    public void update(Admin admin){
        try{
            query = "UPDATE user SET nama='%s', email='%s', password='%s' " 
                    + "WHERE username= '%s'";
            query = String.format(query,
                    admin.getNama(),
                    admin.getEmail(),
                    admin.getPassword(),
                    admin.getUsername());
            stmt.executeUpdate(query);
            System.out.println("Berhasil update Data");
        } catch (SQLException ex){
            System.err.print("Error updating data: " + ex.getMessage());
            System.exit(1);
        }
    }
    public void updateStatus (Laporan laporan){
        try{
            query = "UPDATE laporan SET status='verified'" 
                    + "WHERE idNumber='%s'";
            query = String.format(query,
                    laporan.getIdNumber());
            stmt.executeUpdate(query);
            System.out.println("Berhasil update Data");
        } catch (SQLException ex){
            System.err.print("Error updating data: " + ex.getMessage());
            System.exit(1);
        }
    }
    public void updateStatus (String laporan){
        try{
            query = "UPDATE laporan SET status='verified'" 
                    + "WHERE idNumber='%s'";
            query = String.format(query,
                    laporan);
            stmt.executeUpdate(query);
            System.out.println("Berhasil update Data");
        } catch (SQLException ex){
            System.err.print("Error updating data: " + ex.getMessage());
            System.exit(1);
        }
    }
    
    public void delete(Admin admin){
        try{
            query = "DELETE FROM admin WHERE username='%s'";
            query = String.format(query, admin.getUsername());
            stmt.executeUpdate(query);
            System.out.println("Berhasil menghapus data!");
        } catch (SQLException ex){
            System.err.print("Error deleting data: " + ex.getMessage());
            System.exit(1);
        }
    }
}
