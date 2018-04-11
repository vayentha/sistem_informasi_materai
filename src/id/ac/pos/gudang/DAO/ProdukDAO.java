/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.DAO;

import id.ac.pos.gudang.entity.Produk;
import java.util.ArrayList;

/**
 *
 * @author Firman
 */
public interface ProdukDAO {
    String getIdProduk(String jenis);
    boolean tambahProduk(Produk produk);
    ArrayList<Produk> tampiltabel(String jenis);
}
