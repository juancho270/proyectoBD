/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DAOManejoBuses;
import java.util.ArrayList;
import logica.ManejoBuses;

/**
 *
 * @author Juancho270
 */
public class ControladorManejoBuses {
    DAOManejoBuses daoManejoBuses;

    public ControladorManejoBuses() {
        daoManejoBuses = new DAOManejoBuses();
    }
     public int  insertarManejoBuses(int conductor_id, String placa_bus, String turno){
         ManejoBuses p = new ManejoBuses(conductor_id,placa_bus,turno);      
        
        //Se llama al dao para guardar
        System.out.println("Se va a insertar un manejoBuses");
        
        int result =daoManejoBuses.GuardarManejoBuses(p);

        System.out.println("Se  insertó  un nuevo manejoBuses");
        
        return result;

    }//end
     
     public ManejoBuses consultarEstacion(int conductor_id){
        ManejoBuses p = new ManejoBuses();
        
         System.out.println("Se va a consultar un  manejo buses");

        p= daoManejoBuses.consultarManejoBuses(conductor_id);
      
       return p;
    }
    
     public ArrayList<ManejoBuses> listarEstaciones(){
        ArrayList<ManejoBuses> listaManejoBuses = new ArrayList<>();;
        
            System.out.println("Se van a listar los manejoBuses");
        listaManejoBuses = daoManejoBuses.listarManejoBuses();
        return listaManejoBuses;
    }
    
    public void cerrarConexionBD(){
    }
}
