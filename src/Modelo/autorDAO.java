/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.autorModelo;
import utilidades.Conexion;
import javax.swing.JFrame;
import java.lang.NumberFormatException;

/**
 *
 * @author daesc
 */
public class autorDAO {
    private Connection conn = null;
    
    public ArrayList<autorModelo> SearchAutor(String nombre){
        ArrayList<autorModelo> autores = new ArrayList<>();
        try{
            if(conn == null)
                conn = Conexion.getConexion();
            
             String sql = "SELECT * FROM autor WHERE nombre LIKE ? ;";
             PreparedStatement statement = conn.prepareStatement(sql); 
             statement.setString(1,"%"+nombre+"%");
             ResultSet resultado = statement.executeQuery();
             while(resultado.next()){
                 autorModelo autor = new autorModelo(resultado.getInt(1),
                 resultado.getString(2),resultado.getString(3), resultado.getInt(4));
                 autores.add(autor);
             }
        }
        catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        } 
        return autores;
    }
    
    public void CreateAutor(autorModelo autor,JFrame vista){
        try{
            if(conn == null)
                conn = Conexion.getConexion();
            
            String sql = "INSERT INTO autor(nombre, nacionalidad, edad) VALUES "
                    + "(?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, autor.getNombre());
            statement.setString(2, autor.getNacionalidad());
            statement.setInt   (3, autor.getEdad());
            int columnaInsertada = statement.executeUpdate();
            if (columnaInsertada>0)
                JOptionPane.showMessageDialog(null, "Se inserto correctamente");         
        }catch(SQLException | NumberFormatException ex){
        JOptionPane.showMessageDialog(null,"error");  
        vista.dispose();
     }
    }
    
    
    public ArrayList<autorModelo> ReadAutor(){
        ArrayList<autorModelo> autores = new ArrayList<>();
        try{
            if(conn == null)
                conn = Conexion.getConexion();
            
             String sql ="SELECT * FROM autor";
             Statement statement = conn.createStatement(); 
             ResultSet resultado = statement.executeQuery(sql);
             while(resultado.next()){
                 autorModelo autor = new autorModelo(resultado.getInt(1),
                 resultado.getString(2),resultado.getString(3), resultado.getInt(4));
                 autores.add(autor);
             }
        }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());} 
        return autores;
    }
    
    
    
    public  void UpdateAutor(autorModelo autor,JFrame vista){
        try{
            if(conn == null)
                conn = Conexion.getConexion();
            
            String sql = "UPDATE autor SET nombre=?, nacionalidad=?, edad=? "
                    + "WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, autor.getNombre());
            statement.setString(2, autor.getNacionalidad());
            statement.setInt   (3, autor.getEdad());
            statement.setInt   (4, autor.getId());
            int columnaInsertada = statement.executeUpdate();
        }catch(SQLException | NumberFormatException ex){
        JOptionPane.showMessageDialog(null,"error");}
        vista.dispose();
        }
    
    public void DeleteAutor(int id,JFrame vista){
        try{
            if(conn == null)
                conn = Conexion.getConexion();
            
            String sql = "DELETE FROM autor WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);            
            statement.setInt (1, id);
            int columnaInsertada = statement.executeUpdate();
            if (columnaInsertada>0)
                JOptionPane.showMessageDialog(null, "eliminado");     
        }catch(SQLException | NumberFormatException ex){
        JOptionPane.showMessageDialog(null,"error");
        vista.dispose();
        }
    }
}
