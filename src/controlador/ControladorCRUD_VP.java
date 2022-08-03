/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Vista_principal;
import Modelo.autorDAO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.Vista_Actualizar;
import vista.Vista_eliminar;
import vista.Vista_insertar;
/**
 *
 * @author camil
 */
public class ControladorCRUD_VP implements ActionListener{
    //variables
    Vista_principal vistaCRUD = new Vista_principal();
    autorDAO Autor = new autorDAO();
    
    //Constructor
    public ControladorCRUD_VP(Vista_principal VistaCRUD,autorDAO Autor){
        this.vistaCRUD = VistaCRUD;
        this.Autor = Autor;
        this.vistaCRUD.Button_buscar.addActionListener(this);
        this.vistaCRUD.Button_Insertar.addActionListener(this);
        this.vistaCRUD.button_modificar.addActionListener(this);
        this.vistaCRUD.Button_eliminar.addActionListener(this);
        llenarTabla(vistaCRUD.Tabla);
    }
    //Metodos
    
    public void InicializarCRUD_VP(){
        
    }
    
    public void llenarTabla(JTable Tabla){
        DefaultTableModel modeloT =new DefaultTableModel();
        Tabla.setModel(modeloT);
        modeloT.addColumn("ID");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Nacionalidad");
        modeloT.addColumn("Edad");
        
        Object[] columna =new Object[4];
        int numAutores=Autor.ReadAutor().size();
        for (int i = 0; i < numAutores; i++) {
            columna[0]=Autor.ReadAutor().get(i).getId();
            columna[1]=Autor.ReadAutor().get(i).getNombre();
            columna[2]=Autor.ReadAutor().get(i).getNacionalidad();
            columna[3]=Autor.ReadAutor().get(i).getEdad();
            modeloT.addRow(columna);
        }
    }    
    
    @Override
    //acciones de botones
    public void actionPerformed(ActionEvent e) {
         if (e.getSource()==vistaCRUD.Button_buscar){
            String nombre=vistaCRUD.JText_buscar.getText();
            DefaultTableModel modeloT =new DefaultTableModel();
            vistaCRUD.Tabla.setModel(modeloT);
            modeloT.addColumn("ID");
            modeloT.addColumn("Nombre");
            modeloT.addColumn("Nacionalidad");
            modeloT.addColumn("Edad");

            Object[] columna =new Object[4];
            int numAutores=Autor.SearchAutor(nombre).size();
            for (int i = 0; i < numAutores; i++) {
                columna[0]=Autor.SearchAutor(nombre).get(i).getId();
                columna[1]=Autor.SearchAutor(nombre).get(i).getNombre();
                columna[2]=Autor.SearchAutor(nombre).get(i).getNacionalidad();
                columna[3]=Autor.SearchAutor(nombre).get(i).getEdad();
                modeloT.addRow(columna);
        }
        }
         if (e.getSource()==vistaCRUD.Button_Insertar){
             Vista_insertar vista_i =new Vista_insertar();
             autorDAO autor_i= new autorDAO();
            ControladorCRUD_VI Controlador_i=new ControladorCRUD_VI(vista_i,autor_i);
            vista_i.setVisible(true);
        }
          if (e.getSource()==vistaCRUD.button_modificar){
             Vista_Actualizar vista_m =new Vista_Actualizar();
             autorDAO autor_m= new autorDAO();
            ControladorCRUD_VM Controlador_=new ControladorCRUD_VM(vista_m,autor_m);
            vista_m.setVisible(true);
        }
           if (e.getSource()==vistaCRUD.Button_eliminar){
            Vista_eliminar vista_e =new Vista_eliminar();
             autorDAO autor_m= new autorDAO();
            ControladorCRUD_VE Controlador_=new ControladorCRUD_VE(vista_e,autor_m);
            vista_e.setVisible(true);
        }
    }
    
}
