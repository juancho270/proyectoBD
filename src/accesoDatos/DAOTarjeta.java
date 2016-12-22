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
import logica.Tarjeta;

/**
 *
 * @author root
 */
public class DAOTarjeta {
    FachadaBD fachada;
    
    public DAOTarjeta(){
        fachada = new FachadaBD();
    }

    public int GuardarTarjeta(Tarjeta p) {
       String sql_guardar;
       sql_guardar = "INSERT INTO TARJETA VALUES ("
               + p.getTarjeta_id()+", "
               + p.getSaldo()+ ", "
               + p.getEstado()+", ";
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

    

    public Tarjeta consultarTarjeta(int tarjeta_id) {
        Tarjeta tar = new Tarjeta();
        String sql_select;
        sql_select = "SELECT * FROM CLIENTE WHERE tarjeta_id = " + tarjeta_id;
        try{
            Connection conn= fachada.getConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                
               tar.setTarjeta_id(tabla.getInt(1));
               tar.setSaldo(tabla.getInt(2));
               tar.setEstado(tabla.getBoolean(3));
              
              System.out.println("ok");
            }
           
           // return emp;
         }
         catch(SQLException e){ System.out.println(e); tar = null;}
         catch(Exception e){ System.out.println(e); tar = null; }
       // 
       return tar;
    }

    public ArrayList<Tarjeta> listarTarjeta() {
        Tarjeta tar;
        ArrayList<Tarjeta> listaTarjetas = new ArrayList<>();
        String sql_select = "SELECT * FROM TARJETA";
        try {
            Connection conn = fachada.getConnection();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                tar = new Tarjeta();
                tar.setTarjeta_id(tabla.getInt(1));
                tar.setSaldo(tabla.getInt(2));
                tar.setEstado(tabla.getBoolean(3));
                
                listaTarjetas.add(tar);
            }
            

            fachada.closeConnection(conn);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "SIT", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema!!", "SIT", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaTarjetas;
    }
    
    public int cambiarSaldo(Tarjeta tar){
        String update_statement = "UPDATE TARJETA SET saldo = " + tar.getSaldo()+ "' WHERE tarjeta_id = " + tar.getTarjeta_id();
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
