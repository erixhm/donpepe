package com.donpepe.controlador;

import com.donpepe.modelo.Usuario;
import com.donpepe.modelo.UsuarioDAO;
import com.donpepe.vista.PaginaPrincipal;
import com.donpepe.vista.login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LoginControlador implements ActionListener{
    private final login login ;
    private final UsuarioDAO dao=new UsuarioDAO();
    
    public LoginControlador (login l){
        this.login = l;
        this.login.btnIngresar.addActionListener(this);
        this.login.btnCerrar.addActionListener(this);
     }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login.btnIngresar) {

            String usuario = login.txtUsuario.getText();
            char clave[] = login.txtClave.getPassword();
            
            String clavedef=new String(clave);
            if(clavedef.isEmpty() || usuario.isEmpty()){
                JOptionPane.showMessageDialog(null, "Debe digitar un Usuario y una Contraseña", "Error en la Operación", JOptionPane.ERROR_MESSAGE);
            }else{
                ArrayList<Usuario> list;
                list = dao.logueo(usuario, clavedef);
                if(list.size()>0){
                    JOptionPane.showMessageDialog(null, "¡¡Bienvenido al Sistema!!", "DONPEPE", JOptionPane.INFORMATION_MESSAGE);
                    login.dispose();
                    PaginaPrincipal inicio = new PaginaPrincipal();
                    //inicio.setExtendedState(MAXIMIZED_BOTH);
                    inicio.setVisible(true);
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Acceso denegado", "ERR.", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }
        if (e.getSource() == login.btnCerrar) {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta Seguro Que Desea Salir Del Sistema?");
            
            if(confirmar==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
    }
}
