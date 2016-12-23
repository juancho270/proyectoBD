/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import accesoDatos.DAOEmpleado;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import logica.Empleado;


public class ControladorEmpleado {
   DAOEmpleado daoEmpleado;
   
public ControladorEmpleado(){
        daoEmpleado=new DAOEmpleado();
    }
    public int  insertarEmpleado(int  cedula, String nombre, String apellido, int telefono,String tipo_empleado){
        Empleado p = new Empleado();      
        
        p.setCedula(cedula);
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setTelefono(telefono);
        p.setTipo_empleado(tipo_empleado);
        
        //Se llama al dao para guardar
        System.out.println("Se va a insertar un Empleado");
        
        int result =daoEmpleado.GuardarEmpleado(p);

        System.out.println("Se  insertó  un  nuevo programa");
        
        return result;

    }//end
    
    public void turnos(DefaultTableModel modelo, String ced){
        try {
            
            System.out.println("Entro");
            ResultSet rs = daoEmpleado.turnos(ced);
            
            ResultSetMetaData metadatos = rs.getMetaData();

            //limpiar valores del modelo si existen
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            
            int numCol = metadatos.getColumnCount();
            Object[] nombCol = new Object[numCol];

            //nombres de las etiquetas de las columnas de la consulta
            for (int i = 0; i < nombCol.length; i++) {
                nombCol[i] = metadatos.getColumnName(i + 1);
            }

            //coloca los datos del Resulset en el DefaultTableModel
            modelo.setColumnIdentifiers(nombCol);
            while (rs.next()) {
                Object[] datosFila = new Object[numCol];
                //se sacan los datos de cada fila del rs
                for (int i = 0; i < datosFila.length; i++) {
                    datosFila[i] = rs.getObject(i + 1);
                }
                //se añade la fila al modelo del table
                modelo.addRow(datosFila);
            }            
        } catch (SQLException ex) {
            System.out.println("error al saar la información del resultset");
            
        }
    
    }
    
    
    
    public Empleado consultarEmpleado(int cedula){
        Empleado p = new Empleado();
        
         System.out.println("Se va a consultar un Empleado");

        p= daoEmpleado.consultarEmpleado(cedula);
      
       return p;
    }
    
     public ArrayList<Empleado> listarEmpleados(){
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();;
        
            System.out.println("Se van a listar los programas");
        listaEmpleados = daoEmpleado.listarEmpleados();
        return listaEmpleados;
    }
    
    public void cerrarConexionBD(){
        daoEmpleado.cerrarConexionBD();
    }

    public boolean esEmpleado(String ced) {
        boolean bool = false;
        
        bool = daoEmpleado.esEmpleado(ced);
        
        return bool;      
    
    }
}
