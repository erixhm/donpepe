package com.donpepe.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import com.donpepe.modelo.Categoria;
import com.donpepe.modelo.CategoriaDAO;
import com.donpepe.vista.CategoriaView;

public class CategoriaControlador implements ActionListener{
    private final CategoriaView vista ;
    private final CategoriaDAO dao=new CategoriaDAO();
    private final Categoria p=new Categoria();
    private DefaultTableModel modelo=new DefaultTableModel();
    

    public CategoriaControlador(CategoriaView p) {
        this.vista = p;
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        //this.vista.btnDelete.addActionListener(this);
        this.vista.btnDelete.setVisible(false);
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
                int idcategoria = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
                String nombre = (String) vista.tabla.getValueAt(fila, 1);
                
                vista.txtIdCategoria.setText(""+idcategoria);
                vista.txtNombre.setText(nombre);
                
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
        vista.txtIdCategoria.setText("");
        vista.txtNombre.setText("");
        
        vista.txtNombre.requestFocus();
        
    }
    
   
    
    public void Actualizar() {
        if (vista.txtIdCategoria.getText().equals("")) {
            JOptionPane.showMessageDialog(vista, "No se Identifica el Id debe selecionar la opcion Editar");
        } else {
            int idcategoria = Integer.parseInt(vista.txtIdCategoria.getText());
            String nombre = vista.txtNombre.getText();
            p.setIdCategoria(idcategoria);
            p.setNombre(nombre);
            
            int r = dao.Actualizar(p);
            if (r == 1) {
                JOptionPane.showMessageDialog(vista, "Categoria Actualizado con Exito.");
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
            int idcategoria = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
            dao.Delete(idcategoria);
            System.out.println("El Resultado es" + idcategoria);
            JOptionPane.showMessageDialog(vista, "Categoria Eliminado...!!!");
        }
        limpiarTabla();
    }

    public void add() {
        String nombre = vista.txtNombre.getText();
        p.setNombre(nombre);
        int r = dao.agregar(p);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Categoria Agregado con Exito.");
        } else {
            JOptionPane.showMessageDialog(vista, "Error");
        }
        limpiarTabla();
    }


    public void listar(JTable tabla) {
        centrarCeldas(tabla);
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Categoria> lista = dao.listar();
        Object[] objeto = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getIdCategoria();
            objeto[1] = lista.get(i).getNombre();
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
