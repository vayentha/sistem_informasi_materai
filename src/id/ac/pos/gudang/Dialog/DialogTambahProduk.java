/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Dialog;

import id.ac.pos.gudang.DAO.ProdukDAO;
import id.ac.pos.gudang.DAOImpl.ProdukDAOImpl;
import id.ac.pos.gudang.Frame.FrameUtama;
import id.ac.pos.gudang.entity.Produk;
import javax.swing.JOptionPane;

/**
 *
 * @author Firman
 */
public class DialogTambahProduk extends javax.swing.JDialog {

    String jenis;
    ProdukDAO produkDAO = new ProdukDAOImpl();

    /**
     * Creates new form DialogTambahProduk
     */
    public DialogTambahProduk(java.awt.Frame parent, boolean modal) {

    }

    public DialogTambahProduk(FrameUtama frameUtama, boolean b, String jenis) {
        super(frameUtama, b);
        initComponents();
        this.setLocationRelativeTo(null);
        this.jenis = jenis;
        String id_produk = produkDAO.getIdProduk(this.jenis);
        id_produk = autoIncrementProduk(id_produk);
        System.out.println(id_produk);
        fieldKodeProduk.setText(id_produk);

    }

    private String autoIncrementProduk(String id_produk) {
        String kosong = null;
        String sub_nomor_string = null;

        if (id_produk != null) {

            kosong = null;
            sub_nomor_string = id_produk.substring(3, 6);
            int sub_nomor_int = Integer.parseInt(sub_nomor_string);
            sub_nomor_int = sub_nomor_int + 1;
            sub_nomor_string = String.valueOf(sub_nomor_int);
            int panjang = sub_nomor_string.length();
            switch (panjang) {
                case 1:
                    kosong = "00";
                    break;
                case 2:
                    kosong = "0";
                    break;
                case 3:
                    kosong = null;
                    break;
                default:
                    break;
            }
        } else {
            kosong = "00";
            sub_nomor_string = "1";
        }

        return this.jenis + kosong + sub_nomor_string;
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
        fieldKodeProduk = new javax.swing.JTextField();
        fieldNamaProduk = new javax.swing.JTextField();
        fieldHargaProduk = new javax.swing.JTextField();
        buttonSimpan = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dialog Produk"));

        jLabel1.setText("Kode Produk");

        jLabel2.setText("Nama Produk");

        jLabel3.setText("Harga");

        fieldKodeProduk.setEditable(false);
        fieldKodeProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldKodeProdukActionPerformed(evt);
            }
        });

        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });

        buttonReset.setText("Reset");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fieldHargaProduk))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fieldKodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonReset)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldKodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldHargaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSimpan)
                    .addComponent(buttonReset))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldKodeProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldKodeProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldKodeProdukActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        // TODO add your handling code here:
        String id_produk = fieldKodeProduk.getText();
        String nama_produk = fieldNamaProduk.getText();
        String harga_produk = fieldHargaProduk.getText();

        if (fieldKodeProduk.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
            fieldKodeProduk.requestFocus();
            fieldKodeProduk.setEditable(true);
        } else if (fieldNamaProduk.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
            fieldNamaProduk.requestFocus();
            fieldNamaProduk.setEditable(true);
        } else if ((fieldHargaProduk.getText().equals(""))) {
            JOptionPane.showMessageDialog(null, "Harga Produk tidak boleh Kosong");
            fieldHargaProduk.requestFocus();
            fieldHargaProduk.setEditable(true);
        }else{
            int pilih = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menyimpan " + nama_produk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilih == JOptionPane.YES_OPTION) {
                //buat objek pegawai
                Produk produk = new Produk();
                produk.setId_produk(id_produk);
                produk.setNama_produk(nama_produk);
                produk.setHarga_produk(Double.parseDouble(harga_produk) );
                produk.setId_jenis_produk(this.jenis);


                boolean sukses = produkDAO.tambahProduk(produk);

                //cek sukses atau tidak
                if (sukses) {
                    JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
                } else {
                    JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
                }
            }
        }
        
    }//GEN-LAST:event_buttonSimpanActionPerformed
    
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
            java.util.logging.Logger.getLogger(DialogTambahProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogTambahProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogTambahProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogTambahProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogTambahProduk dialog = new DialogTambahProduk(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JTextField fieldHargaProduk;
    private javax.swing.JTextField fieldKodeProduk;
    private javax.swing.JTextField fieldNamaProduk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}