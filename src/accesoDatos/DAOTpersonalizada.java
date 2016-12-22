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
import logica.TPersonalizada;

/**
 *
 * @author root
 */
public class DAOTpersonalizada {

    FachadaBD fachada;
    public DAOTpersonalizada(){
        fachada = new FachadaBD();
    }
    public int GuardarTPersonalizada(TPersonalizada p) {
        String sql_guardar;
        sql_guardar="INSERT INTO T_PERSONALIZADA VALUES (" +
                p.getTarjeta_id()+ ", " + 
                p.avancesDisponibles()+ ", '";
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

    public TPersonalizada consultarTPersonalizada(int tarjeta_id) {
        TPersonalizada tper = new TPersonalizada();
        String sql_select;
        sql_select = "SELECT * FROM T_PERSONALIZADA WHERE tarjeta_id = "+tarjeta_id;
        try{
            Connection conn= fachada.getConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                
               tper.setTarjeta_id(tabla.getInt(1));
               tper.setAvances_disponibles(tabla.getInt(2));
               
              
              System.out.println("ok");
            }
           
           // return emp;
         }
         catch(SQLException e){ System.out.println(e); tper = null;}
         catch(Exception e){ System.out.println(e); tper = null; }
       // 
       return tper;
    }

    public ArrayList<TPersonalizada> listarTPersonalizada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int cambiarAvances(TPersonalizada tper){
        String update_statement = "UPDATE T_PERSONALIZADA SET avances_disponibles = " + tper.avancesDisponibles()+ " WHERE tarjeta_id = " + tper.getTarjeta_id();
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
