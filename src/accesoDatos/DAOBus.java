/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

/**
 *
 * @author root
 */

import logica.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class DAOBus {
    FachadaBD fachada;
    public DAOBus(){
        fachada = new FachadaBD();
    }
    
    public int guardarBus(Bus bus){
        String sql_guardar;
        int numFilas = 0;
        sql_guardar = "INSERT INTO BUS VALUES ('"
                + bus.getPlaca()+ "', "
                + bus.getTipo()+", '"
                + bus.getNombreRuta()+"')";
        try{
            Connection conn= fachada.getConnection();
            Statement sentencia = conn.createStatement();

            numFilas = sentencia.executeUpdate(sql_guardar);            
            System.out.println("up " + numFilas);
            return numFilas;
            
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        return -1;
    }//fin guardar
    
    public Bus consultarBus(String placa){
        Bus bus = new Bus();
        String sql_select;
        sql_select = "SELECT placa, tipo, nombre_ruta FROM BUS WHERE placa = '"+placa+"'";
        try{
            Connection conn= fachada.getConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                
               bus.setPlaca(tabla.getString(1));
               bus.setTipo(tabla.getInt(2));
               bus.setNombreRuta(tabla.getString(3));              
              
              System.out.println("ok");
            }
           
            return bus;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public ArrayList<Bus> listarBuses(){
        Bus unBus;
        ArrayList<Bus> listaBuses = new ArrayList<>();
        String sql_select = "SELECT placa, tipo, nombre_ruta FROM BUS";
        
         try {
            Connection conn = fachada.getConnection();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                unBus = new Bus();
                unBus.setPlaca(tabla.getString(1));
                unBus.setTipo(tabla.getInt(2));
                unBus.setNombreRuta(tabla.getString(3));
                
                listaBuses.add(unBus);
            
            }
            

            fachada.closeConnection(conn);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "AutosABC", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema!!", "AutosABC", JOptionPane.ERROR_MESSAGE);
        }
         
         return listaBuses;
    }

}
