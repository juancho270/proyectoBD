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
import logica.Cliente;


/**
 *
 * @author root
 */
public class DAOCliente {
        FachadaBD fachada;

    public DAOCliente() {
        fachada = new FachadaBD();
    }
    public int GuardarCliente(Cliente p) {
        String sql_guardar;
        sql_guardar="INSERT INTO CLIENTE VALUES (" +
                p.getCedula()+ ", " + 
                p.getNombre()+ ", '"  +
                p.getTelefono()+ "', '" +
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

    public Cliente consultarCliente(int cedula) {
        Cliente cli = new Cliente();
        String sql_select;
        sql_select = "SELECT * FROM CLIENTE WHERE cedula = "+cedula;
        try{
            Connection conn= fachada.getConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                
               cli.setCedula(tabla.getInt(1));
               cli.setNombre(tabla.getString(2));
               cli.setTelefono(tabla.getInt(3));
               cli.setTarjeta_id(tabla.getInt(4));
              
              System.out.println("ok");
            }
           
           // return emp;
         }
         catch(SQLException e){ System.out.println(e); cli = null;}
         catch(Exception e){ System.out.println(e); cli = null; }
       // 
       return cli;
    }

    public ArrayList<Cliente> listarClientes() {
        Cliente unCliente;
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        String sql_select = "SELECT * FROM CLIENTE";
        
         try {
            Connection conn = fachada.getConnection();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            while(tabla.next()){
                unCliente = new Cliente();
                unCliente.setCedula(tabla.getInt(1));
                unCliente.setNombre(tabla.getString(2));
                unCliente.setTelefono(tabla.getInt(3));
                unCliente.setTarjeta_id(tabla.getInt(4));
                
                listaClientes.add(unCliente);
            }
            

            fachada.closeConnection(conn);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema con la BD, \n consulta con la base de datos fallida", "SIT", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "SIT", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaClientes;
    }
    
     public int cambiarNombre(Cliente cli){
        String update_statement = "UPDATE CLIENTE SET nombre = '" + cli.getNombre()+ "' WHERE cedula = " + cli.getCedula();
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
    
     public int cambiarTelefono(Cliente cli){
        String update_statement = "UPDATE CLIENTE SET telefono = '" + cli.getTelefono()+ "' WHERE cedula = " + cli.getCedula();
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
     
     public int cambiarIdTarjeta(Cliente cli){
        String update_statement = "UPDATE CLIENTE SET tarjeta_id = '" + cli.getTarjeta_id()+ "' WHERE cedula = " + cli.getCedula();
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
