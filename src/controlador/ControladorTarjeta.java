/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DAOTarjeta;
import java.util.ArrayList;
import logica.Tarjeta;

/**
 *
 * @author Juancho270
 */
public class ControladorTarjeta {
     DAOTarjeta daoTarjeta;

    public ControladorTarjeta() {
        daoTarjeta = new DAOTarjeta();
    }
     public int  insertarTarjeta(int tarjeta_id, int saldo, boolean estado){
         Tarjeta p = new Tarjeta(tarjeta_id,saldo,estado);      
        
        System.out.println("Se va a insertar una Tarjeta");
        
        int result =daoTarjeta.GuardarTarjeta(p);

        System.out.println("Se  insertó  una tarjeta");
        
        return result;

    }//end
    
     public Tarjeta consultarTarjeta(int tarjeta_id){
        Tarjeta p = new Tarjeta();
        
         System.out.println("Se va a consultar una tarjeta");

        p= daoTarjeta.consultarTarjeta(tarjeta_id);
      
       return p;
    }
    
     public ArrayList<Tarjeta> listarTarjeta(){
        ArrayList<Tarjeta> listaTarjeta= new ArrayList<>();;
        
            System.out.println("Se van a listar las Tarjeta");
        listaTarjeta = daoTarjeta.listarTarjeta();
        return listaTarjeta;
    }
    
    public void cerrarConexionBD(){
    }
}
