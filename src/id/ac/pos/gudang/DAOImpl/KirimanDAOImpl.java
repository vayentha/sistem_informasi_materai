/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.DAOImpl;

import id.ac.pos.gudang.DAO.KirimanDAO;
import id.ac.pos.gudang.entity.Kiriman;
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
public class KirimanDAOImpl implements KirimanDAO {

    ResultSet result;
    private Connection conn;
    PreparedStatement state;
    
    @Override
    public ArrayList<Produk> getNamaProduk(String jenis) {
        ArrayList<Produk> arrayProduk = null;
        try {
            conn = DatabaseConnectivity.getConnection();

            String SELECT = "SELECT distinct(nama_produk) FROM `tb_produk` where"
                        + " id_jenis_produk='" + jenis + "' ORDER BY nama_produk ASC";
            
            state = conn.prepareStatement(SELECT);

            result = state.executeQuery();
            if (result != null) {
                arrayProduk = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Produk produk = new Produk();
                    produk.setNama_produk(result.getString(1));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(KirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(KirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(KirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return arrayProduk;

    }

    @Override
    public ArrayList<Produk> getKopur(String jenis, String nama_produk) {
         ArrayList<Produk> arrayProduk = null;
        try {
            conn = DatabaseConnectivity.getConnection();

            String SELECT = "SELECT harga_produk FROM `tb_produk` where"
                        + " id_jenis_produk='" + jenis + "' and nama_produk = '"+nama_produk+"'";
            
            state = conn.prepareStatement(SELECT);

            result = state.executeQuery();
            if (result != null) {
                arrayProduk = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Produk produk = new Produk();
                    produk.setHarga_produk(Long.parseLong(result.getString(1)));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }

        } catch (SQLException | IOException | InterruptedException ex) {
            Logger.getLogger(KirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return arrayProduk;
    }

    @Override
    public boolean SimpanKiriman(Kiriman kiriman) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(KirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(KirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String INSERT = "INSERT INTO tb_kiriman VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, kiriman.getG14());
            state.setDate(2, new java.sql.Date(kiriman.getTanggal().getTime()));
            state.setString(3, kiriman.getNo_seal());
            state.setString(4, Integer.toString(kiriman.getJumlah_ktg()));
            state.setString(5, kiriman.getNo_dus());
            state.setString(6, kiriman.getId_kantor());
            state.setString(7, kiriman.getId_produk());
            state.setString(8,Integer.toString(kiriman.getJumlah()) );
            state.setString(9,Long.toString(kiriman.getBesar_uang()) );
            state.setString(10,kiriman.getNo_ktg() );

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(KirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public String getIdProduk(String nama_produk) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(KirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String id_produk = null;
        String SELECT = "select id_produk from tb_produk where nama_produk = '"+nama_produk+"'";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {

                    //mengambil 1 data
                    id_produk = result.getString(1);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(KirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id_produk;
    }

    @Override
    public ArrayList<Kiriman> tampilTabel(String jenis) {
        ArrayList<Kiriman> Array_kiriman = new ArrayList<>();
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(KirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String SELECT = "SELECT * FROM `tb_kiriman` inner join tb_produk on tb_kiriman.id_produk = tb_produk.id_produk WHERE tb_kiriman.id_produk LIKE '" + jenis + "%'";
        state = null;

        try {
            state = conn.prepareStatement(SELECT);
            result = state.executeQuery();
            if (result != null) {

                // selama result memiliki data
                // return lebih dari 1 data
                while (result.next()) {
                    Kiriman kiriman = new Kiriman();
                    
                    kiriman.setG14(result.getString(1));
                    kiriman.setTanggal(result.getDate(2));
                    kiriman.setNo_seal(result.getString(3));
                    kiriman.setJumlah_ktg(Integer.parseInt(result.getString(4)));
                    kiriman.setNo_dus(result.getString(5));
                    kiriman.setId_kantor(result.getString(6));
                    kiriman.setJumlah(Integer.parseInt(result.getString(8)));
                    kiriman.setBesar_uang(Long.parseLong(result.getString(9)));
                    kiriman.setNo_ktg(result.getString(10));
                    kiriman.setNama_produk(result.getString(12));
                    kiriman.setKopur(result.getString(13));

                    Array_kiriman.add(kiriman);

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(KirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return Array_kiriman;
    }


    

}
