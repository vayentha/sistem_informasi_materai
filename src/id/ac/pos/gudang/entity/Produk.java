/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.entity;

/**
 *
 * @author Firman
 */
public class Produk {
    String id_produk;
    String nama_produk;
    double harga_produk;
    String id_jenis_produk;

    public String getId_produk() {
        return id_produk;
    }

    public void setId_produk(String id_produk) {
        this.id_produk = id_produk;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public double getHarga_produk() {
        return harga_produk;
    }

    public void setHarga_produk(double harga_produk) {
        this.harga_produk = harga_produk;
    }

    public String getId_jenis_produk() {
        return id_jenis_produk;
    }

    public void setId_jenis_produk(String id_jenis_produk) {
        this.id_jenis_produk = id_jenis_produk;
    }
}
