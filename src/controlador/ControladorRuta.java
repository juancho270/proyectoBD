/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DAORuta;
import java.util.ArrayList;
import logica.Ruta;


/**
 *
 * @author Juancho270
 */
public class ControladorRuta {
    DAORuta daoRuta;

    public ControladorRuta() {
        daoRuta = new DAORuta();
    }
     public int  insertarRuta(String nombre, String Descripcion,String fecha_inicio,String fecha_final,String franja){
         Ruta p = new Ruta(nombre,Descripcion,fecha_inicio,fecha_final,franja);      
        
        System.out.println("Se va a insertar una Ruta");
        
        int result =daoRuta.GuardarRuta(p);

        System.out.println("Se  insertó  una nueva ruta");
        
        return result;

    }//end
     
     public Ruta consultarRuta(String nombre){
        Ruta p = new Ruta();
        
         System.out.println("Se va a consultar una ruta");

        p= daoRuta.consultarRuta(nombre);
      
       return p;
    }
    
     public ArrayList<Ruta> listarRuta(){
        ArrayList<Ruta> listaRuta = new ArrayList<>();;
        
            System.out.println("Se van a listar los Ruta");
        listaRuta = daoRuta.listarRuta();
        return listaRuta;
    }
    
    public void cerrarConexionBD(){
    }
}
