/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DAOCliente;
import java.util.ArrayList;
import logica.Cliente;

/**
 *
 * @author root
 */
public class ControladorCliente {
    DAOCliente daoCliente;
    
   public ControladorCliente(){
        daoCliente=new DAOCliente();
    }
   
     public int  insertarCliente(int  cedula, String nombres, int telefono, int tarjeta_id){
        Cliente p = new Cliente(cedula,nombres,telefono,tarjeta_id);      
        
        //Se llama al dao para guardar
        System.out.println("Se va a insertar un Cliente");
        
        int result =daoCliente.GuardarCliente(p);

        System.out.println("Se  insertó  un  nuevo Cliente");
        
        return result;

    }//end
     
     public Cliente consultarEmpleado(int cedula){
        Cliente p = new Cliente();
        
         System.out.println("Se va a consultar un Cliente");

        p= daoCliente.consultarCliente(cedula);
      
       return p;
    }
    
     public ArrayList<Cliente> listarClientes(){
        ArrayList<Cliente> listaClientes = new ArrayList<>();;
        
            System.out.println("Se van a listar los clientes");
        listaClientes = daoCliente.listarClientes();
        return listaClientes;
    }
    
    public void cerrarConexionBD(){
        
    }
}
