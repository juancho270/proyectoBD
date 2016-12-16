/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DAOTpersonalizada;
import java.util.ArrayList;
import logica.TPersonalizada;

/**
 *
 * @author Juancho270
 */
public class ControladorTPersonalizada {
    DAOTpersonalizada daoTPersonalizada;

    public ControladorTPersonalizada() {
        daoTPersonalizada = new DAOTpersonalizada();
    }
     public int  insertarTPersonalizada(int tarjeta_id, int saldo, int avances_disponibles){
         TPersonalizada p = new TPersonalizada(tarjeta_id,saldo,avances_disponibles);      
        
        System.out.println("Se va a insertar una Tpersoanlizada");
        
        int result =daoTPersonalizada.GuardarTPersonalizada(p);

        System.out.println("Se  insertó  una nueva Tpersonalizada");
        
        return result;

    }//end
    
     public TPersonalizada consultarTPersonalizada(int tarjeta_id){
        TPersonalizada p = new TPersonalizada();
        
         System.out.println("Se va a consultar una rutaEstacion");

        p= daoTPersonalizada.consultarTPersonalizada(tarjeta_id);
      
       return p;
    }
    
     public ArrayList<TPersonalizada> listarTPersonalizada(){
        ArrayList<TPersonalizada> listaTPersonalizada = new ArrayList<>();;
        
            System.out.println("Se van a listar las TPersonalizadas");
        listaTPersonalizada = daoTPersonalizada.listarTPersonalizada();
        return listaTPersonalizada;
    }
    
    public void cerrarConexionBD(){
    }
}
