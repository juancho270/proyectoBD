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
import logica.Ruta;

/**
 *
 * @author root
 */
public class DAORuta {
    FachadaBD fachada;
    public DAORuta() {
        fachada = new FachadaBD();
    }
    
    public int GuardarRuta(Ruta p) {
        String sql_guardar;
        sql_guardar="INSERT INTO RUTA VALUES ('" +
                p.getNombre()+ "','" + 
                p.getDescripcion()+ "','" +
                p.getFecha_inicio() + "','" +
                p.getFecha_final() + "','"+
                p.getFranja_horaria() + "');";
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

    public Ruta consultarRuta(String nombre) {
        Ruta rut = new Ruta();
        String sql_select;
        sql_select = "SELECT * FROM RUTA WHERE nombre = "+nombre;
        try{
            Connection conn= fachada.getConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                
               rut.setNombre(tabla.getString(1));
               rut.setDescripcion(tabla.getString(2));
              
              System.out.println("ok");
            }
           
           // return emp;
         }
         catch(SQLException e){ System.out.println(e); rut = null;}
         catch(Exception e){ System.out.println(e); rut = null; }
       // 
       return rut;
    }

    public ArrayList<Ruta> listarRuta() {
        Ruta unaRuta;
        ArrayList<Ruta> listaRuta = new ArrayList<>();
        String sql_select = "SELECT * FROM RUTA";
        
         try {
            Connection conn = fachada.getConnection();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                unaRuta = new Ruta();
                unaRuta.setNombre(tabla.getString(1));
                unaRuta.setDescripcion(tabla.getString(2));
                listaRuta.add(unaRuta);
            }
            

            fachada.closeConnection(conn);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "SIT", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema!!", "SIT", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaRuta;
    }
     public int cambiarDescripcion(Ruta rut){
        String update_statement = "UPDATE RUTA SET descripcion = '" + rut.getDescripcion()+ "' WHERE nombre = " + rut.getNombre();
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
     
     public int eliminarRuta(String nombre){
        String sql_guardar;
        int numFilas = 0;
        sql_guardar = "DELETE FROM Ruta WHERE nombre = '" + nombre + "';";
                
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
     
}
