package com.donpepe.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.donpepe.vista.PaginaPrincipal;
import com.donpepe.vista.ProveedorView;
import com.donpepe.vista.CategoriaView;
import com.donpepe.vista.ClientesViewA;
import com.donpepe.vista.DetalleClienteView;
import com.donpepe.vista.DetalleVentasView;
import com.donpepe.vista.ProductoView;
import com.donpepe.vista.RegistroVentaView;
import com.donpepe.vista.VentaDeliveryView;



public class PagPrincipalControlador implements ActionListener{
    
    private final PaginaPrincipal princ;
    
    public PagPrincipalControlador(PaginaPrincipal l){
        this.princ = l;
        
        this.princ.btnProveedor.addActionListener(this);
        this.princ.btnCategoria.addActionListener(this);
        this.princ.btnRegistroCliente.addActionListener(this); 
        this.princ.btnDetalleCliente.addActionListener(this);
        this.princ.btnProducto.addActionListener(this);
        this.princ.btnDetalleVenta.addActionListener(this);
        this.princ.btnRegistroVenta.addActionListener(this);
        this.princ.btnDetalleDelivery.addActionListener(this);
    }

    @Override
   public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == princ.btnProveedor) {
            ProveedorView proveedor = new ProveedorView();
            this.princ.dpanel.add(proveedor);
             proveedor.show();
            //inicio.setVisible(true);
        }
        if (e.getSource() == princ.btnCategoria) {
            CategoriaView categoria = new CategoriaView();
            this.princ.dpanel.add(categoria);
             categoria.show();
            categoria.setVisible(true);
        }
        
         if (e.getSource() == princ.btnRegistroCliente) {
            ClientesViewA CliReg = new ClientesViewA();
            this.princ.dpanel.add(CliReg);
             CliReg.show();
            CliReg.setVisible(true);
        }
        
        if (e.getSource() == princ.btnDetalleCliente) {
            DetalleClienteView CliDet = new DetalleClienteView();
            this.princ.dpanel.add(CliDet);
             CliDet.show();
            CliDet.setVisible(true);
        }
        
        if (e.getSource() == princ.btnProducto) {
            ProductoView prod = new ProductoView();
            this.princ.dpanel.add(prod);
             prod.show();
            prod.setVisible(true);
        }
        
        if (e.getSource() == princ.btnDetalleVenta) {
            DetalleVentasView DetVe = new DetalleVentasView();
            this.princ.dpanel.add(DetVe);
            DetVe.show();
            DetVe.setVisible(true);
        }
        
         if (e.getSource() == princ.btnRegistroVenta) {
            RegistroVentaView RegVen = new RegistroVentaView();
            this.princ.dpanel.add(RegVen);
            RegVen.show();
            RegVen.setVisible(true);
        }
        
        if (e.getSource() == princ.btnDetalleDelivery) {
            VentaDeliveryView VenDel = new VentaDeliveryView();
            this.princ.dpanel.add(VenDel);
            VenDel.show();
            VenDel.setVisible(true);
        }
        
        
        
        
        
        
    }
}



