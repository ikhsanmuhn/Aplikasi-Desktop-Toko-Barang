/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrasi;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author USER
 */
public class dashboard extends javax.swing.JInternalFrame {

    /**
     * Creates new form dashboard
     */
    
    public String barang;
    KoneksiDB k = new KoneksiDB();
    public dashboard() {
        initComponents();
        tampil();
    }
    void tampil(){
        k.query = "Select count(Kode_Barang) as barang from barang";
        k.getData();
        try {
            while(k.rs.next()){
                barang_null.setText(k.rs.getString("barang"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        k.query = "Select count(Kode_Pelanggan) as pelanggan from pelanggan";
        k.getData();
        try {
            while(k.rs.next()){
                pelanggan_null.setText(k.rs.getString("pelanggan"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        k.query = "Select count(Kode_Karyawan) as karyawan from karyawan where left(Kode_Karyawan, 2) = 'PG'";
        k.getData();
        try {
            while(k.rs.next()){
                karyawan_null.setText(k.rs.getString("karyawan"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    String file="/images/bc3.jpg";
    public class Background extends JPanel {
    
    private Image img;
    public Background(String file){
        img = new ImageIcon(getClass().getResource(file)).getImage();
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D gd = (Graphics2D) g.create();
        gd.drawImage(img, 0, 0, getWidth(), getHeight(), null);
        gd.dispose();
    }
    
}
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        panelisi = new Background(file);
        karyawan_null = new javax.swing.JLabel();
        icon_karyawan = new javax.swing.JLabel();
        pelanggan_null = new javax.swing.JLabel();
        icon_pelanggan = new javax.swing.JLabel();
        barang_null = new javax.swing.JLabel();
        icon_barang = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        panelisi.setBackground(new java.awt.Color(255, 255, 255));

        karyawan_null.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        karyawan_null.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        karyawan_null.setText("null");

        icon_karyawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/karyawan.png"))); // NOI18N

        pelanggan_null.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        pelanggan_null.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pelanggan_null.setText("null");

        icon_pelanggan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pelanggan.png"))); // NOI18N

        barang_null.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        barang_null.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        barang_null.setText("null");

        icon_barang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/barang.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelisiLayout = new javax.swing.GroupLayout(panelisi);
        panelisi.setLayout(panelisiLayout);
        panelisiLayout.setHorizontalGroup(
            panelisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelisiLayout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addGroup(panelisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelisiLayout.createSequentialGroup()
                        .addGroup(panelisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelisiLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(icon_barang)
                                .addGap(74, 74, 74)
                                .addComponent(icon_pelanggan)
                                .addGap(74, 74, 74)
                                .addComponent(icon_karyawan))
                            .addGroup(panelisiLayout.createSequentialGroup()
                                .addComponent(barang_null, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(pelanggan_null, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(karyawan_null, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(127, 127, 127))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelisiLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        panelisiLayout.setVerticalGroup(
            panelisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelisiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 325, Short.MAX_VALUE)
                .addGroup(panelisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon_barang)
                    .addComponent(icon_pelanggan)
                    .addGroup(panelisiLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(icon_karyawan)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(karyawan_null)
                    .addComponent(pelanggan_null)
                    .addComponent(barang_null))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 653, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tampil();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barang_null;
    private javax.swing.JLabel icon_barang;
    private javax.swing.JLabel icon_karyawan;
    private javax.swing.JLabel icon_pelanggan;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel karyawan_null;
    private javax.swing.JPanel panelisi;
    private javax.swing.JLabel pelanggan_null;
    // End of variables declaration//GEN-END:variables
}
