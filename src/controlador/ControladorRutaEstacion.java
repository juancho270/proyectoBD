/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DAORutaEstacion;
import java.util.ArrayList;
import logica.RutaEstacion;

/**
 *
 * @author Juancho270
 */
public class ControladorRutaEstacion {
    DAORutaEstacion daoRutaEstacion;

    public ControladorRutaEstacion() {
        daoRutaEstacion = new DAORutaEstacion();
    }
     public int  insertarRuta(String id_r, String id_e){
         RutaEstacion p = new RutaEstacion( id_e,id_r);      
        
        System.out.println("Se va a insertar una RutaEstacion");
        
        int result =daoRutaEstacion.GuardarRutaEstacion(p);

        System.out.println("Se  insertó  una nueva rutaEstacion");
        
        return result;

    }//end
    
     public RutaEstacion consultarRutaEstacion(String id_r){
        RutaEstacion p = new RutaEstacion();
        
         System.out.println("Se va a consultar una rutaEstacion");

        p= daoRutaEstacion.consultarRutaEstacion(id_r);
      
       return p;
    }
    
     public ArrayList<RutaEstacion> listarRuta(){
        ArrayList<RutaEstacion> listaRutaEstacion = new ArrayList<>();;
        
            System.out.println("Se van a listar las RutaEstacion");
        listaRutaEstacion = daoRutaEstacion.listarRutaEstacion();
        return listaRutaEstacion;
    }
    
    public void cerrarConexionBD(){
    }
}
