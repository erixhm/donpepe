package com.donpepe.controlador;

import com.donpepe.modelo.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import com.donpepe.modelo.ClienteDAO;
import com.donpepe.vista.ClientesViewA;
import com.donpepe.vista.DetalleClienteView;
import com.donpepe.vista.PaginaPrincipal;

public class ClientesControlador implements ActionListener{
    
    private final ClientesViewA vista ;
    private final DetalleClienteView vistaDetalle;
            
    private final ClienteDAO dao=new ClienteDAO();
    private final Cliente p=new Cliente();
    private DefaultTableModel modelo=new DefaultTableModel();
    

    public ClientesControlador(ClientesViewA p , DetalleClienteView o) {
        this.vista = p;
        this.vistaDetalle = o;
        this.vista.btnAgregar.addActionListener(this);
        this.vistaDetalle.btnEditar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vistaDetalle.btnDelete.addActionListener(this);
        this.vistaDetalle.btnClose.addActionListener(this);
        listar(vistaDetalle.tabla);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.btnAgregar) {
            add();
            listar(vistaDetalle.tabla);
        }
        if (e.getSource() == vistaDetalle.btnEditar) {
            int fila = vistaDetalle.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "Debe Seleccionar Una fila..!!");
            } else {
                int idcliente = Integer.parseInt((String) vistaDetalle.tabla.getValueAt(fila, 0).toString());
                String nombre = (String) vistaDetalle.tabla.getValueAt(fila, 1);
                String apellido = (String) vistaDetalle.tabla.getValueAt(fila, 2);
                String dni = (String) vistaDetalle.tabla.getValueAt(fila, 3);
                String direccion = (String) vistaDetalle.tabla.getValueAt(fila, 4);
                String telefono = (String) vistaDetalle.tabla.getValueAt(fila, 5);
                String correo = (String) vistaDetalle.tabla.getValueAt(fila, 6);
                //String id = vista.txtId.getText();
                
                JOptionPane.showMessageDialog(vista, idcliente);
                ClientesViewA clieview = new ClientesViewA();
                
                PaginaPrincipal.dpanel.add(clieview);
                clieview.txtIdCliente.setText(""+idcliente);
                clieview.txtNombre.setText(""+nombre);
                clieview.txtApellido.setText(""+apellido);
                clieview.txtDni.setText(""+dni);
                clieview.txtDireccion.setText(""+direccion);
                clieview.txtTelefono.setText(""+telefono);
                clieview.txtCorreo.setText(""+correo);
                clieview.toFront();
                clieview.setVisible(true);
                
            }
           /* int fila = vistaDetalle.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "Debe Seleccionar Una fila..!!");
            } else {
                int idproducto = Integer.parseInt((String) vistaDetalle.tabla.getValueAt(fila, 0).toString());
                String nombre = (String) vistaDetalle.tabla.getValueAt(fila, 1);
                //String propietario = (String) vista.tabla.getValueAt(fila, 2);
                int ruc = Integer.parseInt((String) vistaDetalle.tabla.getValueAt(fila, 2).toString());
                String direccion = (String) vistaDetalle.tabla.getValueAt(fila, 3);
                vista.txtIdCliente.setText(""+idproveedor);
                vista.txtNombre.setText(nombre);
                vista.txtRuc.setText(""+ruc);
                vista.txtDireccion.setText(direccion);
                
            }*/
        }
        
        if (e.getSource() == vistaDetalle.btnDelete) {
            delete();
            listar(vistaDetalle.tabla);
            
        }
        
        if (e.getSource() == vista.btnActualizar) {
            Actualizar();
            listar(vistaDetalle.tabla);
            Nuevo();

        }
        
        if (e.getSource() == vistaDetalle.btnClose) {
            listar(vistaDetalle.tabla);
            
            vista.hide();
        }
    }

    public void Nuevo(){
        vista.txtIdCliente.setText("");
        vista.txtNombre.setText("");
        vista.txtApellido.setText("");
        vista.txtDni.setText("");
        vista.txtDireccion.setText("");
        vista.txtTelefono.setText("");
        vista.txtCorreo.setText("");
        
        vista.txtNombre.requestFocus();
        
    }
    
    
    
    
    
    public void Actualizar() {
        if (vista.txtIdCliente.getText().equals("")) {
            JOptionPane.showMessageDialog(vista, "No se Identifica el Id debe selecionar la opcion Editar");
        } else {
            int idcliente = Integer.parseInt(vista.txtIdCliente.getText());
            String nombre = vista.txtNombre.getText();
            String apellido = vista.txtApellido.getText();
            String dni = vista.txtDni.getText();
            String direccion = vista.txtDireccion.getText();
            String telefono = vista.txtTelefono.getText();
            String correo = vista.txtCorreo.getText();
            p.setIdCliente(idcliente);
            p.setNombres(nombre);
            p.setApellidos(apellido);
            p.setDni(dni);
            p.setDireccion(dni);
            p.setTelefono(telefono);
            p.setCorreo(correo);
            
            p.setDireccion(direccion);
            int r = dao.Actualizar(p);
            if (r == 1) {
                JOptionPane.showMessageDialog(vista, "Cliente Actualizado con Exito.");
            } else {
                JOptionPane.showMessageDialog(vista, "Error");
            }
        }
        limpiarTabla();
    }

    public void delete() {
        int fila = vistaDetalle.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaDetalle, "Debe Seleccionar una Fila...!!!");
        } else {
            int idproveedor = Integer.parseInt((String) vistaDetalle.tabla.getValueAt(fila, 0).toString());
            dao.Delete(idproveedor);
            System.out.println("El Resultado es" + idproveedor);
            JOptionPane.showMessageDialog(vistaDetalle, "Cliente Eliminado...!!!");
        }
        limpiarTabla();
    }

    public void add() {
        String nombre = vista.txtNombre.getText();
        String apellido = vista.txtApellido.getText();
        String dni = vista.txtDni.getText();
        String direccion = vista.txtDireccion.getText();
        String telefono = vista.txtTelefono.getText();
        String correo = vista.txtCorreo.getText();
        
        p.setNombres(nombre);
        p.setApellidos(apellido);
        p.setDni(dni);
        p.setDireccion(direccion);
        p.setTelefono(telefono);
        p.setCorreo(correo);
        int r = dao.agregar(p);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Cliente Agregado con Exito.");
        } else {
            JOptionPane.showMessageDialog(vista, "Error");
        }
        limpiarTabla();
    }


    public void listar(JTable tabla) {
        centrarCeldas(tabla);
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Cliente> lista = dao.listar();
        Object[] objeto = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getIdCliente();
            objeto[1] = lista.get(i).getNombres();
            objeto[2] = lista.get(i).getApellidos();
            objeto[3] = lista.get(i).getDni();
            objeto[4] = lista.get(i).getDireccion();
            objeto[5] = lista.get(i).getTelefono();
            objeto[6] = lista.get(i).getCorreo();
            modelo.addRow(objeto);
        }
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);

    }

    void centrarCeldas(JTable tabla) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < vistaDetalle.tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }

    void limpiarTabla() {
        for (int i = 0; i < vistaDetalle.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    
}
