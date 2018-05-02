/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Dialog;

import id.ac.pos.gudang.DAO.KirimanDAO;
import id.ac.pos.gudang.DAOImpl.KirimanDAOImpl;
import id.ac.pos.gudang.Frame.FrameUtama;
import id.ac.pos.gudang.entity.Kiriman;
import id.ac.pos.gudang.entity.Produk;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Firman
 */
public class DialogTambahMaterai extends javax.swing.JDialog {

    String jenis;
    KirimanDAO kirimanDAO = new KirimanDAOImpl();
    Vector vectorProduk = new Vector();

    /**
     * Creates new form DialogTambahMaterai
     */
    public DialogTambahMaterai(java.awt.Frame parent, boolean modal) {

    }

    public DialogTambahMaterai(FrameUtama frameUtama, boolean b, String jenis) {
        super(frameUtama, b);
        initComponents();
        this.setResizable(false);
        this.jenis = jenis;

        this.setLocationRelativeTo(null);
        AutoCompleteDecorator.decorate(fieldNamaProduk);

        ArrayList<Produk> arrayProduk = kirimanDAO.getNamaProduk(jenis);

        vectorProduk.add("- Pilih Nama Produk -");

        for (int i = 0; i < arrayProduk.size(); i++) {
            vectorProduk.add(arrayProduk.get(i).getNama_produk());
        }

        fieldNamaProduk.setModel(new DefaultComboBoxModel(vectorProduk));

        tableMaterai.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},
                new String[]{
                    "G14", "Tanggal", "No Seal", "KTG", "No Dus", "Nama Kantor", "Benda", "Kopur", "Keping", "Besar Uang", "No KTG"
                }));

        Date ys = new Date();
        datePilihTanggal.setDate(ys);
        datePilihTanggal.setMaxSelectableDate(ys);
        
        buttonHapus.setEnabled(false);
        buttonSimpan.setEnabled(false);
        buttonBatal.setEnabled(false);
    }
    
    private void reset_simpan() {
        DefaultTableModel model = (DefaultTableModel) tableMaterai.getModel();

        int baris = tableMaterai.getRowCount();
        for (int i = 0; i < baris; i++) {
            model.removeRow(0);
        }
        
        
        fieldG14.setText("");
        Date ys = new Date();
        datePilihTanggal.setDate(ys);
        fieldNoSeal.setText("");
        fieldNoDus.setText("");
        fieldKTG.setText("");
        fieldNamaProduk.setSelectedIndex(0);
        fieldNamaKantor.setText("");
        fieldKeping.setText("");
        fieldKopur.setText("");
        fieldBesarUang.setText("");
        fieldNoKTG.setText("");
        
        buttonSimpan.setEnabled(false);
        buttonBatal.setEnabled(false);
        buttonHapus.setEnabled(false);
    }
    
    private void reset(){
        fieldG14.setText("");
        Date ys = new Date();
        datePilihTanggal.setDate(ys);
        fieldNoSeal.setText("");
        fieldNoDus.setText("");
        fieldKTG.setText("");
        fieldNamaProduk.setSelectedIndex(0);
        fieldNamaKantor.setText("");
        fieldKeping.setText("");
        fieldKopur.setText("");
        fieldBesarUang.setText("");
        fieldNoKTG.setText("");
    }

    private String hilangkan_titik(String text_titik) {
        String[] temp = text_titik.split("\\.");
        String text_string = "";
        for (int i = 0; i < temp.length; i++) {
            text_string = text_string + temp[i];
        }
        return text_string;
    }

    private String format_titik(String text_string) {
        int j = 0, i, n;
        String text_hasil = "";
        int k = 2, l = 3, m = 4;
        int panjang_text = text_string.length();
        String[] text_pisah = text_string.split("(?<=\\G.{1})");

        while (j == 0) {
            if (panjang_text == k) {
                n = k;
                for (i = 0; i < k; i++) {
                    if (n % 3 == 0) {
                        text_hasil = text_hasil + "." + text_pisah[i];
                    } else {
                        text_hasil = text_hasil + text_pisah[i];
                    }
                    n--;
                }
                j = 1;
            } else if (panjang_text == l) {
                n = l;
                for (i = 0; i < l; i++) {
                    if (n % 3 == 0) {
                        if (n == l) {
                            text_hasil = text_hasil + text_pisah[i];
                        } else {
                            text_hasil = text_hasil + "." + text_pisah[i];
                        }
                    } else {
                        text_hasil = text_hasil + text_pisah[i];
                    }
                    n--;
                }
                j = 1;
            } else if (panjang_text == m) {
                n = m;
                for (i = 0; i < m; i++) {
                    if (n % 3 == 0) {
                        text_hasil = text_hasil + "." + text_pisah[i];
                    } else {
                        text_hasil = text_hasil + text_pisah[i];
                    }
                    n--;
                }
                j = 1;
            } else if (panjang_text == 1) {
                text_hasil = text_pisah[0];
                j = 1;
            } else if (panjang_text == 0) {
                text_hasil = "";
                j = 1;
            }
            k = k + 3;
            l = l + 3;
            m = m + 3;
        }
        return text_hasil;

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        fieldG14 = new javax.swing.JTextField();
        fieldNoSeal = new javax.swing.JTextField();
        fieldKTG = new javax.swing.JTextField();
        fieldNoDus = new javax.swing.JTextField();
        fieldNamaKantor = new javax.swing.JTextField();
        fieldKeping = new javax.swing.JTextField();
        fieldBesarUang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMaterai = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        datePilihTanggal = new com.toedter.calendar.JDateChooser();
        buttonSimpan = new javax.swing.JButton();
        buttonBatal = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        fieldNamaProduk = new javax.swing.JComboBox<>();
        fieldKopur = new javax.swing.JTextField();
        buttonTambah = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();
        fieldNoKTG = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Kiriman Materai"));
        jPanel1.setPreferredSize(new java.awt.Dimension(915, 530));

        jLabel1.setText("G14");

        jLabel2.setText("No Seal");

        jLabel3.setText("KTG");

        jLabel4.setText("Nama Kantor");

        jLabel5.setText("No Dus");

        jLabel6.setText("Benda");

        jLabel9.setText("Keping");
        jLabel9.setPreferredSize(new java.awt.Dimension(63, 14));

        jLabel10.setText("Besar Uang");

        jLabel11.setText("No KTG");

        fieldKeping.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldKepingKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldKepingKeyTyped(evt);
            }
        });

        fieldBesarUang.setEditable(false);

        tableMaterai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableMaterai);

        jLabel7.setText("Tanggal");

        datePilihTanggal.setDateFormatString("yyyy-MM-dd");
        datePilihTanggal.setMaxSelectableDate(new java.util.Date(253370743275000L));
        datePilihTanggal.setMinSelectableDate(new java.util.Date(-62135791125000L));

        buttonSimpan.setText("Simpan");
        buttonSimpan.setPreferredSize(new java.awt.Dimension(75, 23));
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });

        buttonBatal.setText("Batal");
        buttonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBatalActionPerformed(evt);
            }
        });

        jLabel8.setText("Kopur");

        fieldNamaProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNamaProdukActionPerformed(evt);
            }
        });

        fieldKopur.setEditable(false);

        buttonTambah.setText("Tambah");
        buttonTambah.setPreferredSize(new java.awt.Dimension(75, 23));
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });

        buttonReset.setText("Reset");
        buttonReset.setPreferredSize(new java.awt.Dimension(75, 23));
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });

        buttonHapus.setText("Hapus");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNamaKantor))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fieldBesarUang))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fieldKopur, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(datePilihTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                    .addComponent(fieldNoDus)
                                    .addComponent(fieldNamaProduk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fieldKeping)
                                    .addComponent(fieldNoKTG)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fieldKTG))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fieldNoSeal))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fieldG14, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldG14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(datePilihTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNoSeal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNoDus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldKTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNamaKantor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldKopur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldBesarUang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNoKTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonHapus))
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonBatal)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldKeping, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldKepingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldKepingKeyReleased
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if ((((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            String keping_string = hilangkan_titik(fieldKeping.getText());
            String keping_hasil = format_titik(keping_string);
            fieldKeping.setText(keping_hasil);

            if (fieldKeping.getText().compareTo("") != 0 && fieldKopur.getText().compareTo("") != 0) {
                Long keping = Long.parseLong(keping_string);
                Long kopur = Long.parseLong(hilangkan_titik(fieldKopur.getText()));

                String besar_uang_string = hilangkan_titik(Long.toString(keping * kopur));
                String besar_uang_hasil = format_titik(besar_uang_string);
                fieldBesarUang.setText(besar_uang_hasil);
            } else {
                fieldBesarUang.setText("");
            }
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_fieldKepingKeyReleased

    private void buttonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBatalActionPerformed
        // TODO add your handling code here:
        reset_simpan();
    }//GEN-LAST:event_buttonBatalActionPerformed

    private void fieldNamaProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNamaProdukActionPerformed
        // TODO add your handling code here:
        Object nama_produk = fieldNamaProduk.getSelectedItem();
        if (nama_produk != "- Pilih Nama Produk -") {
            ArrayList<Produk> arrayProduk = kirimanDAO.getKopur(jenis, (String) nama_produk);
            String kopur = format_titik(Long.toString(arrayProduk.get(0).getHarga_produk()));
            fieldKopur.setText(kopur);

            String keping = fieldKeping.getText();
            if (!keping.equals("")) {
                keping = hilangkan_titik(keping);
                long besar_uang = arrayProduk.get(0).getHarga_produk() * Long.parseLong(keping);
                fieldBesarUang.setText(format_titik(Long.toString(besar_uang)));
            }
        } else {
            fieldKopur.setText("");
            fieldBesarUang.setText("");
        }

    }//GEN-LAST:event_fieldNamaProdukActionPerformed

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        // TODO add your handling code here:
        int baris = tableMaterai.getRowCount();
        String G14 = fieldG14.getText();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date Tanggal = (java.util.Date) datePilihTanggal.getDate();

        String NoSeal = fieldNoSeal.getText();
        String KTG = fieldKTG.getText();
        String NoDus = fieldNoDus.getText();
        String NamaKantor = fieldNamaKantor.getText();
        Object NamaProduk = fieldNamaProduk.getSelectedItem();
        String Kopur = fieldKopur.getText();
        String Keping = fieldKeping.getText();
        String BesarUang = fieldBesarUang.getText();
        String NoKTG = fieldNoKTG.getText();

        if (G14.compareTo("") != 0) {
            if (Tanggal != null) {
                if (NoSeal.compareTo("") != 0) {
                    if (KTG.compareTo("") != 0) {
                        if (NoDus.compareTo("") != 0) {
                            if (NamaKantor.compareTo("") != 0) {
                                    if (Kopur.compareTo("") != 0) {
                                        if (Keping.compareTo("") != 0) {
                                                if (NoKTG.compareTo("") != 0) {

                                                    datePilihTanggal.setEnabled(true);

                                                    DefaultTableModel dataModel = (DefaultTableModel) tableMaterai.getModel();
                                                    List list = new ArrayList<>();
                                                    tableMaterai.setAutoCreateColumnsFromModel(true);
                                                    list.add(G14);
                                                    list.add(dateFormat.format(Tanggal));
                                                    list.add(NoSeal);
                                                    list.add(KTG);
                                                    list.add(NoDus);
                                                    list.add(NamaKantor);
                                                    list.add(NamaProduk);
                                                    list.add(Kopur);
                                                    list.add(Keping);
                                                    list.add(BesarUang);
                                                    list.add(NoKTG);
                                                    dataModel.addRow(list.toArray());
                                                    
                                                    reset();
                                                    buttonSimpan.setEnabled(true);
                                                    buttonBatal.setEnabled(true);
                                                    buttonHapus.setEnabled(true);
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Silakan isi No Kantong terlebih dahulu!");
                                                }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Silakan isi Jumlah Keping terlebih dahulu!");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Silakan pilih Nama Produk terlebih dahulu!");
                                    }
                            } else {
                                JOptionPane.showMessageDialog(null, "Silakan isi Nama Kantor terlebih dahulu!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Silakan isi No Dus terlebih dahulu!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Silakan isi Kantong terlebih dahulu!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Silakan isi No Seal terlebih dahulu!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Silakan pilih Tanggal terlebih dahulu!");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Silakan isi G14 terlebih dahulu!");
        }
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_buttonResetActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        // TODO add your handling code here:
        String G14, Tanggal, NoSeal, NoDus, KTG, NamaProduk, NamaKantor, Kopur, Keping, BesarUang, NoKTG;
        int baris_pilih = tableMaterai.getSelectedRow();
        if (baris_pilih >= 0) {

            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan "
                    + "menghapus G14 : " + tableMaterai.getValueAt(baris_pilih, 0).toString()
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (ok == 0) {
                DefaultTableModel model = (DefaultTableModel) tableMaterai.getModel();
                model.removeRow(baris_pilih);

                int baris = tableMaterai.getRowCount();
                if (baris == 0) {
                    buttonHapus.setEnabled(false);
                    buttonSimpan.setEnabled(false);
                    buttonBatal.setEnabled(false);
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu produk yang akan dihapus!");
        }
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        // TODO add your handling code here:
        String G14, Tanggal, NoSeal, NoDus, KTG, NamaProduk, NamaKantor, Kopur, Keping, BesarUang, NoKTG;
        int pilih = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menyimpan?",
                "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (pilih == JOptionPane.YES_OPTION) {
            boolean sukses = false;
            String kosong = null;
            int stok_produk;
            int i;
            int banyak_baris = tableMaterai.getRowCount();

//            java.util.Date tanggal_pengiriman = (java.util.Date) TanggalPengiriman.getDate();
            for (i = 0; i < banyak_baris; i++) {
                G14 = tableMaterai.getValueAt(0, 0).toString();
                Tanggal = tableMaterai.getValueAt(0, 1).toString();
                NoSeal = tableMaterai.getValueAt(0, 2).toString();
                NoDus = tableMaterai.getValueAt(0, 4).toString();
                KTG = tableMaterai.getValueAt(0, 3).toString();
                NamaProduk = tableMaterai.getValueAt(0, 6).toString();
                NamaKantor = tableMaterai.getValueAt(0, 5).toString();
                Kopur = tableMaterai.getValueAt(0, 7).toString();
                Keping = tableMaterai.getValueAt(0, 8).toString();
                BesarUang = tableMaterai.getValueAt(0, 9).toString();
                NoKTG = tableMaterai.getValueAt(0, 10).toString();

                //hilangkan titik
                String besar_uang_hasil = hilangkan_titik(BesarUang);

                //autoincrement id_pengembalian
                String id_produk = kirimanDAO.getIdProduk(NamaProduk);

                Kiriman kiriman = new Kiriman();
                kiriman.setG14(G14);
                kiriman.setNo_seal(NoSeal);
                kiriman.setJumlah_ktg(Integer.parseInt(KTG));
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    kiriman.setTanggal(dateFormat.parse(Tanggal));
                } catch (ParseException ex) {
                    Logger.getLogger(DialogTambahMaterai.class.getName()).log(Level.SEVERE, null, ex);
                }
                kiriman.setNo_dus(NoDus);
                kiriman.setId_kantor(NamaKantor);
                kiriman.setId_produk(id_produk);
                kiriman.setJumlah(Integer.parseInt(hilangkan_titik(Keping)));
                kiriman.setBesar_uang(Long.parseLong(besar_uang_hasil));
                kiriman.setNo_ktg(NoKTG);
                sukses = kirimanDAO.SimpanKiriman(kiriman);

            }

            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
                reset_simpan();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
                reset_simpan();
            }

            pilih = JOptionPane.showConfirmDialog(null, "Apakah anda akan menambahkan data lagi?",
                    "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilih == JOptionPane.NO_OPTION) {
                this.dispose();
            }

        }
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void fieldKepingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldKepingKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldKepingKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogTambahMaterai.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogTambahMaterai.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogTambahMaterai.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogTambahMaterai.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogTambahMaterai dialog = new DialogTambahMaterai(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBatal;
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JButton buttonTambah;
    private com.toedter.calendar.JDateChooser datePilihTanggal;
    private javax.swing.JTextField fieldBesarUang;
    private javax.swing.JTextField fieldG14;
    private javax.swing.JTextField fieldKTG;
    private javax.swing.JTextField fieldKeping;
    private javax.swing.JTextField fieldKopur;
    private javax.swing.JTextField fieldNamaKantor;
    private javax.swing.JComboBox<String> fieldNamaProduk;
    private javax.swing.JTextField fieldNoDus;
    private javax.swing.JTextField fieldNoKTG;
    private javax.swing.JTextField fieldNoSeal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMaterai;
    // End of variables declaration//GEN-END:variables
}
