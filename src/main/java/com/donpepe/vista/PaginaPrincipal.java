
package com.donpepe.vista;

import com.donpepe.controlador.PagPrincipalControlador;


public class PaginaPrincipal extends javax.swing.JFrame {

   private PagPrincipalControlador controlador;
   
    public PaginaPrincipal() {
        
        initComponents();
        estilo();
       this.setLocationRelativeTo(null);
       
      controlador = new PagPrincipalControlador(this);  
        
        
    }

  private void estilo() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpanel = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnDetalleVenta = new javax.swing.JMenuItem();
        btnRegistroVenta = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        btnDetalleCliente = new javax.swing.JMenuItem();
        btnRegistroCliente = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        btnProducto = new javax.swing.JMenuItem();
        btnProveedor = new javax.swing.JMenuItem();
        btnCategoria = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        btnDetalleDelivery = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dpanel.setBackground(new java.awt.Color(0, 153, 204));

        javax.swing.GroupLayout dpanelLayout = new javax.swing.GroupLayout(dpanel);
        dpanel.setLayout(dpanelLayout);
        dpanelLayout.setHorizontalGroup(
            dpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1142, Short.MAX_VALUE)
        );
        dpanelLayout.setVerticalGroup(
            dpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 831, Short.MAX_VALUE)
        );

        jMenu1.setText("Inicio");

        btnExit.setText("Salir");
        jMenu1.add(btnExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Venta");

        btnDetalleVenta.setText("DetalleVenta");
        jMenu2.add(btnDetalleVenta);

        btnRegistroVenta.setText("RegistroVenta");
        jMenu2.add(btnRegistroVenta);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Clientes");

        btnDetalleCliente.setText("DetalleCliente");
        jMenu4.add(btnDetalleCliente);

        btnRegistroCliente.setText("RegistroCliente");
        jMenu4.add(btnRegistroCliente);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Almacen");

        btnProducto.setText("Productos");
        jMenu5.add(btnProducto);

        btnProveedor.setText("Proveedor");
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });
        jMenu5.add(btnProveedor);

        btnCategoria.setText("Categoria");
        jMenu5.add(btnCategoria);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Delivery");

        btnDetalleDelivery.setText("DetalleDelivery");
        jMenu6.add(btnDetalleDelivery);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpanel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProveedorActionPerformed

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaPrincipal().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem btnCategoria;
    public javax.swing.JMenuItem btnDetalleCliente;
    public javax.swing.JMenuItem btnDetalleDelivery;
    public javax.swing.JMenuItem btnDetalleVenta;
    public javax.swing.JMenuItem btnExit;
    public javax.swing.JMenuItem btnProducto;
    public javax.swing.JMenuItem btnProveedor;
    public javax.swing.JMenuItem btnRegistroCliente;
    public javax.swing.JMenuItem btnRegistroVenta;
    public static javax.swing.JDesktopPane dpanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
