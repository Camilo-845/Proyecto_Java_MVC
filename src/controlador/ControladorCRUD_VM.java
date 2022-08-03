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
import vista.Vista_Actualizar;
/**
 *
 * @author camil
 */
public class ControladorCRUD_VM implements ActionListener{
    
        Vista_Actualizar vistaCRUD = new Vista_Actualizar();
        autorDAO Autor = new autorDAO();
        
        public ControladorCRUD_VM(Vista_Actualizar VistaCRUD,autorDAO Autor){
            this.vistaCRUD = VistaCRUD;
            this.Autor = Autor;
            this.vistaCRUD.Botton_modificar.addActionListener(this);
            this.vistaCRUD.Botton_cancelar.addActionListener(this);
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vistaCRUD.Botton_modificar){
            try{
            int id_m=Integer.parseInt(vistaCRUD.Text_ID.getText());
            String nombre_m=vistaCRUD.text_nombre.getText();
            String nacionalidad_m=vistaCRUD.Jtext_nacionalidad.getText();
            int edad_m=Integer.parseInt(vistaCRUD.text_edad.getText());
            autorModelo aut=new autorModelo(id_m,nombre_m,nacionalidad_m,edad_m);
            Autor.UpdateAutor(aut,vistaCRUD);
            vistaCRUD.dispose();
        }catch(NumberFormatException ex){
              JOptionPane.showMessageDialog(null,"error: Digite solo numeros en la casilla de edad");
        }       
        }
        else if(e.getSource()==vistaCRUD.Botton_cancelar){
           vistaCRUD.dispose();
    }
    }
    
}
