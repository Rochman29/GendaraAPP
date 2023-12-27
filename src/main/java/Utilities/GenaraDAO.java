/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import Model.Admin;
import Model.BelaDiri;
import Model.Genara;
import Model.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class GenaraDAO {
    private Connection con;
    private String url;
    private String uname;
    private String pass;
    private Statement stmt;
    public String query;
    
    public GenaraDAO(){
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
    
    public void addChat (String username, String chat){
        try {
            query = "INSERT INTO genara (username, chat) VALUES ('%s','%s')";
            query = String.format(
                    query,
                    username,
                    chat);
            stmt.executeUpdate(query);
            System.out.println("Berhasil menambahkan data!");
        } catch (SQLException ex){
            System.err.print("Error inserting data: " + ex.getMessage());
        }
    }
    
    public ArrayList<Genara> getAll () {
        var result = new ArrayList<Genara>();
        
        try{
            query = "SELECT user.nama, genara.chat FROM genara, user WHERE user.username = genara.username ORDER BY genara.ID";
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                result.add(
                    new Genara(rs.getString("nama"), rs.getString("chat"))
                );
            }
        } catch (SQLException ex){
            System.out.print("Error getting the data: " + ex.getMessage());
            
        }
        
        return result;
    }
}
