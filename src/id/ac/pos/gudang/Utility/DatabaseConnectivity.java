/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.utility;

import com.mysql.jdbc.Driver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dea
 */
public class DatabaseConnectivity {

    private static Connection conn;
    private static Process runtimeProcess;

    public static Connection getConnection() throws IOException, InterruptedException {
        try {
                String url = "jdbc:mysql://localhost:3306/db_materai";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new Driver());
                conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectivity.class.getName()).log(Level.SEVERE, null, ex);
        }

//            String error = ex.getMessage();
//            if ("Unknown database 'db_inventory_pos'".equals(error)) {
//                String database = "db_inventory_pos";
//
//                runtimeProcess = Runtime.getRuntime().exec("C:\\mysql\\bin\\mysql -u root -e \"create database db_inventory_pos\"");
//
//                String[] kata = new String[]{"C:\\mysql\\bin\\mysql", database, "-uroot", "-e", " source " + path + "\\db_inventory_pos.sql"};
//                runtimeProcess = Runtime.getRuntime().exec(kata);
//                
//                runtimeProcess = Runtime.getRuntime().exec("C:\\mysql\\bin\\mysql -u root -e \"insert into mysql.user(host,user,password) values ('%','radp',PASSWORD('123'));\"");
//                
//                runtimeProcess = Runtime.getRuntime().exec("C:\\mysql\\bin\\mysql -u root -e \"flush privileges;\"");
//                
//                runtimeProcess = Runtime.getRuntime().exec("C:\\mysql\\bin\\mysql -u root -e \"grant all on db_inventory_pos.* to 'radp'@'%';\"");
//                
//                
//            }
//
//            System.out.println("Koneksi database gagal dengan pesan : " + ex.getMessage());
        return conn;
    }
}
