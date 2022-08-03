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
import vista.Vista_eliminar;
/**
 *
 * @author camil
 */
public class ControladorCRUD_VE implements ActionListener{
Vista_eliminar vistaCRUD = new Vista_eliminar();
        autorDAO Autor = new autorDAO();
        
        public ControladorCRUD_VE(Vista_eliminar VistaCRUD,autorDAO Autor){
            this.vistaCRUD = VistaCRUD;
            this.Autor = Autor;
            this.vistaCRUD.Botton_eliminar.addActionListener(this);
            this.vistaCRUD.Botton_cancelar.addActionListener(this);
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vistaCRUD.Botton_eliminar){
            try{
            int id_e=Integer.parseInt(vistaCRUD.text_ID.getText());
            Autor.DeleteAutor(id_e,vistaCRUD);
            vistaCRUD.dispose();
            }catch(NumberFormatException ex){
              JOptionPane.showMessageDialog(null,"error: Digite solo números");
        }
        }   
        else if (e.getSource()==vistaCRUD.Botton_cancelar){
           vistaCRUD.dispose();
        }  
    }
    
}
