/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.autorDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.autorModelo;
import vista.Vista_insertar;

/**
 *
 * @author camil
 */
public class ControladorCRUD_VI implements ActionListener{
    
    Vista_insertar vistaCRUD = new Vista_insertar();
    autorDAO Autor = new autorDAO();
    
    public ControladorCRUD_VI(Vista_insertar VistaCRUD,autorDAO Autor){
        this.vistaCRUD = VistaCRUD;
        this.Autor = Autor;
        this.vistaCRUD.Botton_insertar.addActionListener(this);
        this.vistaCRUD.Botton_cancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource()==vistaCRUD.Botton_insertar){
           try{
           String nombre_i=vistaCRUD.text_nombre.getText();
           String nacionalidad_i=vistaCRUD.Text_nacionalidad.getText();
               int edad_i=Integer.parseInt( vistaCRUD.text_edad.getText());
           autorModelo aut =new autorModelo(0,nombre_i,nacionalidad_i,edad_i);
           Autor.CreateAutor(aut,vistaCRUD);
           vistaCRUD.dispose();
           }
           catch(NumberFormatException ex){
              JOptionPane.showMessageDialog(null,"error: Digite solo numeros en la casilla de edad");
        }      
        }
       else if (e.getSource()==vistaCRUD.Botton_cancelar){
            vistaCRUD.dispose();
    }
    }
}
