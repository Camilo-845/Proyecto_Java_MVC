/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto_5;
import Modelo.*;
import controlador.*;
import vista.*;
public class RETO_5 {

    public static void main(String[] args) {
        Vista_principal vista_1 =new Vista_principal();
        autorDAO DAO=new autorDAO();
       ControladorCRUD_VP control_1=new ControladorCRUD_VP(vista_1,DAO);
       vista_1.setVisible(true);
    }
    
}
