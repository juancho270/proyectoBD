/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DAOReclamos;
import java.util.ArrayList;
import logica.Reclamos;



/**
 *
 * @author Juancho270
 */
public class ControladorReclamos {
     DAOReclamos daoReclamos;

    public ControladorReclamos() {
        daoReclamos = new DAOReclamos();
    }
    public int  insertarReclamo(int num_tiquete, String date, String motivo, String descripcion){
        Reclamos p = new Reclamos();      
        
        //Se llama al dao para guardar
        System.out.println("Se va a insertar un Reclamo");
        
        int result =daoReclamos.GuardarReclamos(p);

        System.out.println("Se  insertó  un  nuevo reclamo");
        
        return result;

    }//end
    
    public Reclamos consultarEmpleado(int num_tiquete){
        Reclamos p = new Reclamos();
        
         System.out.println("Se va a consultar un Reclamo");

        p= daoReclamos.consultarReclamos(num_tiquete);
      
       return p;
    }
    
     public ArrayList<Reclamos> listarEmpleados(){
        ArrayList<Reclamos> listaEmpleados = new ArrayList<>();;
        
            System.out.println("Se van a listar los Reclamos");
        listaEmpleados = daoReclamos.listarReclamos();
        return listaEmpleados;
    }
    
    public void cerrarConexionBD(){
    }
}
