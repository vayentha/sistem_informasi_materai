/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.DAOImpl;

import id.ac.pos.gudang.DAO.ProdukDAO;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.utility.DatabaseConnectivity;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Firman
 */
public class ProdukDAOImpl implements ProdukDAO {

    ResultSet result;
    private Connection conn;
    PreparedStatement state;

    @Override
    public String getIdProduk(String jenis) {
        String id_produk = null;
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String SELECT = "select id_produk from tb_produk where id_jenis_produk = '" + jenis + "'";
        state = null;

        try {
            state = conn.prepareStatement(SELECT);
            result = state.executeQuery();
            if (result != null) {

                // selama result memiliki data
                // return lebih dari 1 data
                while (result.next()) {

                    // mengambil 1 data
                    id_produk = result.getString(1);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return id_produk;
    }

    @Override
    public boolean tambahProduk(Produk produk) {
        String id_produk = null;
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String INSERT = "insert into tb_produk VALUES('" + produk.getId_produk() + "','" + produk.getNama_produk() + "','" + produk.getHarga_produk() + "','" + produk.getId_jenis_produk() + "')";
        state = null;

        try {
            state = conn.prepareStatement(INSERT);

            int qty = state.executeUpdate();
            return qty > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;

    }

    @Override
    public ArrayList<Produk> tampiltabel(String jenis) {
        ArrayList<Produk> Array_produk = new ArrayList<>();
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String SELECT = "select * from tb_produk where id_jenis_produk = '" + jenis + "'";
        state = null;

        try {
            state = conn.prepareStatement(SELECT);
            result = state.executeQuery();
            if (result != null) {

                // selama result memiliki data
                // return lebih dari 1 data
                while (result.next()) {
                    Produk produk = new Produk();
                    produk.setId_produk(result.getString(1));
                    produk.setNama_produk(result.getString(2));
                    produk.setHarga_produk(Long.parseLong(result.getString(3)));

                    Array_produk.add(produk);

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return Array_produk;
    }

}
