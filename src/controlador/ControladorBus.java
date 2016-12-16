/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DAOBus;
import java.util.ArrayList;
import logica.Bus;

/**
 *
 * @author Juancho270
 */
public class ControladorBus {
    DAOBus daoBus;

    public ControladorBus() {
        daoBus = new DAOBus();
    }
     public int  insertarBus(String placa, int tipo, String nombreRuta){
        Bus p = new Bus(placa,tipo,nombreRuta);      
        
        //Se llama al dao para guardar
        System.out.println("Se va a insertar un Bus");
        
        int result =daoBus.guardarBus(p);

        System.out.println("Se  insertó  un  nuevo bus");
        
        return result;

    }//end
     
     public Bus consultarBus(String placa){
        Bus p = new Bus();
        
         System.out.println("Se va a consultar un Cliente");

        p= daoBus.consultarBus(placa);
      
       return p;
    }
    
     public ArrayList<Bus> listarEmpleados(){
        ArrayList<Bus> listaBuses = new ArrayList<>();;
        
            System.out.println("Se van a listar los programas");
        listaBuses = daoBus.listarBuses();
        return listaBuses;
    }
    
    public void cerrarConexionBD(){
    }
}
