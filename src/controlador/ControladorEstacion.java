/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DAOEstacion;
import java.util.ArrayList;
import logica.Estacion;

/**
 *
 * @author Juancho270
 */
public class ControladorEstacion {
    DAOEstacion daoEstacion;

    public ControladorEstacion() {
        daoEstacion = new DAOEstacion();
    }
     public int  insertarEstacion(String nombre, int director_id){
         Estacion p = new Estacion(nombre,director_id);      
        
        //Se llama al dao para guardar
        System.out.println("Se va a insertar una Estacion");
        
        int result =daoEstacion.GuardarEstacion(p);

        System.out.println("Se  insertó  una nueva estacion");
        
        return result;

    }//end
     
     public Estacion consultarEstacion(String nombre){
        Estacion p = new Estacion();
        
         System.out.println("Se va a consultar una Estacion");

        p= daoEstacion.consultarEstacion(nombre);
      
       return p;
    }
    
     public ArrayList<Estacion> listarEstaciones(){
        ArrayList<Estacion> listaEstaciones = new ArrayList<>();;
        
            System.out.println("Se van a listar las estaciones");
        listaEstaciones = daoEstacion.listarEstaciones();
        return listaEstaciones;
    }
    
    public void cerrarConexionBD(){
    }
}
