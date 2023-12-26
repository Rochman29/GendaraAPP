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
import Model.Member;
import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
    private Connection con;
    private String url;
    private String uname;
    private String pass;
    private Statement stmt;
    public String query;
    
    public MemberDAO(){
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
    public void save (Member member){
        try {
            query = "INSERT INTO user VALUES ('%s','%s','%s','%s','Member')";
            query = String.format(
                    query,
                    member.getNama(),
                    member.getEmail(),
                    member.getUsername(),
                    member.getPassword());
            stmt.executeUpdate(query);
            System.out.println("Berhasil menambahkan data!");
        } catch (SQLException ex){
            System.err.print("Error inserting data: " + ex.getMessage());
            System.exit(1);
        }
    }
    public void saveLapor(Laporan laporan){
        try {
            query = "INSERT INTO laporan VALUES ('%s', '%s', '%s', '%s', '%s', '%s')";
            query = String.format(
                    query,
                    laporan.getIdNumber(),
                    laporan.getUsername(),
                    laporan.getNama(),
                    laporan.getWaktu(),
                    laporan.getKronologis(),
                    laporan.getStatus());
            System.out.println(query);
            stmt.executeUpdate(query);
            System.out.println("Berhasil menambahkan data!");
        } catch (SQLException ex){
            System.err.print("Error inserting data: " + ex.getMessage());
            System.exit(1);
        }
    }
    public Member get(String username, String password){
        Member member = null;
        
        try{
            query = "SELECT * FROM user WHERE username = '%s' AND password = '%s' AND role = 'Member'";
            query = String.format(query,username, password);
            ResultSet rs = stmt.executeQuery(query);
            
            if(rs.next() != false){
                member = new Member (
                            rs.getString("nama"),
                            rs.getString("email"),
                            rs.getString("username"),
                            rs.getString("password"));
            }else{
                System.out.println("Data tidak ditemukan");
                return null;
            }
        } catch (SQLException ex){
            System.err.print("Error getting the data: " + ex.getMessage());
            System.exit(1);
        }
        
        return member;
    }
    public ArrayList<Member> getAll(){
        ArrayList<Member> allMember = new ArrayList<>();
        
        try{
            query = "SELECT * FROM user";
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                allMember.add(new Member(
                        rs.getString(1),
                       rs.getString(2),
                     rs.getString(3),
                     rs.getString(4)));
            }
        } catch (SQLException ex){
            System.out.print("Error getting the data: " + ex.getMessage());
            return null;
        }
        return allMember;
    }
    public void update(Member member){
        try{
            query = "UPDATE user SET nama='%s', email='%s', password='%s' "
                    + "WHERE username= '%s'";
            query = String.format(query,
                    member.getNama(),
                    member.getEmail(),
                    member.getPassword(),
                    member.getUsername());
            stmt.executeUpdate(query);
            System.out.println("Berhasil update Data");
        } catch (SQLException ex){
            System.err.print("Error updating data: " + ex.getMessage());
        }
    }
    public void delete(Member member){
        try{
            query = "DELETE FROM user WHERE username='%s'";
            query = String.format(query, member.getUsername());
            stmt.executeUpdate(query);
            System.out.println("Berhasil menghapus data!");
        } catch (SQLException ex){
            System.err.print("Error deleting data: " + ex.getMessage());
        }
    }
}
