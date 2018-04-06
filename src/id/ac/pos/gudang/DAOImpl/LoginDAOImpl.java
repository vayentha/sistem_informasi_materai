/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.DAOImpl;

import id.ac.pos.gudang.DAO.LoginDAO;
import id.ac.pos.gudang.utility.DatabaseConnectivity;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author reyhanadp
 */
public class LoginDAOImpl implements LoginDAO {

    ResultSet result;
    private Connection conn;
    PreparedStatement state;

    @Override
    public int getUser(String username, String password) {

        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(LoginDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int sukses = 0;
        
        
        String SELECT = "select * from db_user"
                + " where nik = '"+username+"'"
                + " and password = '"+password+"'";

        state = null;

        try {
            state = conn.prepareStatement(SELECT);
            result = state.executeQuery();
            if (result != null) {

                // selama result memiliki data
                // return lebih dari 1 data
                while (result.next()) {
                
                sukses = 1; 
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoginDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoginDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoginDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return sukses;
    }

}
