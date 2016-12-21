/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
        sql_guardar="INSERT INTO MANEJO_BUSES VALUES (" +
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
        ManejoBuses mb = new ManejoBuses();
        String sql_select;
        sql_select = "SELECT * FROM MANEJO_BUSES WHERE conductor_id = "+conductor_id;
        try{
            Connection conn= fachada.getConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                
               mb.setConductor_id(tabla.getInt(1));
               mb.setPlaca_bus(tabla.getString(2));
               mb.setTurno(tabla.getString(3));
              
              System.out.println("ok");
            }
           
           // return emp;
         }
         catch(SQLException e){ System.out.println(e); mb = null;}
         catch(Exception e){ System.out.println(e); mb = null; }
       // 
       return mb;
    }

    public ArrayList<ManejoBuses> listarManejoBuses() {
        ManejoBuses unManejoBuses;
        ArrayList<ManejoBuses> listaManejoBuses = new ArrayList<>();
        String sql_select = "SELECT * FROM MANEJO_BUSES";
        
         try {
            Connection conn = fachada.getConnection();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                unManejoBuses = new ManejoBuses();
                unManejoBuses.setConductor_id(tabla.getInt(1));
                unManejoBuses.setPlaca_bus(tabla.getString(2));
                unManejoBuses.setTurno(tabla.getString(3));
                listaManejoBuses.add(unManejoBuses);
            }
            

            fachada.closeConnection(conn);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "SIT", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema!!", "SIT", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaManejoBuses;
    }
    
    public int cambiarPlacaBus(ManejoBuses mb){
        String update_statement = "UPDATE MANEJO_BUSES SET placa_bus = '" + mb.getPlaca_bus()+ "' WHERE conductor_id = " + mb.getConductor_id();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnection();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConnection(conn);
            return numFilas;
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
    }
    
     public int cambiarTurno(ManejoBuses mb){
        String update_statement = "UPDATE MANEJO_BUSES SET turno = '" + mb.getTurno()+ "' WHERE conductor_id = " + mb.getConductor_id();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnection();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConnection(conn);
            return numFilas;
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
    }
}
