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
import logica.Medidas;

/**
 *
 * @author root
 */
public class DAOMedidas {
    FachadaBD fachada;

    public DAOMedidas() {
        fachada = new FachadaBD();
    }
    
    public int GuardarMedida(Medidas med) {
        String sql_guardar;
        sql_guardar="INSERT INTO Medida VALUES (" +
                med.getNum_tiquete()+ ", " + 
                med.getMedidas() + "' )";
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

    public Medidas consultarMedidas(int num_tiquete) {
         Medidas med = new Medidas();
        String sql_select;
        sql_select = "SELECT * FROM Medidas WHERE num_tiquete = "+num_tiquete;
        try{
            Connection conn= fachada.getConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                
               med.setNum_tiquete(tabla.getInt(1));
               med.setMedidas(tabla.getString(2));
              System.out.println("ok");
            }
           
           // return emp;
         }
         catch(SQLException e){ System.out.println(e); med = null;}
         catch(Exception e){ System.out.println(e); med = null; }
       // 
       return med;
    }

    public ArrayList<Medidas> listarMedidas() {
        Medidas unaMedida;
        ArrayList<Medidas> listaMedidas = new ArrayList<>();
        String sql_select = "SELECT * FROM MEDIDAS";
        
         try {
            Connection conn = fachada.getConnection();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                unaMedida = new Medidas();
                unaMedida.setNum_tiquete(tabla.getInt(1));
                unaMedida.setMedidas(tabla.getString(2));
                
                listaMedidas.add(unaMedida);
            }
            

            fachada.closeConnection(conn);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "SIT", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema!!", "SIT", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaMedidas;
    }
    
    public int cambiarMedida(Medidas md){
        String update_statement = "UPDATE MEDIDAS SET medida = '" + md.getMedidas()+ "' WHERE num_tiquete = " + md.getNum_tiquete();
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
