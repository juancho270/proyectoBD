/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DAOVentaTarjeta;
import java.util.ArrayList;
import logica.VentaTarjetas;

/**
 *
 * @author Juancho270
 */
public class ControladorVentaTarjetas {
    DAOVentaTarjeta daoVentaTarjeta;

    public ControladorVentaTarjetas() {
        daoVentaTarjeta = new DAOVentaTarjeta();
    }
     public int  insertarVentaTarjeta(int aux, String nombre_estacion, int tarjeta_id){
         VentaTarjetas p = new VentaTarjetas(aux,nombre_estacion,tarjeta_id);      
        
        System.out.println("Se va a insertar una ventaTarjeta");
        
        int result =daoVentaTarjeta.GuardarVentaTarjeta(p);

        System.out.println("Se  insertó  una tarjeta");
        
        return result;

    }//end
    
     public VentaTarjetas consultarVentaTarjetas(int aux){
        VentaTarjetas p = new VentaTarjetas();
        
         System.out.println("Se va a consultar una Venta tarjeta");

        p= daoVentaTarjeta.consultarVentaTarjeta(aux);
      
       return p;
    }
    
     public ArrayList<VentaTarjetas> listarTarjeta(){
        ArrayList<VentaTarjetas> listaVentaTarjeta= new ArrayList<>();;
        
            System.out.println("Se van a listar las Ventas Tarjeta");
        listaVentaTarjeta = daoVentaTarjeta.listarVentaTarjeta();
        return listaVentaTarjeta;
    }
    
    public void cerrarConexionBD(){
    }
}
