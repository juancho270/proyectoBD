/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DAOMedidas;
import java.util.ArrayList;
import logica.Medidas;

/**
 *
 * @author Juancho270
 */
public class ControladorMedidas {
    DAOMedidas daoMedidas;

    public ControladorMedidas() {
        daoMedidas = new DAOMedidas();
    }
     public int  insertarMedidas(int num_tiquete, String medidas){
         Medidas p = new Medidas(num_tiquete,medidas);      
        
        //Se llama al dao para guardar
        System.out.println("Se va a insertar una medida");
        
        int result =daoMedidas.GuardarMedida(p);

        System.out.println("Se  insertó  un nuevo manejoBuses");
        
        return result;

    }//end
     
     public Medidas consultarMedidas(int num_tiquete){
        Medidas p = new Medidas();
        
         System.out.println("Se va a consultar una medida");

        p= daoMedidas.consultarMedidas(num_tiquete);
      
       return p;
    }
    
     public ArrayList<Medidas> listarMedidas(){
        ArrayList<Medidas> listaMedidas = new ArrayList<>();;
        
            System.out.println("Se van a listar los manejoBuses");
        listaMedidas = daoMedidas.listarMedidas();
        return listaMedidas;
    }
    
    public void cerrarConexionBD(){
    }
}
