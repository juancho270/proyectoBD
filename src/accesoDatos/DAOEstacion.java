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
import logica.Estacion;

/**
 *
 * @author root
 */
public class DAOEstacion {
    FachadaBD fachada;

    public DAOEstacion() {
        fachada = new FachadaBD();
    }

    public int GuardarEstacion(Estacion est) {
         String sql_guardar;
        sql_guardar="INSERT INTO ESTACION VALUES ('" +
                est.getNombre_estacion()+ "', " + 
                est.getDirector_id()+ " );";
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

    public Estacion consultarEstacion(String nombre) {
        Estacion est = new Estacion();
        String sql_select;
        sql_select = "SELECT * FROM ESTACION WHERE Nombre_estacion = "+nombre;
        try{
            Connection conn= fachada.getConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                
               est.setNombre_estacion(tabla.getString(1));
               est.setDirector_id(tabla.getInt(2));
              System.out.println("ok");
            }
           
           // return emp;
         }
         catch(SQLException e){ System.out.println(e); est = null;}
         catch(Exception e){ System.out.println(e); est = null; }
       // 
       return est;
    }

    public ArrayList<Estacion> listarEstaciones() {
         Estacion unaEstacion;
        ArrayList<Estacion> listaEstaciones = new ArrayList<>();
        String sql_select = "SELECT nombre_estacion,director_id FROM ESTACION;";
        
         try {
            Connection conn = fachada.getConnection();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                unaEstacion = new Estacion();
                unaEstacion.setNombre_estacion(tabla.getString(1));
                unaEstacion.setDirector_id(tabla.getInt(2));
                listaEstaciones.add(unaEstacion);
            }
            

            fachada.closeConnection(conn);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "SIT", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema!!", "SIT", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaEstaciones;
    }
    
     public int cambiarNombre_Estacion(Estacion est){
        String update_statement = "UPDATE ESTACION SET director_id = '" + est.getDirector_id()+ "' WHERE nombre_estacion = " + est.getNombre_estacion();
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
