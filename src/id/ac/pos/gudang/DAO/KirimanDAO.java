/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.DAO;

import id.ac.pos.gudang.entity.Kiriman;
import id.ac.pos.gudang.entity.Produk;
import java.util.ArrayList;

/**
 *
 * @author Firman
 */
public interface KirimanDAO {
    ArrayList<Produk> getNamaProduk(String jenis);
    ArrayList<Produk> getKopur(String jenis, String nama_produk);
    boolean SimpanKiriman (Kiriman kiriman); 
    ArrayList<Kiriman> tampilTabel(String jenis);
    String getIdProduk(String nama_produk);
    
    
}
