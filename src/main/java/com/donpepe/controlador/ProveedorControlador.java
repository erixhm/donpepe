package com.donpepe.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import com.donpepe.modelo.Proveedor;
import com.donpepe.modelo.ProveedorDAO;
import com.donpepe.vista.PaginaPrincipal;
import com.donpepe.vista.ProveedorView;

public class ProveedorControlador implements ActionListener{
    private final ProveedorView vista ;
    private final ProveedorDAO dao=new ProveedorDAO();
    private final Proveedor p=new Proveedor();
    private DefaultTableModel modelo=new DefaultTableModel();
    

    public ProveedorControlador(ProveedorView p) {
        this.vista = p;
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnDelete.addActionListener(this);
        this.vista.btnClose.addActionListener(this);
        listar(vista.tabla);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.btnAgregar) {
            add();
            listar(vista.tabla);
        }
        if (e.getSource() == vista.btnEditar) {
            int fila = vista.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "Debe Seleccionar Una fila..!!");
            } else {
                int idproveedor = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
                String nombre = (String) vista.tabla.getValueAt(fila, 1);
                //String propietario = (String) vista.tabla.getValueAt(fila, 2);
                int ruc = Integer.parseInt((String) vista.tabla.getValueAt(fila, 2).toString());
                String direccion = (String) vista.tabla.getValueAt(fila, 3);
                vista.txtIdProveedor.setText(""+idproveedor);
                vista.txtNombre.setText(nombre);
                vista.txtRuc.setText(""+ruc);
                vista.txtDireccion.setText(direccion);
                
            }
        }
        
        if (e.getSource() == vista.btnDelete) {
            delete();
            listar(vista.tabla);
            
        }
        
        if (e.getSource() == vista.btnActualizar) {
            Actualizar();
            listar(vista.tabla);
            Nuevo();

        }
        
        if (e.getSource() == vista.btnClose) {
            listar(vista.tabla);
            
            vista.hide();
        }
    }

    public void Nuevo(){
        vista.txtIdProveedor.setText("");
        vista.txtDireccion.setText("");
        vista.txtNombre.setText("");
        vista.txtRuc.setText("");
        
        vista.txtNombre.requestFocus();
        
    }
    
    
    
    
    
    public void Actualizar() {
        if (vista.txtIdProveedor.getText().equals("")) {
            JOptionPane.showMessageDialog(vista, "No se Identifica el Id debe selecionar la opcion Editar");
        } else {
            int idproveedor = Integer.parseInt(vista.txtIdProveedor.getText());
            String nombre = vista.txtNombre.getText();
            int ruc = Integer.parseInt (vista.txtRuc.getText());
            String direccion = vista.txtDireccion.getText();
            p.setIdProveedor(idproveedor);
            p.setNombre(nombre);
            p.setRuc(ruc);
            p.setDireccion(direccion);
            int r = dao.Actualizar(p);
            if (r == 1) {
                JOptionPane.showMessageDialog(vista, "Proveedor Actualizado con Exito.");
            } else {
                JOptionPane.showMessageDialog(vista, "Error");
            }
        }
        limpiarTabla();
    }

    public void delete() {
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe Seleccionar una Fila...!!!");
        } else {
            int idproveedor = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
            dao.Delete(idproveedor);
            System.out.println("El Resultado es" + idproveedor);
            JOptionPane.showMessageDialog(vista, "Proveedor Eliminado...!!!");
        }
        limpiarTabla();
    }

    public void add() {
        String nombre = vista.txtNombre.getText();
        int ruc = Integer.parseInt (vista.txtRuc.getText());
        String direccion = vista.txtDireccion.getText();
        p.setNombre(nombre);
        p.setRuc(ruc);
        p.setDireccion(direccion);
        int r = dao.agregar(p);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Proveedor Agregado con Exito.");
        } else {
            JOptionPane.showMessageDialog(vista, "Error");
        }
        limpiarTabla();
    }


    public void listar(JTable tabla) {
        centrarCeldas(tabla);
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Proveedor> lista = dao.listar();
        Object[] objeto = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getIdProveedor();
            objeto[1] = lista.get(i).getNombre();
            objeto[2] = lista.get(i).getRuc();
            objeto[3] = lista.get(i).getDireccion();
            modelo.addRow(objeto);
        }
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);

    }

    void centrarCeldas(JTable tabla) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < vista.tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }

    void limpiarTabla() {
        for (int i = 0; i < vista.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    
}
