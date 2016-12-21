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
import logica.ReclamosRealizados;

/**
 *
 * @author root
 */
public class DAOReclamosRealizados {
         FachadaBD fachada;

    public DAOReclamosRealizados() {
        fachada = new FachadaBD();
    }
    public int GuardarReclamoRealizado(ReclamosRealizados p) {
         String sql_guardar;
        sql_guardar="INSERT INTO RECLAMOS_REALIZADOS VALUES (" +
                p.getNum_tiquete()+ ", " + 
                p.getAuxiliar_id()+ ", '"  +
                p.getTarjeta_id() + "' )";
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

    public ReclamosRealizados consultarReclamosRealizados(int num_tiquete) {
        ReclamosRealizados rec = new ReclamosRealizados();
        String sql_select;
        sql_select = "SELECT * FROM RECLAMOS_REALIZADOS WHERE cedula = "+num_tiquete;
        try{
            Connection conn= fachada.getConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                
               rec.setNum_tiquete(tabla.getInt(1));
               rec.setAuxiliar_id(tabla.getInt(2));
               rec.setTarjeta_id(tabla.getInt(4));
              System.out.println("ok");
            }
           
           // return emp;
         }
         catch(SQLException e){ System.out.println(e); rec = null;}
         catch(Exception e){ System.out.println(e); rec = null; }
       // 
       return rec;
    }

    

    public ArrayList<ReclamosRealizados> listarReclamosRealizados() {
         ReclamosRealizados unReclamoRealizado;
        ArrayList<ReclamosRealizados> listaReclamosRealizados = new ArrayList<>();
        String sql_select = "SELECT * FROM RECLAMOS_REALIZADOS";
        
         try {
            Connection conn = fachada.getConnection();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                unReclamoRealizado = new ReclamosRealizados();
                unReclamoRealizado.setNum_tiquete(tabla.getInt(1));
                unReclamoRealizado.setAuxiliar_id(tabla.getInt(2));
                unReclamoRealizado.setTarjeta_id(tabla.getInt(3));
                listaReclamosRealizados.add(unReclamoRealizado);
            }
            

            fachada.closeConnection(conn);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "SIT", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema!!", "SIT", JOptionPane.ERROR_MESSAGE);
        }
             
        
        return listaReclamosRealizados;
    }
}
