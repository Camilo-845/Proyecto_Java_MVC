/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.json.simple.*;
import org.json.simple.parser.*;

/**
 *
 * @author daesc
 */
public class Conexion {
    
    //public Conexion(){}
    public static Connection getConexion(){
        JSONParser parser = new JSONParser();
        Connection conn = null;
        //conectar
        try{
            String camino_credenciales = System.getProperty("user.dir") +  
                    "/src/utilidades/db_credenciales.json";
            JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(camino_credenciales));
             
            String host     = (String)jsonObject.get("db_ip");
            String port     = (String)jsonObject.get("db_port"); 
            String username = (String)jsonObject.get("db_user");
            String password = (String)jsonObject.get("db_password");
            String dbURL    = "jdbc:mysql://"+host+":"+port+"/spotifytic";
            
            conn = DriverManager.getConnection(dbURL, username, password);
            if( conn != null)   
                System.out.println ("Conectado");
        }
        catch( SQLException | FileNotFoundException ex ){ ex.printStackTrace();}
        catch (IOException | ParseException ex){ ex.printStackTrace();}
        return conn;
        }
}
