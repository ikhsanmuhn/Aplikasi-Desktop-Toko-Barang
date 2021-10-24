package administrasi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RPL
 */
public class KoneksiDB {
    Connection c;
    Statement s;
    PreparedStatement ps;
    ResultSet rs;
    String query;
    //method untuk koneksi ke driver dan database
    void setConnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error"+ex);
        }
        String local = "jdbc:mysql://localhost:3306/db_toko_oop";
        try {
            c = DriverManager.getConnection(local, "root", "");
        } catch (SQLException ex) {
            System.out.println("Error"+ex);
        }
    }
    //method untuk query select
    void getData(){
        try {
            setConnect();
            s = c.createStatement();
            rs = s.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Error"+ex);
        }
    }
    //method untuk query CRUD
    void setData(){
        try {
            setConnect();
            ps = c.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
