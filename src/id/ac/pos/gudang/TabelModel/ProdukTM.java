/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.TabelModel;

import id.ac.pos.gudang.entity.Produk;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Firman
 */
public class ProdukTM extends AbstractTableModel {
    
    private ArrayList<Produk> arrayProduk;

    public void setDataProduk(ArrayList<Produk> arrayProduk) {
        this.arrayProduk = arrayProduk;
    }

    @Override
    public int getRowCount() {
        return arrayProduk.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayProduk.get(rowIndex).getId_produk();

            case 1:
                return arrayProduk.get(rowIndex).getNama_produk();

            case 2:
                return arrayProduk.get(rowIndex).getHarga_produk();

          
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id Produk";
                
            case 1:
                return "Nama Produk";
                
            case 2:
                return "Harga Produk";
        }
        return null;
    }

}
