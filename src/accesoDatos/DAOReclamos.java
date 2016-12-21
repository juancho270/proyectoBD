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
import logica.Reclamos;

/**
 *
 * @author root
 */
public class DAOReclamos {
        FachadaBD fachada;

    public DAOReclamos() {
        fachada = new FachadaBD();
    }
        
        
    public int GuardarReclamos(Reclamos p) {
         String sql_guardar;
        sql_guardar="INSERT INTO RECLAMOS VALUES (" +
                p.getNum_tiquete()+ ", " + 
                p.getDate()+ ", '"  +
                p.getMotivo()+ "', '" +
                p.getDescripcion()+ "' )";
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

    public Reclamos consultarReclamos(int num_tiquete) {
        Reclamos rec = new Reclamos();
        String sql_select;
        sql_select = "SELECT * FROM RECLAMOS WHERE cedula = "+num_tiquete;
        try{
            Connection conn= fachada.getConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                
               rec.setNum_tiquete(tabla.getInt(1));
               rec.setDate(tabla.getString(2));
               rec.setMotivo(tabla.getString(4));
               rec.setDescripcion(tabla.getString(3));
               
              
              System.out.println("ok");
            }
           
           // return emp;
         }
         catch(SQLException e){ System.out.println(e); rec = null;}
         catch(Exception e){ System.out.println(e); rec = null; }
       // 
       return rec;
    }

    public ArrayList<Reclamos> listarReclamos() {
        Reclamos unReclamo;
        ArrayList<Reclamos> listaReclamos = new ArrayList<>();
        String sql_select = "SELECT * FROM RECLAMOS";
        
         try {
            Connection conn = fachada.getConnection();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                unReclamo = new Reclamos();
                unReclamo.setNum_tiquete(tabla.getInt(1));
                unReclamo.setDate(tabla.getString(2));
                unReclamo.setMotivo(tabla.getString(3));
                unReclamo.setDescripcion(tabla.getString(4));
                listaReclamos.add(unReclamo);
            }
            

            fachada.closeConnection(conn);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "SIT", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema!!", "SIT", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaReclamos;
    }
    
    public int cambiarDate(Reclamos rec){
        String update_statement = "UPDATE RECLAMOS SET fecha = '" + rec.getDate()+ "' WHERE mun_tiquete = " + rec.getNum_tiquete();
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
    public int cambiarMotivo(Reclamos rec){
        String update_statement = "UPDATE RECLAMOS SET motivo = '" + rec.getMotivo()+ "' WHERE mun_tiquete = " + rec.getNum_tiquete();
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
    
    public int cambiarDescripcion(Reclamos rec){
        String update_statement = "UPDATE RECLAMOS SET descripcion = '" + rec.getDescripcion()+ "' WHERE mun_tiquete = " + rec.getNum_tiquete();
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
