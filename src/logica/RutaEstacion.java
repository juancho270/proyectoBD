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
public class RutaEstacion{
  String id_ruta;
  String id_estacion;

  public RutaEstacion(String id_r, String id_e){
    this.id_ruta = id_r;
    this.id_estacion = id_e;
  }

    public RutaEstacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  public String getId_ruta(){
    return id_ruta;
  }

  public String getId_estacion(){
    return id_estacion;
  }
}
