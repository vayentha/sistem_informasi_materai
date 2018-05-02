/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.entity;

import java.util.Date;

/**
 *
 * @author Firman
 */
public class Kiriman {
    String g14;
    String no_seal;
    int jumlah_ktg;
    Date tanggal;
    String no_dus;
    String id_kantor;
    String id_produk;
    int jumlah;
    long besar_uang;
    String no_ktg;
    String nama_produk;
    String kopur;

    public String getKopur() {
        return kopur;
    }

    public void setKopur(String kopur) {
        this.kopur = kopur;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public String getG14() {
        return g14;
    }

    public void setG14(String g14) {
        this.g14 = g14;
    }

    public String getNo_seal() {
        return no_seal;
    }

    public void setNo_seal(String no_seal) {
        this.no_seal = no_seal;
    }

    public int getJumlah_ktg() {
        return jumlah_ktg;
    }

    public void setJumlah_ktg(int jumlah_ktg) {
        this.jumlah_ktg = jumlah_ktg;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    
    public String getNo_dus() {
        return no_dus;
    }

    public void setNo_dus(String no_dus) {
        this.no_dus = no_dus;
    }

    public String getId_kantor() {
        return id_kantor;
    }

    public void setId_kantor(String id_kantor) {
        this.id_kantor = id_kantor;
    }

    public String getId_produk() {
        return id_produk;
    }

    public void setId_produk(String id_produk) {
        this.id_produk = id_produk;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public long getBesar_uang() {
        return besar_uang;
    }

    public void setBesar_uang(long besar_uang) {
        this.besar_uang = besar_uang;
    }

    public String getNo_ktg() {
        return no_ktg;
    }

    public void setNo_ktg(String no_ktg) {
        this.no_ktg = no_ktg;
    }
    
    
}
