/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author root
 */
public class VentaTarjetas {
    int auxiliar_id;
    String nombre_estacion;
    int tarjeta_id;

    public VentaTarjetas(int aux, String nombre_estacion, int tarjeta_id){
      this.auxiliar_id = aux;
      this.nombre_estacion = nombre_estacion;
      this.tarjeta_id = tarjeta_id;
    }

    public VentaTarjetas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getAuxiliar_id(){
      return auxiliar_id;
    }

    public String getNombre_estacion(){
      return nombre_estacion;
    }

    public int getTarjeta_id(){
      return tarjeta_id;
    }

    public void setAuxiliar_id(int auxiliar_id) {
        this.auxiliar_id = auxiliar_id;
    }

    public void setNombre_estacion(String nombre_estacion) {
        this.nombre_estacion = nombre_estacion;
    }

    public void setTarjeta_id(int tarjeta_id) {
        this.tarjeta_id = tarjeta_id;
    }
}
