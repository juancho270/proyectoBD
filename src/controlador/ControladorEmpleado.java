/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import accesoDatos.DAOEmpleado;
import java.util.ArrayList;
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
}
