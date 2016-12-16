/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import logica.ManejoBuses;

/**
 *
 * @author root
 */
public class DAOManejoBuses {
    FachadaBD fachada;

    public DAOManejoBuses() {
        fachada = new FachadaBD();
    }
    
    public int GuardarManejoBuses(ManejoBuses mb) {
        String sql_guardar;
        sql_guardar="INSERT INTO Manejobuses VALUES (" +
                mb.getPlaca_bus()+ ", " + 
                mb.getConductor_id()+ ", '"  +
                mb.getTurno()+ "' )";
        int numFilas = -1;
        try{
            Connection conn= fachada.getConnection();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(sql_guardar);
            conn.close();
            fachada.closeConnection(conn);
            return numFilas;
        }
        catch(SQLException e){ 
            return -2; 
        }
        catch(Exception e){ 
            return -3; 
        }
    }

    public ManejoBuses consultarManejoBuses(int conductor_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<ManejoBuses> listarManejoBuses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
