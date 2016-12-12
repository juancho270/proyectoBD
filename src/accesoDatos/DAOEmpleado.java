/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.*;
import logica.Empleado;

/**
 *
 * @author root
 */
public class DAOEmpleado {
    FachadaBD fachada;
    
    public DAOEmpleado(){
        fachada = new FachadaBD();
    }
    
    public int GuardarEmpleado(Empleado emp){
        String sql_guardar;
        sql_guardar="INSERT INTO EMPLEADO VALUES (" +
                emp.getEmpleado_id()+ ", " + 
                emp.getCedula()+ ", '"  +
                emp.getNombre() + "', '" +
                emp.getApellido() + "' , " +
                emp.getTelefono() + " , '" +
                emp.getTipo_empleado() + "' )";
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
    
    public Empleado consultarEmpleado(int id_emp){
        Empleado emp = new Empleado();
        String sql_select;
        sql_select = "SELECT empleado_id, cedula, nombre, apellido, telefono, tipo_empleado FROM EMPELADO WHERE empleado_id = "+id_emp;
        try{
            Connection conn= fachada.getConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                
               emp.setEmpleado_id(tabla.getInt(1));
               emp.setCedula(tabla.getInt(2));
               emp.setNombre(tabla.getString(3));
               emp.setApellido(tabla.getString(4));
               emp.setTelefono(tabla.getInt(5));
               emp.setTipo_empleado(tabla.getString(6));
              
              System.out.println("ok");
            }
           
            return emp;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
}
