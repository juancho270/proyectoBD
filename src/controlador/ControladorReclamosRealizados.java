/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DAOReclamosRealizados;
import java.util.ArrayList;
import logica.ReclamosRealizados;

/**
 *
 * @author Juancho270
 */
public class ControladorReclamosRealizados {
    DAOReclamosRealizados daoReclamosRealizados;

    public ControladorReclamosRealizados() {
        daoReclamosRealizados = new DAOReclamosRealizados();
    }
     public int  insertarReclamosRealizados(int num_tiquete, int auxiliar_id, int tarjeta_id){
         ReclamosRealizados p = new ReclamosRealizados(num_tiquete,auxiliar_id,tarjeta_id);      
        
        System.out.println("Se va a insertar un Reclamo Realizado");
        
        int result =daoReclamosRealizados.GuardarReclamoRealizado(p);

        System.out.println("Se  insertó  un nuevo reclamo realizado");
        
        return result;

    }//end
     
     public ReclamosRealizados consultarReclamosRealizados(int num_tiquete){
        ReclamosRealizados p = new ReclamosRealizados();
        
         System.out.println("Se va a consultar un reclamo realizado");

        p= daoReclamosRealizados.consultarReclamosRealizados(num_tiquete);
      
       return p;
    }
    
     public ArrayList<ReclamosRealizados> listarReclamosRealizados(){
        ArrayList<ReclamosRealizados> listaReclamosRealizados = new ArrayList<>();;
        
            System.out.println("Se van a listar los Reclamos Realizados");
        listaReclamosRealizados = daoReclamosRealizados.listarReclamosRealizados();
        return listaReclamosRealizados;
    }
    
    public void cerrarConexionBD(){
    }
}
