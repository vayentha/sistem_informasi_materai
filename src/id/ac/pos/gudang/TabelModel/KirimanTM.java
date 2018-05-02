/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.TabelModel;

import id.ac.pos.gudang.entity.Kiriman;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author reyhanadp
 */
public class KirimanTM extends AbstractTableModel {

    private ArrayList<Kiriman> arrayKiriman;

    public void setDataKiriman(ArrayList<Kiriman> arrayKiriman) {
        this.arrayKiriman = arrayKiriman;
    }

    @Override
    public int getRowCount() {
        return arrayKiriman.size();
    }

    @Override
    public int getColumnCount() {
        return 11;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                return arrayKiriman.get(rowIndex).getG14();
            case 1:
                return arrayKiriman.get(rowIndex).getNo_seal();
            case 2:
                return arrayKiriman.get(rowIndex).getJumlah_ktg();
            case 3:
                return arrayKiriman.get(rowIndex).getNo_dus();
            case 4:
                return arrayKiriman.get(rowIndex).getId_kantor();
            case 5:
                return arrayKiriman.get(rowIndex).getNama_produk();
            case 6:
                return arrayKiriman.get(rowIndex).getKopur();
            case 7:
                return arrayKiriman.get(rowIndex).getJumlah();
            case 8:
                return arrayKiriman.get(rowIndex).getBesar_uang();
            case 9:
                return arrayKiriman.get(rowIndex).getNo_ktg();
            case 10:
                return arrayKiriman.get(rowIndex).getTanggal();

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "G14";
            case 1:
                return "No Seal";
            case 2:
                return "KTG";
            case 3:
                return "No Dus";
            case 4:
                return "Nama Kantor";
            case 5:
                return "Nama Benda";
            case 6:
                return "Kopur";
            case 7:
                return "Keping";
            case 8:
                return "Besar Uang";
            case 9:
                return "No KTG";
            case 10:
                return "Tanggal";
        }
        return null;
    }

}
