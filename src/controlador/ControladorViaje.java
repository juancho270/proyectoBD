/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DAOViaje;
import java.util.ArrayList;
import logica.Viaje;

/**
 *
 * @author Juancho270
 */
public class ControladorViaje {
    DAOViaje daoViaje;

    public ControladorViaje() {
        daoViaje = new DAOViaje();
    }
     public int  insertarViaje(String fecha, String hora, int tarjeta_id, String placa_bus){
        Viaje p = new Viaje(fecha,hora,tarjeta_id,placa_bus);      
        
        System.out.println("Se va a insertar un viaje");
        
        int result =daoViaje.GuardarViaje(p);

        System.out.println("Se  insertó  una viajes");
        
        return result;

    }//end
    
     public Viaje consultarViaje(int tarjeta_id){
        Viaje p = new Viaje();
        
         System.out.println("Se va a consultar un viaje");

        p= daoViaje.consultarViaje(tarjeta_id);
      
       return p;
    }
    
     public ArrayList<Viaje> listarViaje(){
        ArrayList<Viaje> listaViaje= new ArrayList<>();;
        
            System.out.println("Se van a listar los viajes");
        listaViaje = daoViaje.listarViaje();
        return listaViaje;
    }
    
    public void cerrarConexionBD(){
    }
}
